package com.worldcup.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.worldcup.model.WorldCup;
import com.worldcup.model.WorldCupForm;
import com.worldcup.service.GameService;
import com.worldcup.service.WorldCupService;

@Controller
@SessionAttributes("worldCupForm")
public class WorldCupController {
	
	@Autowired
	private WorldCupService worldCupService;
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping(value="/worldCupScore", method = RequestMethod.GET)
	public ModelAndView  getWorldCupScore(HttpSession session) {
		

		
		List<WorldCup> worldCupGames = worldCupService.findGroupWorldCupGames();
		if (worldCupService.isPhase1Completed()){
			worldCupGames=worldCupService.findAllWorldCupGames();	;	
		}
				

		
		WorldCupForm worldCupForm = new WorldCupForm(worldCupGames);
		
		ModelAndView mav = new ModelAndView("worldCupScore","worldCupForm",worldCupForm);
		mav.addObject("isGroupCompleted",  worldCupService.isPhase1Completed());
		mav.addObject("isGroupCompleted8", worldCupService.isPhaseTypeCompleted("08"));
		mav.addObject("isGroupCompleted4", worldCupService.isPhaseTypeCompleted("04"));
		mav.addObject("isGroupCompleted2", worldCupService.isPhaseTypeCompleted("02"));
		mav.addObject("isGroupCompleted1", worldCupService.isPhaseTypeCompleted("01"));
		
		return mav;
	}
	
	@RequestMapping(value = "/worldCupScore", method = RequestMethod.POST)
	public String updateWorldCupScore(
			@Valid @ModelAttribute("worldCupForm") WorldCupForm WorldCupForm, 
			BindingResult result
			) {

			List<WorldCup> worldCupGames = WorldCupForm.getWorldCupGames();
		


		if(result.hasErrors()) {
			return  "worldCupScore";
		} else {
			worldCupService.saveListWorldCup(worldCupGames);
			if(worldCupService.isPhase1Completed()) {
				worldCupService.fillRoundOf16();
				gameService.createRoundOfForAll("08");				
				if(worldCupService.isPhaseTypeCompleted("08")) {
					gameService.createRoundOfForAll("04");
					if(worldCupService.isPhaseTypeCompleted("04")) {
						gameService.createRoundOfForAll("02");
						if(worldCupService.isPhaseTypeCompleted("02")) {
							gameService.createRoundOfForAll("01");
						}
					}	
				}			
			}
		}		
		return "redirect:index.jsp";
	}

}
