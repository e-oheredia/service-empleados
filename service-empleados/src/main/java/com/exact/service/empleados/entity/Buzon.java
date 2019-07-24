package com.exact.service.empleados.entity;


import java.io.IOException;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;




@Entity
@Table(name="buzon")
public class Buzon implements Serializable{
	


	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="buzon_id")
	private Long id;
	
	
	@Transient
	private String nombre;
	
	/*@Autowired
	@Transient
	private Encryption encryption;*/
	
	@Column(name="nombre",nullable=false, unique=true)
	private String nombresencryptada;
	
	public String getNombresencryptada() {
		return nombresencryptada;
	}



	public void setNombresencryptada(String nombresencryptada) throws IOException {
		this.nombresencryptada = nombresencryptada;
		//this.nombre=encryption.decrypt(nombresencryptada);	
	}

	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	@JoinColumn(name="area_id")
	private Area area;
	

	public Buzon() {

	}
	
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}

	private boolean activo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() throws IOException {
		//this.nombre = encryption.decrypt(nombresencryptada);
		return nombre;
	}
	public void setNombre(String nombre) throws IOException {
		this.nombre = nombre;
		//this.nombresencryptada=encryption.encrypt(nombre);
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

	private static final long serialVersionUID = 1L;
}
