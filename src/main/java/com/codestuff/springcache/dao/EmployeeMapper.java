package com.codestuff.springcache.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.codestuff.springcache.pojo.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
			employee.setEmpId(rs.getString("EMP_ID"));
			employee.setName(rs.getString("NAME"));
			employee.setPlace(rs.getString("PLACE"));
		return employee;
	}

}
