package com.exact.service.empleados.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.service.empleados.entity.Sede;

@Repository
public interface ISedeDao extends CrudRepository<Sede, Long> {
	
}
