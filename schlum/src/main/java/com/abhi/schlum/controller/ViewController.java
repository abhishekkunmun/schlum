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
		model.addAttribute("userName", "abhishek");
		return "home";
	}
	
	@RequestMapping(value = "/portal", method = RequestMethod.GET)
	public String portal( Model model) {	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); 

	      model.addAttribute("userName", name);
		
		return "portal";
	}
	
	
	
	@RequestMapping(value = "/fetch-all/{gameName}/{limit}/{offset}", method = RequestMethod.GET)
	public ResponseEntity<List<Game>> getAllData(@PathVariable("gameName") String gameName, 
			@PathVariable("limit") Integer limit,
			@PathVariable("offset") Integer offset){
		List<Game> games = null;
		try{
			games= gameService.fetchAllGames(gameName,limit,offset);
		}
		catch(Exception e){
			return new ResponseEntity<List<Game>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<Game>>(games,HttpStatus.OK);
	}
	
	/*@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<ToDo> postSomeData(@RequestBody Game task){
		
		try{
			taskService.updateTask(task);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<ToDo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ToDo>(task,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> postSomeData(@PathVariable("id") Integer id){
		
		try{
			taskService.deleteTask(id);	
		}
		catch(Exception e){
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	*/
	
}
