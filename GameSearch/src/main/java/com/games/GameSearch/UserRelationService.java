package com.games.GameSearch;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class UserRelationService {

	RestTemplate template = new RestTemplate();
	
	public Iterable<UserRelation> findbyUserId(String userid){
		HttpEntity<List<UserRelation>> response = template.exchange("http://localhost:8083/webapi/myrelations",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<UserRelation>>() {});
		List<UserRelation> myrelations = response.getBody();
		return myrelations;
	}
	
	public void addUserRelation(UserRelation rel) {
		
		HttpEntity<UserRelation> request = new HttpEntity<UserRelation>(rel);
		template.postForObject("http://localhost:8083/webapi/adduserrelation",request,UserRelation.class);
		
	}
}