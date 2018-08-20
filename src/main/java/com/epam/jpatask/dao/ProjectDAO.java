package com.epam.jpatask.dao;

import com.epam.jpatask.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ProjectDAO {
	
	private EntityManager entityManager;
	private EntityTransaction transaction;
	
	public ProjectDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.transaction = entityManager.getTransaction();
	}
	
	public void createProject(Project project) {
		transaction.begin();
		entityManager.persist(project);
		transaction.commit();
	}
	
	public Project findProject(int id) {
		transaction.begin();
		Project project = entityManager.find(Project.class, id);
		transaction.commit();
		return project;
	}
	
	public void updateProject(Project project) {
		transaction.begin();
		entityManager.merge(project);
		transaction.commit();
	}
	
	public void deleteProject(int id) {
		transaction.begin();
		entityManager.createNativeQuery("DELETE FROM PROJECT WHERE projectId=?").setParameter(1, id).executeUpdate();
		transaction.commit();
	}
	
	public void deleteAllProjects() {
		transaction.begin();
		entityManager.createQuery("delete from Project").executeUpdate();
		transaction.commit();
	}
}
