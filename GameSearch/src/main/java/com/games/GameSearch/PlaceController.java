package com.games.GameSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/places")
public class PlaceController {
	
	@Autowired
	PlaceService service;
	
	@RequestMapping("/placebyname")
	public String placebyName(String name, Model model) {
		model.addAttribute("placebyname",service.findbyName(name));
		return "places/placebyname";		
	}

}
