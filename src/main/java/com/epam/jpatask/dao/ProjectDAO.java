package com.epam.jpatask.dao;

import com.epam.jpatask.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProjectDAO {
	
	private EntityManager entityManager;
	
	public ProjectDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void createProject(Project project) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(project);
		transaction.commit();
	}
	
	public Project findProject(int id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Project project = entityManager.find(Project.class, id);
		transaction.commit();
		return project;
	}
	
	public void updateProject(Project project) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(project);
		transaction.commit();
	}
	
	public void deleteProject(int id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.createNativeQuery("DELETE FROM PROJECT WHERE projectId=?").setParameter(1, id).executeUpdate();
		transaction.commit();
	}
	
	public void deleteAllProjects() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.createQuery("delete from Project").executeUpdate();
		transaction.commit();
	}
}
