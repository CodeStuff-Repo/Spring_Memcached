package com.codestuff.springcache.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codestuff.springcache.dao.EmployeeDAO;
import com.codestuff.springcache.pojo.Employee;

import net.spy.memcached.MemcachedClient;

@Service
public class EmployeeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private MemcachedClient cacheClient;
	
	public String getName(String empID) {
		String name = null;
		if(cacheClient.get(empID)==null) {
			LOGGER.info("Couldn't find EMPID in cache. Fetching from DB.");
			name = employeeDAO.get(empID).getName();
			cacheClient.add(empID, 0, name);
		} else {
			LOGGER.info("You are lucky, EMPID detected in cache.");
			name = (String) cacheClient.get(empID);
		}
		return name;
	}
	
	public List<Employee> getAll() {
		return employeeDAO.getAll();
	}
	
	public void update(Employee employee) {
		cacheClient.delete(employee.getEmpId());
		LOGGER.info("Cache deleted for "+employee.getEmpId());
		employeeDAO.update(employee);
	}
	
	public void flushCache() {
		cacheClient.flush();
	}
}
