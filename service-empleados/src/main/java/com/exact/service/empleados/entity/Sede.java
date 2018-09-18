package com.exact.service.empleados.entity;

import java.io.Serializable;
import java.util.Map;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name="sede")
public class Sede implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sede_id")
	private Long id;
	@Column(nullable=false, unique=true)
	private String nombre;
	@Column(nullable=false, unique=true)
	private String codigo;
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	@JoinColumn(name="tipo_sede_id")
	private TipoSede tipoSede;
	private String direccion;	
	@Column(name="distrito_id", nullable=false)
	
	private Long distritoId;
	@Transient
	private Map<String, Object> distrito;	
	
	public Map<String, Object> getDistrito() {
		return distrito;
	}
	public void setDistrito(Map<String, Object> distrito) {
		this.distrito = distrito;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@JsonIgnore
	public Long getDistritoId() {
		return distritoId;
	}
	@JsonSetter
	public void setDistritoId(Long distritoId) {
		this.distritoId = distritoId;
	}
	@OneToMany(fetch=FetchType.LAZY, mappedBy="sede")
	@JsonIgnore
	private Set<Area> areas;
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
	public TipoSede getTipoSede() {
		return tipoSede;
	}
	public void setTipoSede(TipoSede tipoSede) {
		this.tipoSede = tipoSede;
	}
	public Set<Area> getAreas() {
		return areas;
	}
	public void setAreas(Set<Area> areas) {
		this.areas = areas;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
