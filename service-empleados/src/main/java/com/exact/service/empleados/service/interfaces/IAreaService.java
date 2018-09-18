package com.exact.service.empleados.service.interfaces;

import com.exact.service.empleados.entity.Area;

public interface IAreaService {
	Iterable<Area> listarAll();
	Area listarById(Long id);
	Area guardar(Area area);
}
