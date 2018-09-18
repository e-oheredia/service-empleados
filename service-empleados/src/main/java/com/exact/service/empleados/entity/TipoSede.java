package com.exact.service.empleados.entity;

import java.io.Serializable;
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
@Table(name="tipo_sede")
public class TipoSede implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false, unique=true)
	private String nombre;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="tipoSede")
	@JsonIgnore
	private Set<Sede> sedes;
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
	public Set<Sede> getSedes() {
		return sedes;
	}
	public void setSedes(Set<Sede> sedes) {
		this.sedes = sedes;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
