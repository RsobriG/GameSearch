package com.games.GameSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

		@Autowired
		UserService service;
		
	/*
	 * @RequestMapping("/usersList") public String showUsers(Model model) {
	 * 
	 * model.addAttribute("usersList", service.findAll()); return "users/usersList";
	 * }
	 */
		
		@RequestMapping("/newUser")
		public String newUser() {
			return "users/newUser";
		}
		
		@RequestMapping("/insertUser")
		public String insertUser(User user, Model model) {
			
			service.insertUser(user);
			model.addAttribute("usersList", service.findAll());
			
			return "users/usersList";
			
		}
		
		

}
