package com.exact.service.empleados.service.classes;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.empleados.dao.IEmpleadoDao;
import com.exact.service.empleados.edao.IDistritoEdao;
import com.exact.service.empleados.entity.Empleado;
import com.exact.service.empleados.entity.PuestoEmpleado;
import com.exact.service.empleados.entity.Sede;
import com.exact.service.empleados.service.interfaces.IEmpleadoService;

@Service
public class EmpleadoService implements IEmpleadoService {
	
	@Autowired
	private IEmpleadoDao empleadoDao;
	
	@Autowired
	private IDistritoEdao distritoEdao;
	
	@Override
	public Iterable<Empleado> listarAll() {
		return empleadoDao.findAll();
	}

	@Override
	public Empleado listarById(Long id) throws IOException, JSONException {
		Empleado empleado = empleadoDao.findById(id).orElse(null);
		PuestoEmpleado puestoActual = empleado.getPuestoActual();
		if (puestoActual == null) {
			return null;
		}
		Sede sede = puestoActual.getPuesto().getArea().getSede();
		sede.setDistrito(distritoEdao.listarById(sede.getDistritoId()));
		return empleado;
	}

	@Override
	public Empleado guardar(Empleado empleado) {
		return empleadoDao.save(empleado);
	}

	@Override
	public Empleado listarByMatricula(String matricula) throws IOException, JSONException {		
		Empleado empleado = empleadoDao.findByMatricula(matricula);
		PuestoEmpleado puestoActual = empleado.getPuestoActual();
		if (puestoActual == null) {
			return null;
		}
		Sede sede = puestoActual.getPuesto().getArea().getSede();
		sede.setDistrito(distritoEdao.listarById(sede.getDistritoId()));
		return empleado;
	}
	
	@Override
	public Iterable<Empleado> listarByMatriculas(List<String> matriculas) throws IOException, JSONException {		
		Iterable<Empleado> empleados = empleadoDao.findByMatriculaIn(matriculas);
		return empleados;
	}

}
