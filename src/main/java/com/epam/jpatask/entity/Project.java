package com.epam.jpatask.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Project {
	
	@Id
	@GeneratedValue
	private Long projectId;
	private String projectName;
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;
	
	public Project() {
	}
	
	public Project(String projectName, List<Employee> employees) {
		this.projectName = projectName;
		this.employees = employees;
	}
	
	public Long getProjectId() {
		return projectId;
	}
	
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
