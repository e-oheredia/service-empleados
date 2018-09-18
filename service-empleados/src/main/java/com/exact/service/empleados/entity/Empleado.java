package com.exact.service.empleados.entity;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empleado_id")
	private Long id;
	@Column(unique = true, nullable = false)
	private String matricula;
	@Column(nullable = false, unique = true)
	private String nombres;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public void setNombres(String nombres) {
		this.nombres = nombres;
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
