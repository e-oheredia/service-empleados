package com.exact.service.empleados.service.classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.empleados.dao.IEmpleadoDao;
import com.exact.service.empleados.edao.IDistritoEdao;
import com.exact.service.empleados.entity.Buzon;
import com.exact.service.empleados.entity.BuzonEmpleado;
import com.exact.service.empleados.entity.Empleado;
import com.exact.service.empleados.entity.PuestoEmpleado;
import com.exact.service.empleados.entity.Sede;
import com.exact.service.empleados.service.interfaces.IEmpleadoService;
import com.exact.service.empleados.utils.Encryption;

@Service
public class EmpleadoService implements IEmpleadoService {
	
	@Autowired
	private IEmpleadoDao empleadoDao;
	
	@Autowired
	private IDistritoEdao distritoEdao;
	
	@Autowired
	private Encryption encryption;
	
	@Override
	public Iterable<Empleado> listarAll() throws IOException {
		Iterable<Empleado> empleados = empleadoDao.findAll();
		
		for(Empleado empleado : empleados) {
			desencryptarEmpleado(empleado);
			//String prueba0=empleado.getMatriculaencryptada();
//			String prueba = Encryption.decrypt(empleado.getMatriculaencryptada());
//			empleado.setMatricula(Encryption.decrypt(empleado.getMatriculaencryptada()));
//			empleado.setNombres(Encryption.decrypt(empleado.getNombresencryptada()));
		}
		return empleados;
	}

	@Override
	public Empleado listarById(Long id) throws IOException, JSONException {
		Empleado empleado = empleadoDao.findById(id).orElse(null);
		desencryptarEmpleado(empleado);
		
		PuestoEmpleado puestoActual = empleado.getPuestoActual();
		if (puestoActual == null) {
			return null;
		}
		Sede sede = puestoActual.getPuesto().getArea().getSede();
		sede.setDistrito(distritoEdao.listarById(sede.getDistritoId()));
		return empleado;
	}

	@Override
	public Empleado guardar(Empleado empleado) throws IOException {
		encryptarEmpleado(empleado);
		return empleadoDao.save(empleado);
	}

	@Override
	public Empleado listarByMatricula(String matricula) throws IOException, JSONException {
		String matri = encryption.encrypt(matricula);
		Empleado empleado = empleadoDao.findByMatriculaencryptada(matri);
		desencryptarEmpleado(empleado);
		desencryptarBuzonEmpleado(empleado);
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
		List<String> MatriculasEncriptadas = new ArrayList<>();
		for(String matricula : matriculas) {
			MatriculasEncriptadas.add(encryption.encrypt(matricula));
		}
		Iterable<Empleado> empleados = empleadoDao.findAllByMatriculaencryptadaIn(MatriculasEncriptadas);
		for(Empleado empleado : empleados) {
			desencryptarEmpleado(empleado);
		}
		return empleados;
	}
	

	public  void encryptarEmpleado(Empleado empleado) throws IOException {
		empleado.setNombresencryptada( encryption.encrypt(empleado.getNombres()));
		empleado.setMatriculaencryptada(encryption.encrypt(empleado.getMatricula()));
	}
	
	public void desencryptarEmpleado(Empleado empleado) throws IOException {
		empleado.setNombres(encryption.decrypt(empleado.getNombresencryptada()));
		empleado.setMatricula(encryption.decrypt(empleado.getMatriculaencryptada()));
	}
	
	public void desencryptarBuzonEmpleado(Empleado empleado) throws IOException {
		for(BuzonEmpleado buzonemple : empleado.getBuzones()) {
			Buzon buzon = buzonemple.getBuzon();
			buzon.setNombre(encryption.decrypt(buzon.getNombresencryptada()));
		}
	}
	
}
