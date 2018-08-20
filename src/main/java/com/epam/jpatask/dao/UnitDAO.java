package com.epam.jpatask.dao;

import com.epam.jpatask.entity.Unit;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UnitDAO {
	
	private EntityManager entityManager;
	private EntityTransaction transaction;
	
	public UnitDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.transaction = entityManager.getTransaction();
	}
	
	public void createUnit(Unit unit) {
		transaction.begin();
		entityManager.persist(unit);
		transaction.commit();
	}
	
	public Unit findUnit(int id) {
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
		transaction.begin();
		entityManager.merge(unit);
		transaction.commit();
	}
	
	public void deleteUnit(int id) {
		transaction.begin();
		entityManager.createNamedQuery("deleteUnit").setParameter("id", id).executeUpdate();
		transaction.commit();
	}
	
	public void deleteAllUnits() {
		transaction.begin();
		entityManager.createQuery("delete from Unit").executeUpdate();
		transaction.commit();
	}
}
