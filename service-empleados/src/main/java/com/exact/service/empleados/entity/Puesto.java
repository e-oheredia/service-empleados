package com.exact.service.empleados.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="puesto")
public class Puesto implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="puesto_id")
	private Long id;
	@Column(nullable=false, unique=true)
	private String nombre;
	@ManyToOne(optional=false)
	@JoinColumn(name="tipo_puesto_id")
	private TipoPuesto tipoPuesto;
	@ManyToOne(optional=false)
	@JoinColumn(name="area_id")
	private Area area;
	
	public TipoPuesto getTipoPuesto() {
		return tipoPuesto;
	}
	public void setTipoPuesto(TipoPuesto tipoPuesto) {
		this.tipoPuesto = tipoPuesto;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
}
