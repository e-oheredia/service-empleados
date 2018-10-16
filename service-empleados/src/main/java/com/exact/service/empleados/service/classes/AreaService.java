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

import com.exact.service.empleados.dao.IAreaDao;
import com.exact.service.empleados.edao.IDistritoEdao;
import com.exact.service.empleados.entity.Area;
import com.exact.service.empleados.entity.Buzon;
import com.exact.service.empleados.service.interfaces.IAreaService;

@Service
public class AreaService implements IAreaService{
	
	@Autowired
	private IAreaDao areaDao;
	@Autowired
	IDistritoEdao distritoEdao;

	@Override
	public Iterable<Area> listarAll() throws IOException, JSONException {
		
		Iterable<Area> areaIterable = areaDao.findAll();
		
		List<Area> areaList=  StreamSupport.stream(areaIterable.spliterator(), false).collect(Collectors.toList());
		
		List<Long> distritosIds = new ArrayList();
		
		for(Area area : areaList) {
			
			distritosIds.add(area.getSede().getDistritoId());
		}
		
		List<Map<String, Object>> distritos = (List<Map<String, Object>>) distritoEdao.listarByIds(distritosIds);
		
		for(Area area : areaList) {

			int i = 0; 
			while(i < distritos.size()) {
				
				Long distritoId= Long.valueOf(distritos.get(i).get("id").toString());
				
				if (area.getSede().getDistritoId().longValue() == distritoId.longValue()) {
					area.getSede().setDistrito(distritos.get(i));
					break;
				}
				i++;
			}
			
		}
		
		return areaList;
	}

	@Override
	public Area listarById(Long id) {
		return areaDao.findById(id).orElse(null);
	}

	@Override
	public Area guardar(Area area) {
		return areaDao.save(area);
	}

}
