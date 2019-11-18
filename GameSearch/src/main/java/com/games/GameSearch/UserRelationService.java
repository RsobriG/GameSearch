package com.games.GameSearch;

import java.util.ArrayList;
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
		HttpEntity<ArrayList<UserRelation>> response = template.exchange("http://localhost:8083/webapi/myrelations/?userid="+userid,
				HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<UserRelation>>() {});
		ArrayList<UserRelation> myrelations = response.getBody();
		HttpEntity<ArrayList<UserRelation>> response2 = template.exchange("http://localhost:8083/webapi/mytargets/?userid="+userid,
				HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<UserRelation>>() {});
		ArrayList<UserRelation> mytargets = response2.getBody();
		ArrayList<UserRelation> lastrelations = new ArrayList<UserRelation>();
		UserRelation temp = new UserRelation();
		for(UserRelation i:mytargets) {
			myrelations.add(i);
		}
		for(UserRelation i:myrelations) {
			temp = i;
			for(UserRelation z:myrelations) {
				
				if ((i.getUserId().contentEquals(z.getUserId()) && i.getUserTargetId().equals(z.getUserTargetId())) || (i.getUserId().equals(z.getUserTargetId()) && i.getUserTargetId().equals(z.getUserId()))) {					
					if(z.gettStamp().after(i.gettStamp())) {
						temp=z;
					}					
				}}
			if(lastrelations.contains(temp)) {
					
			}else {
				lastrelations.add(temp);
			}			
			}
		
		
		return lastrelations;
	}
	
	public void addUserRelation(UserRelation rel) {
		
		HttpEntity<UserRelation> request = new HttpEntity<UserRelation>(rel);
		template.postForObject("http://localhost:8083/webapi/adduserrelation",request,UserRelation.class);
		
	}
}