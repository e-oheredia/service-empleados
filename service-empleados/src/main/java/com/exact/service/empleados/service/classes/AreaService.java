package com.exact.service.empleados.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.empleados.dao.IAreaDao;
import com.exact.service.empleados.entity.Area;
import com.exact.service.empleados.service.interfaces.IAreaService;

@Service
public class AreaService implements IAreaService{
	
	@Autowired
	private IAreaDao areaDao;

	@Override
	public Iterable<Area> listarAll() {
		return areaDao.findAll();
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
