package com.exact.service.empleados.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class BuzonEmpleadoId implements Serializable {

	
	private Long buzonId;
	private Long empleadoId;
	
	public BuzonEmpleadoId() {
		
	}
	
	public BuzonEmpleadoId(Long buzonId, Long empleadoId) {
		
		this.buzonId = buzonId;
		this.empleadoId = empleadoId;
	}

	public Long getBuzonId() {
		return buzonId;
	}

	public void setBuzonId(Long buzonId) {
		this.buzonId = buzonId;
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
 
        BuzonEmpleadoId that = (BuzonEmpleadoId) o;
        return Objects.equals(buzonId, that.buzonId) && 
               Objects.equals(empleadoId, that.empleadoId);
	}
	@Override
	public int hashCode() {
		return Objects.hash(buzonId, empleadoId);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
