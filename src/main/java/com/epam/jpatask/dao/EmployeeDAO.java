package com.epam.jpatask.dao;

import com.epam.jpatask.entity.Employee;
import com.epam.jpatask.entity.Project;
import com.epam.jpatask.entity.Unit;

import javax.ejb.Stateless;
import javax.persistence.*;

@NamedQuery(name = "deleteEmployee", query = "delete from Employee e where e.employeeId=:id")
@Stateless
public class EmployeeDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void createEmployee(Employee employee) {
		entityManager.persist(employee);
		entityManager.persist(employee.getPersonal());
	}
	
	public Employee findEmployee(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}
	
	public void updateEmployee(Employee employee, int id) {
		entityManager.merge(employee);
	}
	
	public void deleteEmployee(int id) {
		entityManager.createNamedQuery("deleteEmployee").setParameter("id", id).executeUpdate();
	}
	
	public void addToUnit(int employeeId, int unitId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		Unit newUnit = entityManager.find(Unit.class, unitId);
		
		employee.setUnit(newUnit);
		updateEmployee(employee, employeeId);
	}
	
	public void assignToProject(int employeeId, int projectId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		Project newProject = entityManager.find(Project.class, projectId);
		
		employee.getProjects().add(newProject);
		updateEmployee(employee, employeeId);
	}
}
