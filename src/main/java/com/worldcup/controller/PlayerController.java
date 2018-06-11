package com.worldcup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.worldcup.model.Player;
import com.worldcup.service.PlayerService;

@Controller
public class PlayerController {

  	@Autowired
 	private PlayerService playerService;
	
 	@RequestMapping(value="/ranking", method = RequestMethod.GET)
 	public String getPlayerRanking(Model model) {
 		
 		List<Player> ranking = playerService.createRanking();
 		
 		model.addAttribute("ranking",ranking);
 
 		return "ranking";
 	}


}
