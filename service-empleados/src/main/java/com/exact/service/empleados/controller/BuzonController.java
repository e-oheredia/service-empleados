package com.exact.service.empleados.controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exact.service.empleados.entity.Buzon;
import com.exact.service.empleados.service.interfaces.IBuzonService;

@RestController
@RequestMapping("buzones")
public class BuzonController {
	
	@Autowired
	IBuzonService buzonService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Buzon> listarById(@PathVariable Long id) throws IOException, JSONException{
		Buzon buzon = buzonService.listarById(id);
		return new ResponseEntity<Buzon>(buzon, buzon == null ? HttpStatus.NOT_FOUND: HttpStatus.OK);
	}
	
	@GetMapping(params="ids")
	public ResponseEntity<Iterable<Buzon>> listarByIds(@RequestParam List<Long> ids){
		return new ResponseEntity<Iterable<Buzon>>(buzonService.listarByIds(ids), HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<Iterable<Buzon>> listarAll() throws IOException, JSONException{
		return new ResponseEntity<Iterable<Buzon>>(buzonService.listarAll(), HttpStatus.OK);
	}
		
}
