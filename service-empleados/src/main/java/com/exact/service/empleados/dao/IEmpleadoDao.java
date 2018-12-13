package com.exact.service.empleados.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.service.empleados.entity.Empleado;

@Repository
public interface IEmpleadoDao extends CrudRepository<Empleado, Long> {
	
	public Empleado findByMatricula(String matricula);
	public Iterable<Empleado> findByMatriculaIn(List<String> matricula);
}
