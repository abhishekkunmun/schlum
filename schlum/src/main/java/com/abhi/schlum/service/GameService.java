package com.abhi.schlum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.schlum.DAO.GameDAO;
import com.abhi.schlum.model.SearchGames;

@Service
public class GameService {

	@Autowired
	GameDAO gameDAO;
	
	public SearchGames fetchAllGames(String gameName, Integer limit, Integer offset) {
		return gameDAO.getAllGamesByName(gameName,limit,offset);
	}
	
	public SearchGames fetchRandomGames( Integer limit, Integer offset) {
		return gameDAO.getRandomGames(limit,offset);
	}

	public SearchGames fetchByPlatform(String platform, String search,  Integer limit, Integer offset) {
		return gameDAO.getAllGamesByPlatform(platform,search,limit,offset);
	}
	
	public SearchGames fetchByGenre(String genre, String search, Integer limit, Integer offset) {
		return gameDAO.getAllGamesByGenre(genre,search,limit,offset);
	}

	public SearchGames fetchECGames(Integer limit, Integer offset) {
		return gameDAO.getEditorChoiceGames(limit,offset);
	}
	

}
