package com.epam.jpatask.dao;

import com.epam.jpatask.entity.Unit;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class UnitDAO {
	
	@PersistenceContext
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
		Unit unit = (Unit) query.getSingleResult();
		return unit;
	}
	
	public void updateUnit(Unit unit) {
		entityManager.merge(unit);
	}
	
	public void deleteUnit(int id) {
		entityManager.createQuery("delete from Unit u where u.unitId=:id").setParameter("id", id).executeUpdate();
	}
}
