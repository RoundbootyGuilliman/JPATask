package com.epam.jpatask.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Unit {
	
	@Id
	@GeneratedValue
	private Long unitId;
	private String unitName;
	@OneToMany(mappedBy = "unit")
	private List<Employee> employees;
	
	public Unit() {
	}
	
	public Unit(String unitName, List<Employee> employees) {
		this.unitName = unitName;
		this.employees = employees;
	}
	
	public Long getUnitId() {
		return unitId;
	}
	
	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}
	
	public String getUnitName() {
		return unitName;
	}
	
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
