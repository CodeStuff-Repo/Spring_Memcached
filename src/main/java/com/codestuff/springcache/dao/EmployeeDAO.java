package com.codestuff.springcache.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.codestuff.springcache.pojo.Employee;

@Component
public class EmployeeDAO implements IEmployeeDAO {
	
	private static final String INSERT = "INSERT INTO EMPLOYEE(EMP_ID,NAME,PLACE) VALUES(?,?,?)";
	private static final String FETCH  = "SELECT * FROM EMPLOYEE WHERE EMP_ID=?";
	private static final String FETCH_ALL  = "SELECT * FROM EMPLOYEE";
	private static final String UPDATE = "UPDATE EMPLOYEE SET NAME=?, PLACE=? WHERE EMP_ID=?"; 
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(Employee employee) {
		jdbcTemplate.update(INSERT,employee.getEmpId(),employee.getName(),employee.getPlace());

	}
	
	@Override
	public Employee get(String empID) {
		return jdbcTemplate.queryForObject(FETCH, new EmployeeMapper(),empID);
	}
	
	@Override
	public List<Employee> getAll() {
		return jdbcTemplate.query(FETCH_ALL, new EmployeeMapper());
	}

	@Override
	public void update(Employee employee) {
		jdbcTemplate.update(UPDATE,employee.getName(),employee.getPlace(),employee.getEmpId());
	}

}
