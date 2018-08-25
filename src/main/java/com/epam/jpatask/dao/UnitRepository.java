package com.epam.jpatask.dao;

import com.epam.jpatask.entity.Unit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UnitRepository extends CrudRepository<Unit, Integer> {
	
	List<Unit> findByUnitName(String unitName);
}