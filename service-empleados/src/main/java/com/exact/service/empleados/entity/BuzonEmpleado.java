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

@Entity
@Table(name="buzon_empleado")
public class BuzonEmpleado implements Serializable{
	
	@EmbeddedId
	private BuzonEmpleadoId id;
	@ManyToOne(fetch=FetchType.EAGER)
	@MapsId("buzonId")
	@JoinColumn(name="buzon_id")
	private Buzon buzon;
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("empleadoId")
	@JoinColumn(name="empleado_id")
	@JsonIgnore
	private Empleado empleado;
	@Column(name="fecha_asociado")
	private Date fechaAsociado;
	@Column(name="fecha_desasociado")
	private Date fechaDesasociado;
	@PrePersist
	public void prePersist() {
		fechaAsociado = new Date();
	}
	public BuzonEmpleadoId getId() {
		return id;
	}
	public void setId(BuzonEmpleadoId id) {
		this.id = id;
	}
	public Buzon getBuzon() {
		return buzon;
	}
	public void setBuzon(Buzon buzon) {
		this.buzon = buzon;
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
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        BuzonEmpleado that = (BuzonEmpleado) o;
        return Objects.equals(buzon, that.buzon) &&
               Objects.equals(empleado, that.empleado);
	} 
    @Override
    public int hashCode() {
        return Objects.hash(buzon, empleado);
    }
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
