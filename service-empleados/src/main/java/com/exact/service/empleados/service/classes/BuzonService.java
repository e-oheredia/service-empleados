package com.exact.service.empleados.service.classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

	@Override
	public Iterable<Buzon> listarAll() throws IOException, JSONException{
		
		Iterable<Buzon> buzonIterable = buzonDao.findAll();
	
		List<Buzon> buzonList = StreamSupport.stream(buzonIterable.spliterator(), false).collect(Collectors.toList());
		
		List<Long> distritosIds = new ArrayList();
		
		for(Buzon buzon : buzonList) {
			distritosIds.add(buzon.getArea().getSede().getDistritoId());
		}
		
		List<Map<String, Object>> distritos = (List<Map<String, Object>>) distritoEdao.listarByIds(distritosIds);
		
		for(Buzon buzon : buzonList) {

			int i = 0; 
			while(i < distritos.size()) {
				
				Long distritoId= Long.valueOf(distritos.get(i).get("id").toString());
				
				if (buzon.getArea().getSede().getDistritoId().longValue() == distritoId.longValue()) {
					buzon.getArea().getSede().setDistrito(distritos.get(i));
					break;
				}
				i++;
			}
			
		}
		
		return buzonList;
		
		
		
	}

}
