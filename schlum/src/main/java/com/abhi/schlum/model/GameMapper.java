package com.abhi.schlum.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GameMapper implements RowMapper {  
 public Game mapRow(ResultSet rs, int rowNum) throws SQLException {  
	 Game game = new Game();  
	 game.setId(rs.getInt(1));  
	 game.setTitle(rs.getString(2));  
     game.setUrl(rs.getString(3));
     game.setPlatform(rs.getString(4));
     game.setScore(rs.getFloat(5));
     game.setGenre(rs.getString(6));
     game.setEditors_choice(rs.getBoolean(7));
     game.setRelease_year(rs.getInt(8));
  	
     
    
  return game;  
 }  
}