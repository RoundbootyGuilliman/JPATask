package com.epam.jpatask.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "deleteUnit", query = "delete from Unit u where u.unitId=:id")
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
