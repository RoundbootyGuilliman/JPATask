package com.epam.jpatask.dao;

import com.epam.jpatask.entity.Employee;
import com.epam.jpatask.entity.Project;
import com.epam.jpatask.entity.Unit;

import javax.persistence.*;

@NamedQuery(name = "deleteEmployee", query = "delete from Employee e where e.employeeId=:id")
public class EmployeeDAO {
	
	private EntityManager entityManager;
	
	public EmployeeDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
		entityManager = factory.createEntityManager();
	}
	
	public void createEmployee(Employee employee) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(employee);
		entityManager.persist(employee.getPersonal());
		transaction.commit();
	}
	
	public Employee findEmployee(int id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Employee employee = entityManager.find(Employee.class, id);
		transaction.commit();
		return employee;
	}
	
	public void updateEmployee(Employee employee, int id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(employee);
		transaction.commit();
	}
	
	public void deleteEmployee(int id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.createNamedQuery("deleteEmployee").setParameter("id", id).executeUpdate();
		transaction.commit();
	}
	
	public void addToUnit(int employeeId, int unitId) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Employee employee = entityManager.find(Employee.class, employeeId);
		Unit newUnit = entityManager.find(Unit.class, unitId);
		transaction.commit();
		
		employee.setUnit(newUnit);
		updateEmployee(employee, employeeId);
	}
	
	public void assignToProject(int employeeId, int projectId) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Employee employee = entityManager.find(Employee.class, employeeId);
		Project newProject = entityManager.find(Project.class, projectId);
		transaction.commit();
		
		employee.getProjects().add(newProject);
		updateEmployee(employee, employeeId);
	}
}
