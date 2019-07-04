package com.exact.service.empleados.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.service.empleados.entity.Sede;


@Repository
public interface ISedeDao extends CrudRepository<Sede, Long> {
	
	@Query("FROM Sede s WHERE s IN (SELECT a.sede FROM Area a WHERE "
			+ "a IN (SELECT p.area FROM Puesto p WHERE p IN (SELECT pe.puesto FROM PuestoEmpleado pe WHERE pe.empleado IN (SELECT "
			+ "e FROM Empleado e WHERE e.matriculaencryptada=?1))))")
	public Sede findSedeByMatricula(String matricula);
	
	@Query("FROM Sede s WHERE s.despacho=1")
	public Iterable<Sede> listarSedesDespacho();
	
}
