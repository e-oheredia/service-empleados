package com.exact.service.empleados.edao;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.exact.service.empleados.request.IRequester;
import com.exact.service.empleados.utils.CommonUtils;

@Repository
public class DistritoEdao implements IDistritoEdao{
	
	@Autowired
	private IRequester requester;
	
	@Value("${service.lugares}")
	private String lugaresPath; 
	
	private final String path = "/distritos";
		
	@Override
	public Map<String, Object> listarById(Long id) throws ClientProtocolException, IOException, JSONException{
		HttpGet httpGet = new HttpGet(lugaresPath + path + "/" + id);
		CloseableHttpResponse httpResponse = requester.request(httpGet);
		String response = EntityUtils.toString(httpResponse.getEntity());
		JSONObject responseJson = new JSONObject(response);		
		return CommonUtils.jsonToMap(responseJson);
	}
	
	@Override
	public Iterable<Map<String, Object>> listarByIds(List<Long> ids) throws ClientProtocolException, IOException, JSONException{
		HttpGet httpGet = new HttpGet(lugaresPath + path + "?ids=" + String.join(",",ids.stream().map(id -> id.toString())
				.collect(Collectors.toList())));
		CloseableHttpResponse httpResponse = requester.request(httpGet);
		String response = EntityUtils.toString(httpResponse.getEntity());
		JSONArray responseJson = new JSONArray(response);		
		return CommonUtils.jsonArrayToMap(responseJson);
	}

	@Override
	public boolean existeById(Long id) throws ClientProtocolException, IOException {
		HttpHead httpHead = new HttpHead(lugaresPath + path + "/" + id);
		CloseableHttpResponse httpResponse = requester.request(httpHead);
		if (httpResponse.getStatusLine().getStatusCode() == 200) {
			return true;
		}
		return false;
	}
	
}
