package com.abhi.schlum.controller;


import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abhi.schlum.model.Game;
import com.abhi.schlum.model.SearchGames;
import com.abhi.schlum.service.GameService;


@Controller
public class ViewController {
	
	@Autowired
	GameService gameService;
	/*static{
		System.setProperty("java.net.useSystemProxies", "true");		
	}*/
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String redirectLogin(Locale locale, Model model) {
		
		return "redirect:login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {

		    return ("forward:/home");
		}
		return "login"; 
	}
	

	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home( Model model) {	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); 

	      model.addAttribute("userName", name);
		
		return "home";
	}
	
	
	
	@RequestMapping(value = "/fetch-all/{gameName}/{limit}/{offset}", method = RequestMethod.GET)
	public ResponseEntity<SearchGames> getGames(@PathVariable("gameName") String gameName, 
			@PathVariable("limit") Integer limit,
			@PathVariable("offset") Integer offset){
		SearchGames games = null;
		try{
			games= gameService.fetchAllGames(gameName,limit,offset);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<SearchGames>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<SearchGames>(games,HttpStatus.OK);
	}
	@RequestMapping(value = "/fetch-random/{limit}/{offset}", method = RequestMethod.GET)
	public ResponseEntity<SearchGames> getRandomGames(
			@PathVariable("limit") Integer limit,
			@PathVariable("offset") Integer offset){
		SearchGames games = null;
		try{
			games= gameService.fetchRandomGames(limit,offset);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<SearchGames>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<SearchGames>(games,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/fetch-platform/{platform}/{search}/{limit}/{offset}", method = RequestMethod.GET)
	public ResponseEntity<SearchGames> getGamesByPlatform(@PathVariable("platform") String platform, @PathVariable("search") String search,
			@PathVariable("limit") Integer limit,
			@PathVariable("offset") Integer offset){
		SearchGames games = null;
		try{
			games= gameService.fetchByPlatform(platform,search,limit,offset);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<SearchGames>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<SearchGames>(games,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/fetch-genre/{genre}/{search}/{limit}/{offset}", method = RequestMethod.GET)
	public ResponseEntity<SearchGames> getGamesByGenre(@PathVariable("genre") String genre, @PathVariable("search") String search,
			@PathVariable("limit") Integer limit,
			@PathVariable("offset") Integer offset){
		SearchGames games = null;
		try{
			games= gameService.fetchByGenre(genre,search,limit,offset);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<SearchGames>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<SearchGames>(games,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/fetch-ec/{limit}/{offset}", method = RequestMethod.GET)
	public ResponseEntity<SearchGames> getGamesEC(
			@PathVariable("limit") Integer limit,
			@PathVariable("offset") Integer offset){
		SearchGames games = null;
		try{
			games= gameService.fetchECGames(limit,offset);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<SearchGames>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<SearchGames>(games,HttpStatus.OK);
	}
}
