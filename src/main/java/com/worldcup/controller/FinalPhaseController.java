package com.worldcup.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.worldcup.model.Game;
import com.worldcup.model.GameForm;
import com.worldcup.model.Player;
import com.worldcup.service.GameService;
import com.worldcup.service.PlayerService;

@Controller
@SessionAttributes("gameForm")
public class FinalPhaseController {
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private PlayerService playerService;
	
	
	//private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	@RequestMapping(value = "/addFinalPhase", method = RequestMethod.GET)
	public ModelAndView  addFinalPhase(HttpSession session) {
		
		org.springframework.security.core.userdetails.User user = 
				(org.springframework.security.core.userdetails.User)
				SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String username = user.getUsername();
		Player player = playerService.getCurrentPlayer(username);
		
		GameForm gameForm = gameService.findFinalPhase(player);
		
		ModelAndView mav = new ModelAndView("addFinalPhase","gameForm",gameForm);

		return mav;
	}
	
	@RequestMapping(value = "/addFinalPhase", method = RequestMethod.POST)
	public String updateFinalPhase(
			@Valid @ModelAttribute("gameForm") GameForm gameForm, 
			BindingResult result
			) {
		
			List<Game> games = gameForm.getGames();
	
			if(result.hasErrors()) {
				return "/addFinalPhase";
			} else {
				gameService.saveList(games);
			}
		
			return "/addFinalPhase";

	}

}
