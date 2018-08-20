package com.epam.jpatask.dao;

import com.epam.jpatask.entity.Employee;
import com.epam.jpatask.entity.Project;
import com.epam.jpatask.entity.Unit;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class EmployeeDAO {
	
	private EntityManager entityManager;
	private EntityTransaction transaction;
	
	public EmployeeDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.transaction = entityManager.getTransaction();
	}
	
	public void createEmployee(Employee employee) {
		transaction.begin();
		entityManager.persist(employee);
		transaction.commit();
	}
	
	public Employee findEmployee(int id) {
		transaction.begin();
		Employee employee = entityManager.find(Employee.class, id);
		transaction.commit();
		return employee;
	}
	
	public void updateEmployee(Employee employee) {
		transaction.begin();
		entityManager.merge(employee);
		transaction.commit();
	}
	
	public void deleteEmployee(int id) {
		Employee employee = findEmployee(id);
		transaction.begin();
		entityManager.remove(employee);
		transaction.commit();
	}
	
	public void deleteAllEmployees() {
		transaction.begin();
		entityManager.createQuery("delete from Employee").executeUpdate();
		entityManager.createQuery("delete from Personal").executeUpdate();
		transaction.commit();
	}
	
	public void addToUnit(int employeeId, int unitId) {
		transaction.begin();
		Employee employee = entityManager.find(Employee.class, employeeId);
		Unit newUnit = entityManager.find(Unit.class, unitId);
		transaction.commit();
		
		employee.setUnit(newUnit);
		updateEmployee(employee);
	}
	
	public void assignToProject(int employeeId, int projectId) {
		transaction.begin();
		Employee employee = entityManager.find(Employee.class, employeeId);
		Project newProject = entityManager.find(Project.class, projectId);
		transaction.commit();
		
		employee.getProjects().add(newProject);
		updateEmployee(employee);
	}
}
