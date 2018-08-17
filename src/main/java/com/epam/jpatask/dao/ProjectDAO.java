package com.epam.jpatask.dao;

import com.epam.jpatask.entity.Project;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProjectDAO {
	
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;
	
	public void createProject(Project project) {
		entityManager.persist(project);
	}
	
	public Project findProject(int id) {
		Project project = entityManager.find(Project.class, id);
		return project;
	}
	
	public void updateProject(Project project) {
		entityManager.merge(project);
	}
	
	public void deleteProject(int id) {
		entityManager.createNativeQuery("DELETE FROM PROJECT WHERE projectId=?").setParameter(1, id).executeUpdate();;
	}
}
