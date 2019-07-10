package com.exact.service.empleados.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.exact.service.empleados.utils.Encryption;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	/*@Autowired
	@Transient
	private Encryption encryption;*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empleado_id")
	private Long id;
	
	@Transient
	private String matricula;
	
	
	@Transient
	private String nombres;
	
	@Column(name="nombres",nullable = false, unique = true)	
	private String nombresencryptada;

	@Column(name="matricula",unique = true, nullable = false)
	private String matriculaencryptada;
	


	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) throws IOException {
		this.matricula = matricula;
		//this.matriculaencryptada=encryption.encrypt(matricula);		
	}

	public String getMatriculaencryptada() throws UnsupportedEncodingException {
		return matriculaencryptada;
	}

	public void setMatriculaencryptada(String matriculaencryptada) throws IOException {
		this.matriculaencryptada = matriculaencryptada;
		///this.matricula=encryption.decrypt(matriculaencryptada);		
	}
	
	public String getNombresencryptada() {
		return nombresencryptada;
	}

	public void setNombresencryptada(String nombresencryptada) throws IOException {		
		this.nombresencryptada = nombresencryptada;
		//this.nombres=encryption.decrypt(nombresencryptada);			
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empleado", orphanRemoval = true)
	@JsonIgnore
	private Set<PuestoEmpleado> puestos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empleado", orphanRemoval = true)
	private Set<BuzonEmpleado> buzones;	

	public Set<BuzonEmpleado> getBuzones() {
		return buzones;
	}

	public void setBuzones(Set<BuzonEmpleado> buzones) {
		this.buzones = buzones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) throws IOException {
		this.nombres = nombres;
		//this.matriculaencryptada=encryption.encrypt(nombres);		
	}

	public Set<PuestoEmpleado> getPuestos() {
		return puestos;
	}

	public void setPuestos(Set<PuestoEmpleado> puestos) {
		this.puestos = puestos;
	}

	public void addPuesto(Puesto tag) {
		PuestoEmpleado postTag = new PuestoEmpleado(tag, this);
		puestos.add(postTag);
	}

	public void removePuesto(Puesto tag) {
		for (Iterator<PuestoEmpleado> iterator = puestos.iterator(); iterator.hasNext();) {
			PuestoEmpleado postTag = iterator.next();
			if (postTag.getEmpleado().equals(this) && postTag.getPuesto().equals(tag)) {
				iterator.remove();
				postTag.setEmpleado(null);
				postTag.setPuesto(null);
			}
		}
	}

	public PuestoEmpleado getPuestoActual() {
		for (PuestoEmpleado puesto : puestos) {
			if (puesto.getFechaDesasociado() == null) {
				return puesto;
			}
		}
		return null;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
