package com.epam.jpatask.controller;

import com.epam.jpatask.dao.EmployeeDAO;
import com.epam.jpatask.dao.ProjectDAO;
import com.epam.jpatask.dao.UnitDAO;
import com.epam.jpatask.entity.*;

import javax.annotation.sql.DataSourceDefinition;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;

@DataSourceDefinition(
		className = "oracle.jdbc.pool.OracleDataSource",
		name = "java:global/jdbc/datasource",
		user = "jpatask",
		password = "sql",
		url = "jdbc:oracle:thin:@localhost:1521:xe"
)
@WebServlet("/main")
public class Main extends HttpServlet {
	
	@Inject
	private EmployeeDAO employeeDAO;
	@Inject
	private UnitDAO unitDAO;
	@Inject
	private ProjectDAO projectDAO;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		
		
		employeeDAO.deleteAllEmployees();
		unitDAO.deleteAllUnits();
		projectDAO.deleteAllProjects();
		
		
		
		// create and persist new Unit
		Unit unit = new Unit("Unit");
		unitDAO.createUnit(unit);
		
		// create and persist new Project
		Project project = new Project("Project");
		projectDAO.createProject(project);
		
		// create and persist new Employee "Bob"
		Address address = new Address("US", "Boston", "23", "23", "55");
		Personal personal = new Personal("Bob", "Smith", new Date());
		Employee employee = new Employee("Cleaning manager", EmployeeStatus.ACTIVE, address, personal, unit,
				new ArrayList<Project>(){{add(project);}});
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
		
		request.setAttribute("date", new Date());
		
		try {
			request.getRequestDispatcher("WEB-INF/jsp/result.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
