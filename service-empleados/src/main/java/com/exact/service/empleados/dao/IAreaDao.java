package com.exact.service.empleados.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.service.empleados.entity.Area;

@Repository
public interface IAreaDao extends CrudRepository<Area, Long> {
	
}
