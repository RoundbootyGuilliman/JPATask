package com.epam.jpatask.dao;

import com.epam.jpatask.entity.Unit;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Unit> criteriaQuery = builder.createQuery(Unit.class);
		Root<Unit> root = criteriaQuery.from(Unit.class);
		criteriaQuery.select(root).where(builder.equal(root.get("unitId"), id));
		Query query = entityManager.createQuery(criteriaQuery);
		Unit unit = (Unit) query.getSingleResult();
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
		entityManager.createNamedQuery("deleteUnit").setParameter("id", id).executeUpdate();
		transaction.commit();
	}
}
