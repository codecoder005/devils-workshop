package com.devil.model;

import java.io.Serializable;

public class Employee implements Comparable<Employee>, Serializable{
	private Integer empId;
	private String firstName;
	private String dept;
	
	private String message;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int compareTo(Employee o) {
		if(this.getEmpId()<o.getEmpId()) {
			return -1;
		}else if(this.getEmpId()==o.getEmpId()) {
			return 0;
		}
		return 1;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", dept=" + dept + ", message=" + message
				+ "]";
	}
	
	
}
