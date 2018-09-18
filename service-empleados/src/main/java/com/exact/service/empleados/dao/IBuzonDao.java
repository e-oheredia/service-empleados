package com.exact.service.empleados.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.service.empleados.entity.Buzon;

@Repository
public interface IBuzonDao extends CrudRepository<Buzon, Long> {
	
}
