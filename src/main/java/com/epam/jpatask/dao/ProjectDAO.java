package com.epam.jpatask.dao;

import com.epam.jpatask.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ProjectDAO {
	
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;
	
	public void createProject(Project project) {
		entityManager.persist(project);
	}
	
	public Project findProject(int id) {
		return entityManager.find(Project.class, id);
	}
	
	public void updateProject(Project project) {
		entityManager.merge(project);
	}
	
	public void deleteProject(int id) {
		entityManager.createNativeQuery("DELETE FROM PROJECT WHERE projectId=?").setParameter(1, id).executeUpdate();
	}
	
	public void deleteAllProjects() {
		entityManager.createQuery("delete from Project").executeUpdate();
	}
	
}
