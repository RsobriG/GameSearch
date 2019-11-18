package com.games.GameSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GameSesionService {
	
	RestTemplate template = null;
	
	public GameSesionService()
	{
		template = new RestTemplate();
		/*
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new LoggingRequestInterceptor());
		template.setInterceptors(interceptors);
		*/
	}
	
	public Iterable<GameSesion> findbyUserId(String userid){
		/* HttpEntity<String> request = new HttpEntity<String>(userid); */
		
		HttpEntity<ArrayList<GameSesion>> response = template.exchange(
				"http://localhost:8083/webapi/mygames/?userid=" + userid,
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<ArrayList<GameSesion>>() {});

		ArrayList<GameSesion> mygames = response.getBody();
		return mygames;
	}
	
	public Iterable<GameSesion> findbyGameId(long gameid){
		//Long gamesesion= new Long(gameid);
		HttpEntity<List<GameSesion>> response = template.exchange("http://localhost:8083/webapi/gameplayers",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<GameSesion>>() {});
		List<GameSesion> gameplayers = response.getBody();
		return gameplayers;
	}
	
	public void addGameSesion(GameSesion gamesesion) {
		/*
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.ALL);
		*/
		HttpEntity<GameSesion> request = new HttpEntity<GameSesion>(gamesesion);
		template.postForObject("http://localhost:8083/webapi/insertgamesesion", request, GameSesion.class);
	}

}
