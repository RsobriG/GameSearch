package com.games.GameSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gamesesion")
public class GameSesionController {
	
	@Autowired
	GameSesionService service;
	
	@RequestMapping("/mygames")
	public String myGames (String userid, Model model) {
		model.addAttribute("mygames",service.findbyUserId(userid));
		return "gamesesion/mygames";
	}
	
	@RequestMapping("/gameplayers")
	public String gamePlayers (String gameid, Model model) {
		model.addAttribute("gameplayers",service.findbyGameId(gameid));
		return "gamesesion/gameplayers";
	}
	
	

}
