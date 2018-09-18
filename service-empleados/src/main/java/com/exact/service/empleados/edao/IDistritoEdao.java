package com.exact.service.empleados.edao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

public interface IDistritoEdao {	
	public Map<String, Object> listarById(Long id) throws IOException, JSONException;
	public Iterable<Map<String, Object>> listarByIds(List<Long> ids) throws IOException, JSONException;
	public boolean existeById(Long id) throws ClientProtocolException, IOException;
}
