package com.epam.jpatask.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Unit {
	
	@Id
	@GeneratedValue
	private int unitId;
	private String unitName;
	@OneToMany(mappedBy = "unit")
	private List<Employee> employees;
	
	public Unit() {
	}
	
	public Unit(String unitName) {
		this.unitName = unitName;
	}
	
	public int getUnitId() {
		return unitId;
	}
	
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	
	public String getUnitName() {
		return unitName;
	}
	
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
}
