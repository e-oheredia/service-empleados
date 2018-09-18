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
@Table(name="tipo_puesto")
public class TipoPuesto implements Serializable {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tipo_puesto_id")
	private Long id;
	@Column(nullable=false, unique=true, length=40)
	private String nombre;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="tipoPuesto")
	@JsonIgnore
	private Set<Puesto> puestos;
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
