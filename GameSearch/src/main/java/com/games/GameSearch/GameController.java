package com.games.GameSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/games")
public class GameController {
	
	@Autowired
	GameService service;
	
	@RequestMapping("/gamesList")
	public String showGames (Model model) {
		
		model.addAttribute("gamesList", service.findAll());
		return "games/gamesList";
	}

	@RequestMapping("/newGame")
	public String newGame () {
		return "games/newGame";
	}
	
	@RequestMapping("/insertGame")
	public String insertGame(Game game, Model model) {
		
		service.insertGame(game);
		System.out.println(game.getGametype());
		System.out.println(game.getGamestate());
		
		model.addAttribute("gamesList", service.findAll());
		
		
		return "games/gamesList";
	}
		
	@RequestMapping("/deleteGame")
	public String deleteGame(@RequestParam("name") String name, Model model) {
		
		Game game = new Game(name);
		
		service.deleteGame(game);
		model.addAttribute("gamesList", service.findAll());
				
		return "games/gamesList";
		
	}
	
}
