package com.worldcup.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.worldcup.model.Game;
import com.worldcup.model.GameForm;
import com.worldcup.model.KnockOutPhase;
import com.worldcup.model.KnockOutPhaseForm;
import com.worldcup.model.Player;
import com.worldcup.repository.GameRepository;
import com.worldcup.service.GameService;
import com.worldcup.service.PlayerService;

@Controller
@SessionAttributes(value= {"gameForm","gameForm08","gameForm04","gameForm02","gameForm01"})
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private PlayerService playerService;
	
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	@RequestMapping(value = "/addScore/{group}", method = RequestMethod.GET)
	public ModelAndView  addScore(@PathVariable String group, HttpSession session) {
		
		org.springframework.security.core.userdetails.User user = 
				(org.springframework.security.core.userdetails.User)
				SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String username = user.getUsername();
		Player player = playerService.getCurrentPlayer(username);
		
		GameForm gameForm = gameService.findGroupGames(group,player);
		
		ModelAndView mav = new ModelAndView("addScore","gameForm",gameForm);
		mav.addObject("group", group);

		return mav;
	}
	
	@RequestMapping(value = "/addScore/{group}", method = RequestMethod.POST)
	public String updateScore(
			@Valid @ModelAttribute("gameForm") GameForm gameForm, 
			@PathVariable String group, 
			BindingResult result
			) throws ParseException {
		
		List<Game> games = gameForm.getGames();
		Player player = games.get(0).getPlayer();
	
		Date now = new Date();
		final Date submitDate = sdf.parse("2018/06/13 23:59:59");
		long diffInMillies = submitDate.getTime() - now.getTime();
		
		if (diffInMillies <0) {
			return "redirect:https://media.giphy.com/media/3oriNKQe0D6uQVjcIM/giphy.mp4";
		} else {
		
			if(result.hasErrors()) {
				return "/addScore/" + group;
			} else {
				gameService.saveList(games);
				if(playerService.isGroupCompleted(group, player)) {
					gameService.fillGroupForRoundOf16(player, group);
				}
			}
		
			return "redirect:../index.jsp";
		}
	}
 	
 	@RequestMapping(value="/otherPlayers/{username}", method = RequestMethod.GET)
 	public ModelAndView  getPlayerScore(@PathVariable String username, HttpSession session) throws ParseException {
 		
		Player player = playerService.getCurrentPlayer(username);
 		
 		List<Game> otherPlayers = gameService.findListByPlayer(player);
 		GameForm knockOutPhaseForm = gameService.findKnockOutPhase(player);
 		List<Game> knockOutPhase = knockOutPhaseForm.getGames();
 		
		ModelAndView mav = new ModelAndView("otherPlayers","otherPlayers",otherPlayers);
		mav.addObject("knockOutPhase", knockOutPhase);
		
		Date now = new Date();
		final Date submitDate = sdf.parse("2018/06/01 23:59:59");
		long diffInMillies = submitDate.getTime() - now.getTime();
		
		if (diffInMillies > 0) {
			return new ModelAndView("redirect:https://media.giphy.com/media/3ohs7Ocesq1gHxgFI4/source.gif");
		} else {
			return mav;
		}
 	}
 	
	@RequestMapping(value = "/knockoutStage", method = RequestMethod.GET)
	public ModelAndView  addKnockOutPhase(HttpSession session) {
		
		org.springframework.security.core.userdetails.User user = 
				(org.springframework.security.core.userdetails.User)
				SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String username = user.getUsername();
		Player player = playerService.getCurrentPlayer(username);
		
		GameForm gameForm = gameService.findKnockOutPhase(player);
		
		ModelAndView mav = new ModelAndView("knockoutStage","gameForm",gameForm);

		return mav;
	}
 	
	@RequestMapping(value = "/knockoutStage", method = RequestMethod.POST)
	public String updateKnockOutPhase(
			@Valid @ModelAttribute("gameForm") GameForm gameForm,
			BindingResult result
			) throws ParseException {
		
		List<Game> games = gameForm.getGames();

		Date now = new Date();
		final Date submitDate = sdf.parse("2018/06/13 23:59:59");
		long diffInMillies = submitDate.getTime() - now.getTime();
		
		if (diffInMillies <0) {
			return "redirect:https://media.giphy.com/media/3oriNKQe0D6uQVjcIM/giphy.mp4";
		} else {
		
			if(result.hasErrors()) {
				return "/knockoutStage";
			} else {
				gameService.saveList(games);
			}
		
			return "redirect:index.jsp";
		}
	}
	
}
