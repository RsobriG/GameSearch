package com.games.GameSearch;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class UserService {

	RestTemplate template = new RestTemplate();
	
	public void insertUser (User user) {
		HttpEntity<User> request = new HttpEntity<>(user);
		template.postForObject("http://localhost:8083/webapi/users", request, User.class);
		
	}
	
	public Iterable<User> findAll(){
		ResponseEntity<List<User>> response = template.exchange("http://localhost:8083/webapi/users", 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
		
		List<User> users = response.getBody();
		return users;
	}

	
}
