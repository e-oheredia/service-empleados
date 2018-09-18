package com.exact.service.empleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exact.service.empleados.entity.Area;
import com.exact.service.empleados.service.interfaces.IAreaService;

@RestController
@RequestMapping("/areas")
public class AreaController {
	
	@Autowired
	private IAreaService areaService;
	
	@GetMapping
	public ResponseEntity<Iterable<Area>> listarAll() {
		return new ResponseEntity<Iterable<Area>>(areaService.listarAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Area> listarById(@PathVariable Long id) {
		return new ResponseEntity<Area>(areaService.listarById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Area> crear(@RequestBody Area area) {
		return new ResponseEntity<Area>(areaService.guardar(area), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Area> editar(@PathVariable Long id, @RequestBody Area area) {
		area.setId(id);
		return new ResponseEntity<Area>(areaService.guardar(area), HttpStatus.OK);
	}
	
	
	
}
