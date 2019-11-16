package com.games.GameSearch;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GameSesionService {
	
	RestTemplate template =new RestTemplate();
	
	public Iterable<GameSesion> findbyUserId(String userid){
		HttpEntity<List<GameSesion>> response = template.exchange("http://localhost:8083/webapi/mygames",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<GameSesion>>() {});
		List<GameSesion> mygames = response.getBody();
		return mygames;
	}
	
	public Iterable<GameSesion> findbyGameId(String gameid){
		HttpEntity<List<GameSesion>> response = template.exchange("http://localhost:8083/webapi/gameplayers",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<GameSesion>>() {});
		List<GameSesion> gameplayers = response.getBody();
		return gameplayers;
	}
	
	public void addGameSesion(GameSesion gamesesion) {
		HttpEntity<GameSesion> request = new HttpEntity<>(gamesesion);
		template.postForObject("http://localhost:8080/webapi/insertgamesesion", request, GameSesion.class);
	}

}
