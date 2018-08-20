package com.epam.jpatask.app;

import com.epam.jpatask.dao.EmployeeDAO;
import com.epam.jpatask.dao.ProjectDAO;
import com.epam.jpatask.dao.UnitDAO;
import com.epam.jpatask.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;

public class Main {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		EmployeeDAO employeeDAO = new EmployeeDAO(entityManager);
		UnitDAO unitDAO = new UnitDAO(entityManager);
		ProjectDAO projectDAO = new ProjectDAO(entityManager);


//		// create and persist new Unit
//		Unit unit = new Unit("Unit");
//		unitDAO.createUnit(unit);
//
//		// create and persist new Project
//		Project project = new Project("Project");
//		projectDAO.createProject(project);
//
//		// create and persist new Employee "Bob"
//		Address address = new Address("US", "Boston", "23", "23", "55");
//		Personal personal = new Personal("Bob", "Smith", new Date());
//		Employee employee = new Employee("Cleaning manager", EmployeeStatus.ACTIVE, address, personal, unit,
//				new ArrayList<Project>(){{add(project);}});
//		employee.setEmployeeId(23);
//		employeeDAO.createEmployee(employee);
//
//		// create and persist second Unit
//		Unit unit2 = new Unit("Unit 2");
//		unitDAO.createUnit(unit2);
//
//		// change Bob's Unit from Unit 1 to Unit 2
//		employeeDAO.addToUnit(employee.getEmployeeId(), unit2.getUnitId());
//
//		// create and persist second Project
//		Project project2 = new Project("Project 2");
//		projectDAO.createProject(project2);
//
//		// add Project 2 to Bob's list of projects
//		employeeDAO.assignToProject(employee.getEmployeeId(), project2.getProjectId());
		
		employeeDAO.deleteAllEmployees();
		unitDAO.deleteAllUnits();
		projectDAO.deleteAllProjects();
		
		entityManager.close();
		factory.close();
	}
}
