package com.exact.service.empleados.controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exact.service.empleados.entity.Empleado;
import com.exact.service.empleados.service.interfaces.IEmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@Autowired
	IEmpleadoService empleadoService;
	
	@GetMapping
	public ResponseEntity<Empleado> listarByMatricula(@RequestParam String matricula) throws IOException, JSONException {
			Empleado empleado = empleadoService.listarByMatricula(matricula.toUpperCase());
		return new ResponseEntity<Empleado>(empleado, empleado == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}
	
	@GetMapping(params= {"matriculas"})
	public ResponseEntity<Iterable<Empleado>> listarByMatricula(@RequestParam List<String> matriculas) throws IOException, JSONException {
		Iterable<Empleado> empleados = empleadoService.listarByMatriculas(matriculas);
		return new ResponseEntity<Iterable<Empleado>>(empleados, empleados == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}
	
	@GetMapping("/empleados")
	public ResponseEntity<Iterable<Empleado>> listarAll() throws IOException, JSONException{
		Iterable<Empleado> empleados = empleadoService.listarAll();
		return new ResponseEntity<Iterable<Empleado>>(empleados, HttpStatus.OK);
	}
	
	
	
	
}
