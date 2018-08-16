package com.epam.jpatask.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Personal {
	
	@Id
	@GeneratedValue
	private Long employeeId;
	private String firstName;
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	@OneToOne(mappedBy = "personal")
	private Employee employee;
	
	public Personal() {
	}
	
	public Personal(String firstName, String lastName, Date birthday, Employee employee) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.employee = employee;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
