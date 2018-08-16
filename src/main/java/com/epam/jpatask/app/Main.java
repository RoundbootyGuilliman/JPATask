package com.epam.jpatask.app;

import com.epam.jpatask.dao.EmployeeDAO;
import com.epam.jpatask.dao.ProjectDAO;
import com.epam.jpatask.dao.UnitDAO;
import com.epam.jpatask.entity.*;

import java.util.Arrays;
import java.util.Date;

public class Main {
	
	public static void main(String[] args) {
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		UnitDAO unitDAO = new UnitDAO();
		ProjectDAO projectDAO = new ProjectDAO();

		// create and persist new Unit
		Unit unit = new Unit("Unit 1");
		unitDAO.createUnit(unit);
		
		// create and persist new Project
		Project project = new Project("Project 1");
		projectDAO.createProject(project);

		// create and persist new Employee "Bob"
		Address address = new Address("US", "Boston", "23", "23", "55");
		Personal personal = new Personal("Bob", "Smith", new Date());
		Employee employee = new Employee("Cleaning manager", EmployeeStatus.ACTIVE, address, personal, unit, Arrays.asList(project));
		employeeDAO.createEmployee(employee);
		
		// create and persist second Unit
		Unit unit2 = new Unit("Unit 2");
		unitDAO.createUnit(unit2);
		
		// change Bob's Unit from Unit 1 to Unit 2
		employeeDAO.addToUnit(employee.getEmployeeId(), unit2.getUnitId());
		
		// create and persist second Project
		Project project2 = new Project("Project 2");
		projectDAO.createProject(project2);
		
		// add Project 2 to Bob's list of projects
		employeeDAO.assignToProject(employee.getEmployeeId(), project2.getProjectId());
		
	}
}
