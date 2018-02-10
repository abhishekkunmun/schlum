package com.abhi.schlum.controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.abhi.schlum.model.Game;
import com.abhi.schlum.model.GameMapper;



@Service
public class GameDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;  
	 
   
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	  
	
	
	public List<Game> getAllGamesByName(String gameName, int limit){  
			 return jdbcTemplate.query("select distinct(*) from schlum where title like  '%"+gameName+"%'",new ResultSetExtractor<List<Game>>(){  
			     public List<Game> extractData(ResultSet rs) throws SQLException,  
			            DataAccessException {  
			      
			        List<Game> list=new ArrayList<Game>();  
			        while(rs.next()){  
			        	 Game game = new Game();  
			        	 game.setId(rs.getInt(1));  
			        	 game.setTitle(rs.getString(2));  
			             game.setUrl(rs.getString(3));
			             game.setPlatform(rs.getString(4));
			             game.setScore(rs.getFloat(5));
			             game.setGenre(rs.getString(6));
			             game.setEditors_choice(rs.getBoolean(7));
			             game.setRelease_year(rs.getInt(8));
			        
			        list.add(game);  
			        }  
			        return list;  
			        }  
			    });  
			  
	}  
	
	  
}
