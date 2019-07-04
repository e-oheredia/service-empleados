package com.exact.service.empleados.service.classes;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.empleados.dao.ISedeDao;
import com.exact.service.empleados.edao.IDistritoEdao;
import com.exact.service.empleados.entity.Sede;
import com.exact.service.empleados.service.interfaces.ISedeService;
import com.exact.service.empleados.utils.Encryption;

@Service
public class SedeService implements ISedeService{
	
	@Autowired
	public ISedeDao sedeDao;
	
	@Autowired
	public IDistritoEdao distritoEdao;
	
	@Autowired
	private Encryption encryption;

	
	@Override
	public Iterable<Sede> listarAll() throws IOException, JSONException{
		List<Sede> sedes = (List<Sede>) sedeDao.findAll();
		if (sedes.size() != 0) {
			List<Long> idsDistrito = sedes.stream().map(Sede::getDistritoId).collect(Collectors.toList());
			List<Map<String, Object>> distritos = (List<Map<String, Object>>) distritoEdao.listarByIds(idsDistrito);
			for (Sede sede : sedes) {
				int i = 0; 
				while(i < distritos.size()) {
					if (sede.getDistritoId() == Long.valueOf(distritos.get(i).get("id").toString())) {
						sede.setDistrito(distritos.get(i));
						break;
					}
					i++;
				}
			}
		}
		return sedes;
	}

	@Override
	public Sede listarById(Long id) throws IOException, JSONException {
		Sede sede = sedeDao.findById(id).orElse(null);
		if (sede != null) {
			Long idDistrito = sede.getDistritoId();
			Map<String, Object> distritoJson = distritoEdao.listarById(idDistrito);
			sede.setDistrito(distritoJson);
			return sede;
		}
		return null;
	}

	@Override
	public Sede guardar(Sede sede) throws ClientProtocolException, IOException {		
		if(!distritoEdao.existeById(sede.getDistritoId())) {
			return null;
		}		
		return sedeDao.save(sede);
	}

	@Override
	public Sede findSedeByMatricula(String matricula) throws ClientProtocolException, IOException {
		return sedeDao.findSedeByMatricula(encryption.encrypt(matricula));
	}

	@Override
	public Iterable<Sede> listarSedesDespacho() throws ClientProtocolException, IOException {
		return sedeDao.listarSedesDespacho();
	}
	
	
	
}
