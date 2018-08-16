package com.epam.jpatask.dao;

import com.epam.jpatask.entity.Project;
import com.epam.jpatask.entity.Unit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UnitDAO {
	
	private EntityManager entityManager;
	
	public UnitDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
		entityManager = factory.createEntityManager();
	}
	
	public void createUnit(Unit unit) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(unit);
		transaction.commit();
	}
	
	public Unit findUnit(int id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Unit unit = entityManager.find(Unit.class, id);
		transaction.commit();
		return unit;
	}
	
	public void updateUnit(Unit unit) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(unit);
		transaction.commit();
	}
	
	public void deleteUnit(int id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.createQuery("delete from Unit u where u.unitId=:id").setParameter("id", id).executeUpdate();
		transaction.commit();
	}
}
