package com.exact.service.empleados.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PuestoEmpleadoId implements Serializable {
	
	
	@Column(name = "puesto_id")
	private Long puestoId;
	@Column(name = "empleado_id")
	private Long empleadoId;
	
	public PuestoEmpleadoId() {}
	
	public PuestoEmpleadoId(Long puestoId, Long empleadoId) {
		super();
		this.puestoId = puestoId;
		this.empleadoId = empleadoId;
	}
	public Long getPuestoId() {
		return puestoId;
	}
	public void setPuestoId(Long puestoId) {
		this.puestoId = puestoId;
	}
	public Long getEmpleadoId() {
		return empleadoId;
	}
	public void setEmpleadoId(Long empleadoId) {
		this.empleadoId = empleadoId;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		 
        if (o == null || getClass() != o.getClass()) 
            return false;
 
        PuestoEmpleadoId that = (PuestoEmpleadoId) o;
        return Objects.equals(puestoId, that.puestoId) && 
               Objects.equals(empleadoId, that.empleadoId);
	}
	@Override
	public int hashCode() {
		return Objects.hash(puestoId, empleadoId);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
