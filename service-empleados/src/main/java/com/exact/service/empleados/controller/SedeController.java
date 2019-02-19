package com.exact.service.empleados.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exact.service.empleados.entity.Sede;
import com.exact.service.empleados.service.interfaces.ISedeService;

@RestController
@RequestMapping("/sedes")
public class SedeController{
	
	@Autowired
	ISedeService sedeService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Sede> listarById(@PathVariable Long id) throws IOException, JSONException{
		return new ResponseEntity<Sede>(sedeService.listarById(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Sede>> listarAll() throws IOException, JSONException{
		return new ResponseEntity<Iterable<Sede>>(sedeService.listarAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Sede> crear(@RequestBody Sede sede) throws ClientProtocolException, IOException {
		return new ResponseEntity<Sede>(sedeService.guardar(sede), HttpStatus.OK);
	}
	
	@GetMapping("/despacho/{matricula}")
	public ResponseEntity<Sede> buscarSede(@PathVariable String matricula) throws ClientProtocolException, IOException{
		return new ResponseEntity<Sede>(sedeService.findSedeByMatricula(matricula), HttpStatus.OK);
	}
	
	@GetMapping("/sedesdespacho")
	public ResponseEntity<Iterable<Sede>> listarSedesDespacho() throws ClientProtocolException, IOException{
		return new ResponseEntity<Iterable<Sede>>(sedeService.listarSedesDespacho(), HttpStatus.OK);
	}
	
}
