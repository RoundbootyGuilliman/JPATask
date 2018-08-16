package com.epam.jpatask.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "findBob", query = "select employee from Employee employee where employee.personal.firstName = 'Bob'")
public class Employee {
	
	@Id
	@GeneratedValue
	private int employeeId;
	private String title;
	@Enumerated(EnumType.STRING)
	private EmployeeStatus employeeStatus;
	@Embedded
	private Address address;
	
	@OneToOne
	@JoinColumn(name = "personal_fk")
	private Personal personal;
	
	@ManyToOne
	@JoinColumn(name = "unit_fk")
	private Unit unit;
	
	@ManyToMany
	@JoinTable(name = "employees_to_projects",
			joinColumns = @JoinColumn(name = "employee_fk"),
			inverseJoinColumns = @JoinColumn(name = "project_fk"))
	private List<Project> projects;
	
	public Employee() {
	}
	
	public Employee(String title, EmployeeStatus employeeStatus, Address address, Personal personal, Unit unit, List<Project> projects) {
		this.title = title;
		this.employeeStatus = employeeStatus;
		this.address = address;
		this.personal = personal;
		this.unit = unit;
		this.projects = projects;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public EmployeeStatus getEmployeeStatus() {
		return employeeStatus;
	}
	
	public void setEmployeeStatus(EmployeeStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Personal getPersonal() {
		return personal;
	}
	
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	
	public Unit getUnit() {
		return unit;
	}
	
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	public List<Project> getProjects() {
		return projects;
	}
	
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}
