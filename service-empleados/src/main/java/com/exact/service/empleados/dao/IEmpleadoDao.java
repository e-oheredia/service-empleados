package com.exact.service.empleados.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.service.empleados.entity.Empleado;

@Repository
public interface IEmpleadoDao extends CrudRepository<Empleado, Long> {
	
	@Query("FROM Empleado s WHERE s.matriculaencryptada=?1")
	public Empleado findByMatriculaencryptada(String matricula);
	
	public Iterable<Empleado> findAllByMatriculaencryptadaIn(List<String> matricula);
	
//	@Query("FROM Empleado s WHERE s.matriculaencryptada IN ( Select   ) ")
//	public Iterable<Empleado> buscarporListaMatriculas(List<String> MatriculaEncriptada);
}
