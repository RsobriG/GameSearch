package com.games.GameSearch;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;


@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	RestTemplate template = new RestTemplate();
	

	public void insertUser(User user) {
		HttpEntity<User> request = new HttpEntity<>(user);
		template.postForObject("http://localhost:8083/webapi/users", request, User.class);

	}

	public Iterable<User> findAll() {
		ResponseEntity<List<User>> response = template.exchange("http://localhost:8083/webapi/users", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<User>>() {
				});

		List<User> users = response.getBody();
		return users;
	}

	public Iterable<User> findUserbyName(User user) {
		ResponseEntity<List<User>> response = template.exchange("http://localhost:8083/webapi/users", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<User>>() {
				});

		List<User> users = response.getBody();

		return users;

	}

	public User findUserbyNickname(String nickname) {
		
		User user = repository.findUserByNickname(nickname);
		
		return user;
		
	}
	
	public void insertNewUserToDB(User user) {
		
		repository.save(user);
	
	}


	 public User findUserByEmail(String email){
  
		 Optional<User> user1 = repository.findById(email);
		 
		 return user1.get();
	
	 }
  
  }
 
