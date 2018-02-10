package com.abhi.schlum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.schlum.DAO.GameDAO;
import com.abhi.schlum.model.Game;

@Service
public class GameService {

	@Autowired
	GameDAO gameDAO;
	
	public List<Game> fetchAllGames(String gameName, Integer limit, Integer offset) {
		return gameDAO.getAllGamesByName(gameName,limit,offset);
	}
	
	public List<Game> fetchRandomGames( Integer limit, Integer offset) {
		return gameDAO.getRandomGames(limit,offset);
	}

	public List<Game> fetchByPlatform(String platform, String search,  Integer limit, Integer offset) {
		return gameDAO.getAllGamesByPlatform(platform,search,limit,offset);
	}
	
	public List<Game> fetchByGenre(String genre, String search, Integer limit, Integer offset) {
		return gameDAO.getAllGamesByGenre(genre,search,limit,offset);
	}
	

}
