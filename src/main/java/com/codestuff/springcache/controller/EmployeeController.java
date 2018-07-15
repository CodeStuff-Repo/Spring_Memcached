package com.codestuff.springcache.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codestuff.springcache.dao.EmployeeDAO;
import com.codestuff.springcache.pojo.Employee;
import com.codestuff.springcache.service.EmployeeService;


@RestController
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/")
    public String index() {
        return "OK";
    }
	
	@RequestMapping(path="/insert")
	public void insert(@RequestParam String name, @RequestParam String place) {
		Employee emp = new Employee();
			emp.setEmpId(""+System.currentTimeMillis());
			emp.setName(name);
			emp.setPlace(place);
		employeeDAO.insert(emp);
		LOGGER.info("Employee has been created. "+emp);
	}
	
	@RequestMapping(path="/update")
	public void update(@RequestParam String empid, @RequestParam String name, @RequestParam String place) {
		Employee emp = new Employee();
			emp.setEmpId(empid);
			emp.setName(name);
			emp.setPlace(place);
		service.update(emp);
		LOGGER.info("Employee updated. "+emp);
	}
	
	@RequestMapping(path="/fetchName")
	public String get(String empID) {
		return empID+" : "+service.getName(empID);
	}
	
	@RequestMapping(path="/fetchAll",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAll() {
		LOGGER.info("Fetching all employees.");
		return service.getAll();
	}
	
	@RequestMapping(path="/flush")
	public void flushCache() {
		service.flushCache();
		LOGGER.info("All cache has been flushed.");
	}
}
