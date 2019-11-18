package com.games.GameSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.games.GameSearch.GameSesion.GRelation;




@Controller
@RequestMapping("/gamesesion")
public class GameSesionController {
	
	@Autowired
	GameSesionService service;
	
	@RequestMapping("/mygames")
	public String myGames (String userid, Model model) {

		model.addAttribute("mygames",service.findbyUserId(userid));
		return "gamesesion/gamesesionList";
	}
	
	@RequestMapping("/gameplayers")
	public String gamePlayers (long gameid, Model model) {
		model.addAttribute("gameplayers",service.findbyGameId(gameid));
		return "gamesesion/gamesesionList";
	}
	
	@RequestMapping("/addgamesesion")
	public String addGameSesion(long gameid,String userid, String relation) {
		relation = relation.toUpperCase();
		GRelation parsedRelation = GRelation.valueOf(relation);
		service.addGameSesion(new GameSesion(gameid,userid,parsedRelation));
		return "gamesesion/gameplayers";
	}

}
