package com.exact.service.empleados.service.interfaces;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.exact.service.empleados.entity.Sede;

public interface ISedeService {
	Iterable<Sede> listarAll() throws IOException, JSONException;
	Sede listarById(Long id) throws IOException, JSONException;
	Sede guardar(Sede sede) throws ClientProtocolException, IOException;
}
