package com.games.GameSearch;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlaceService {
	RestTemplate template = new RestTemplate();
	
	public Iterable<Place> findbyName(String name){
		HttpEntity<List<Place>> response = template.exchange("http://localhost:8083/webapi/placebyname",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Place>>() {});
		List<Place> places = response.getBody();
		return places;
	}

}
