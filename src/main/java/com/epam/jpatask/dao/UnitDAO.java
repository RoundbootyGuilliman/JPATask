package com.epam.jpatask.dao;

import com.epam.jpatask.entity.Unit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UnitDAO {
	
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;
	
	public void createUnit(Unit unit) {
		entityManager.persist(unit);
	}
	
	public Unit findUnit(int id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Unit> criteriaQuery = builder.createQuery(Unit.class);
		Root<Unit> root = criteriaQuery.from(Unit.class);
		criteriaQuery.select(root).where(builder.equal(root.get("unitId"), id));
		Query query = entityManager.createQuery(criteriaQuery);
		return (Unit) query.getSingleResult();
	}
	
	public void updateUnit(Unit unit) {
		entityManager.merge(unit);
	}
	
	public void deleteUnit(int id) {
		entityManager.createNamedQuery(Unit.DELETE).setParameter("id", id).executeUpdate();
	}
	
	public void deleteAllUnits() {
		entityManager.createQuery("delete from Unit").executeUpdate();
	}
	
}
