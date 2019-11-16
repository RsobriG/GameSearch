package com.games.GameSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/addplace")
	public String addPlace(Place place) {
		service.addPlace(place);
		return "places/placebyname";
	}
	
	@RequestMapping("/deleteplace")
	public String deletePlace(@RequestParam("placeId") long placeid) {
		Place place = new Place(placeid);
		service.deletePlace(place);
		return "places/placebyname";
	}

}
