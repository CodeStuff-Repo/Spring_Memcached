package com.codestuff.springcache.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.codestuff.springcache.pojo.Employee;

@Repository
public interface IEmployeeDAO {
	
	public void insert(Employee employee);
	public Employee get(String empID);
	public List<Employee> getAll();
	public void update(Employee employee);
}
