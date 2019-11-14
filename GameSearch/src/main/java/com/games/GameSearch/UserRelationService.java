package com.games.GameSearch;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class UserRelationService {

	RestTemplate template = new RestTemplate();
	
	public void addUserRelation(UserRelation rel) {
		
		HttpEntity<UserRelation> request = new HttpEntity<>(rel);
		template.postForObject("http://localhost:8080/userrelationapi/userrelations",request,UserRelation.class);
		
	}
}