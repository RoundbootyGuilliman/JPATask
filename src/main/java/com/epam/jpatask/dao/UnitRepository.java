package com.epam.jpatask.dao;

import java.util.List;

import com.epam.jpatask.entity.Unit;
import org.springframework.data.repository.CrudRepository;

public interface UnitRepository extends CrudRepository<Unit, Integer> {
	
	List<Unit> findByUnitName(String unitName);
}