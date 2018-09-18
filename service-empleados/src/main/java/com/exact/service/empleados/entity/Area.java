package com.exact.service.empleados.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "area")
public class Area implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "area_id")
	private Long id;
	@Column(nullable = false, unique = true)
	private String nombre;
	@Column(nullable = false, unique = true)
	private String codigo;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "sede_id")
	private Sede sede;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="area")
	@JsonIgnore
	private Set<Puesto> puestos;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "area")
	@JsonIgnore
	private Set<Buzon> buzones;

	public Set<Buzon> getBuzones() {
		return buzones;	
	}

	public void setBuzones(Set<Buzon> buzones) {
		this.buzones = buzones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public Set<Puesto> getPuestos() {
		return puestos;
	}

	public void setPuestos(Set<Puesto> puestos) {
		this.puestos = puestos;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
