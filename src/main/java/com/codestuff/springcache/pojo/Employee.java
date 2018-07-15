package com.codestuff.springcache.pojo;

public class Employee {
	
	private String empId;
	private String name;
	private String place;
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	public String toString() {
		StringBuffer emp = new StringBuffer("EMPID=").append(this.empId).append(" ")
									.append("NAME=").append(this.name).append(" ")
									.append("PLACE=").append(this.place);
		
		return emp.toString();
	}
	
}
