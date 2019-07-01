package com.exact.service.empleados.service.interfaces;

import java.io.IOException;

import org.json.JSONException;

import com.exact.service.empleados.entity.Area;

public interface IAreaService {
	Iterable<Area> listarAll() throws IOException, JSONException;
	Area listarById(Long id);
	Area guardar(Area area);
	Iterable<Area> listarByIds(Iterable<Long> ids) throws IOException, JSONException;
}
