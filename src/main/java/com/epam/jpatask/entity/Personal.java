package com.epam.jpatask.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Personal {
	
	@Id
	@GeneratedValue
	private int personalId;
	private String firstName;
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	public Personal() {
	}
	
	public Personal(String firstName, String lastName, Date birthday) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
	}
	
	public int getPersonalId() {
		return personalId;
	}
	
	public void setPersonalId(int employeeId) {
		this.personalId = employeeId;
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
}
