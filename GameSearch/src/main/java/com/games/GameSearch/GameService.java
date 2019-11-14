package com.games.GameSearch;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class GameService {

	RestTemplate template = new RestTemplate();
	
	public void insertGame (Game game) {
		HttpEntity<Game> request = new HttpEntity<>(game);
		template.postForObject("http://localhost:8083/webapi/games", request, Game.class);
	}
		
	public Iterable<Game> findAll() {
		ResponseEntity<List<Game>> response = template.exchange("http://localhost:8083/webapi/games",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Game>>() {});
		
		List<Game> games= response.getBody();
		return games;
	}
	
	public void deleteGame (Game game) {
		
		template.delete("http://localhost:8083/webapi/games/" + game.getGameId());
	}

	
}
