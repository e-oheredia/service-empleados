package com.exact.service.empleados.service.interfaces;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.exact.service.empleados.entity.Empleado;

@Service
public interface IEmpleadoService {
	
	Iterable<Empleado> listarAll();
	Empleado listarById(Long id) throws IOException, JSONException;
	Empleado guardar(Empleado empleado);
	Empleado listarByMatricula(String matricula) throws IOException, JSONException;
	Iterable<Empleado> listarByMatriculas(List<String> matriculas) throws IOException, JSONException;
}
