package com.epam.jpatask.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Unit.DELETE, query = "delete from Unit u where u.unitId=:id")
public class Unit {
	
	public static final String DELETE = "Unit.delete";
	
	@Id
	@GeneratedValue
	private int unitId;
	private String unitName;
	
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
	
	@Override
	public String toString() {
		return "Unit{" +
				"unitId=" + unitId +
				", unitName=\"" + unitName + "\"" +
				'}';
	}
}
