package com.devil.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
/**
 * 
 * @author Ramakrishna Janapureddy
 *
 */
public class Employee implements Comparable<Employee>, Serializable{
	private static final long serialVersionUID = 1L;
	private Integer empId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Integer managerId;
	private String dept;
	private Double salary;
	private String gender = "U";
	private Date dateOfJoining;
	private String status;
	private String lastModUser;
	private Timestamp lastModTimeDate;
	private String additionalInfo;
	
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
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLastModUser() {
		return lastModUser;
	}
	public void setLastModUser(String lastModUser) {
		this.lastModUser = lastModUser;
	}
	public Timestamp getLastModTimeDate() {
		return lastModTimeDate;
	}
	public void setLastModTimeDate(Timestamp lastModTimeDate) {
		this.lastModTimeDate = lastModTimeDate;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	@Override
	public int compareTo(Employee o) {
		if(this.getEmpId()<o.getEmpId()) {
			return -1;
		}
		return 0;
	}
}
