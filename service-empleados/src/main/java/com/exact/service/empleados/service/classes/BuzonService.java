package com.exact.service.empleados.service.classes;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.empleados.dao.IBuzonDao;
import com.exact.service.empleados.edao.IDistritoEdao;
import com.exact.service.empleados.entity.Buzon;
import com.exact.service.empleados.entity.Sede;
import com.exact.service.empleados.service.interfaces.IBuzonService;

@Service
public class BuzonService implements IBuzonService {
	
	@Autowired
	IBuzonDao buzonDao;
	
	@Autowired
	IDistritoEdao distritoEdao;
	
	@Override
	public Buzon listarById(Long id) throws IOException, JSONException {
		Buzon buzon = buzonDao.findById(id).orElse(null);
		Sede sede = buzon.getArea().getSede();
		sede.setDistrito(distritoEdao.listarById(sede.getDistritoId()));
		return buzon;
	}

	@Override
	public Iterable<Buzon> listarByIds(Iterable<Long> ids) {
		return buzonDao.findAllById(ids);
	}

}
