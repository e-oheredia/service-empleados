package com.exact.service.empleados.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="puesto_empleado")
public class PuestoEmpleado implements Serializable{
	
	
	@EmbeddedId
	private PuestoEmpleadoId id;
	@ManyToOne(fetch=FetchType.EAGER)
	@MapsId("puestoId")
	@JoinColumn(name="puesto_id")
	private Puesto puesto;
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("empleadoId")
	@JoinColumn(name="empleado_id")
	@JsonIgnore
	private Empleado empleado;
	@Column(name="fecha_asociado")
	private Date fechaAsociado;
	@Column(name="fecha_desasociado")
	@JsonInclude(value=Include.NON_NULL)
	private Date fechaDesasociado;
	
	@PrePersist
	public void prePersist() {
		fechaAsociado = new Date();
	}
	
	public PuestoEmpleadoId getId() {
		return id;
	}
	public void setId(PuestoEmpleadoId id) {
		this.id = id;
	}
	public Puesto getPuesto() {
		return puesto;
	}
	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Date getFechaAsociado() {
		return fechaAsociado;
	}
	public void setFechaAsociado(Date fechaAsociado) {
		this.fechaAsociado = fechaAsociado;
	}
	public Date getFechaDesasociado() {
		return fechaDesasociado;
	}
	public void setFechaDesasociado(Date fechaDesasociado) {
		this.fechaDesasociado = fechaDesasociado;
	}
	
	public PuestoEmpleado() {}
	
	public PuestoEmpleado(Puesto puesto, Empleado empleado) {
		this.puesto = puesto;
		this.empleado = empleado;
		this.id = new PuestoEmpleadoId(puesto.getId(), empleado.getId());
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        PuestoEmpleado that = (PuestoEmpleado) o;
        return Objects.equals(puesto, that.puesto) &&
               Objects.equals(empleado, that.empleado);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(puesto, empleado);
    }
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
}
