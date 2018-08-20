package com.epam.jpatask.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Project {
	
	@Id
	@GeneratedValue
	private int projectId;
	private String projectName;
	
	public Project() {
	}
	
	public Project(String projectName) {
		this.projectName = projectName;
	}
	
	public int getProjectId() {
		return projectId;
	}
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
