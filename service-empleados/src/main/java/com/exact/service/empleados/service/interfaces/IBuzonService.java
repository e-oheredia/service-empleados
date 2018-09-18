package com.exact.service.empleados.service.interfaces;

import java.io.IOException;

import org.json.JSONException;

import com.exact.service.empleados.entity.Buzon;

public interface IBuzonService {
	Buzon listarById(Long id) throws IOException, JSONException;
	Iterable<Buzon> listarByIds(Iterable<Long> ids);
}
