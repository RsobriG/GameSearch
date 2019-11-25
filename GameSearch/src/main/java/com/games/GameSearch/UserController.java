package com.games.GameSearch;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller



@RequestMapping("/")
public class UserController {

		@Autowired
		UserService service;
		
		@RequestMapping("/login")
		public String login() {
			return "users/login";
		}
		
		@RequestMapping("/signIn")
		public String signIn() {
			return "users/signIn";
		}
	
		
		@RequestMapping("/newUser") 
		public String newUser(User user, Model model, HttpSession session) { 
				
				
			user.setUsersession(session.getId());
			
			service.insertNewUserToDB(user);
			
			model.addAttribute("usersList", service.findUserbyNickname(user.getNickName()));
			
			
			return "home/index";
	  
		}
		
		@RequestMapping("/searchUserByName")
		public String findUserByName(User user, Model model) {
			
			service.findUserbyName(user);
			model.addAttribute("usersFinded", service.findAll());
			
			
			return "home/index";
		}
		
		@RequestMapping("/searchUserByNickname")
		public String findUserByNickname(User user, Model model) {
			
			service.findUserbyName(user);
			model.addAttribute("nicknameFinded", service.findAll());
			
			
			return "home/index";
		}
		
		@RequestMapping ("/searchUserByEmail")
		public String searchUserByEmail (User user, Model model) {
			
			User userLoging = new User();
			
			if(user.getMail().equals(userLoging.getMail())) {
				model.addAttribute("userRegistered", service.findUserByEmail(user.getMail()));
				return "home/home";
			}
			
			return "home/error";
		}

}
