package com.abhi.schlum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.schlum.controller.GameDAO;
import com.abhi.schlum.model.Game;

@Service
public class GameService {

	@Autowired
	GameDAO gameDAO;
	
	public List<Game> fetchAllGames(String gameName, Integer limit, Integer offset) {
		return gameDAO.getAllGamesByName(gameName,limit,offset);
	}

}
