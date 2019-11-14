package com.games.GameSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.games.GameSearch.UserRelation.Friendship;


@Controller
@RequestMapping("/userrelation")
public class UserRelationController {
	
	
	@Autowired
	UserRelationService service;
	
	
	@RequestMapping("/addUserRelation")
	public String addUserRelation (String user, String userTarget, Friendship state/*Model model*/) {
		
		service.addUserRelation(new UserRelation(user,userTarget,state));
		//model.addAttribute("library",service.findAll());
		
		return "games/gamesList";	}

}
