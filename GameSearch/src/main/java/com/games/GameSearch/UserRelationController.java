package com.games.GameSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.games.GameSearch.UserRelation.Friendship;


@Controller
@RequestMapping("/userrelation")
public class UserRelationController {
	
	
	@Autowired
	UserRelationService service;
	
	@RequestMapping("/myrelations")
	public String myRelations (String userid, Model model) {
		model.addAttribute("myrelations", service.findbyUserId(userid));
		return "userrelations/myrelations";
	}
	
	
	@RequestMapping("/adduserrelation")
	public String addUserRelation (String user, String userTarget, String state/*Model model*/) {
		state = state.toUpperCase();
		Friendship parseFriendship = Friendship.valueOf(state);
		service.addUserRelation(new UserRelation(user,userTarget,parseFriendship));
		//model.addAttribute("library",service.findAll());
		
		return "userrelations/myrelations";	}
	
	

}
