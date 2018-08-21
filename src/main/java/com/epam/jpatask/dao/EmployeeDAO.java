package com.epam.jpatask.dao;

import com.epam.jpatask.entity.Employee;
import com.epam.jpatask.entity.Project;
import com.epam.jpatask.entity.Unit;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class EmployeeDAO {
	
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;
	
	public void createEmployee(Employee employee) {
		entityManager.persist(employee);
	}
	
	public Employee findEmployee(int id) {
		return entityManager.find(Employee.class, id);
	}
	
	public void updateEmployee(Employee employee) {
		entityManager.merge(employee);
	}
	
	public void deleteEmployee(int id) {
		Employee employee = findEmployee(id);
		entityManager.remove(employee);
	}
	
	public void deleteAllEmployees() {
		entityManager.createQuery("delete from Employee").executeUpdate();
		entityManager.createQuery("delete from Personal").executeUpdate();
	}
	
	public void addToUnit(int employeeId, int unitId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		Unit newUnit = entityManager.find(Unit.class, unitId);
		
		employee.setUnit(newUnit);
		updateEmployee(employee);
	}
	
	public void assignToProject(int employeeId, int projectId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		Project newProject = entityManager.find(Project.class, projectId);
		
		employee.getProjects().add(newProject);
		updateEmployee(employee);
	}
	
}
