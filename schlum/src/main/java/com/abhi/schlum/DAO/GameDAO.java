package com.abhi.schlum.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.abhi.schlum.model.Game;
import com.abhi.schlum.model.SearchGames;



@Service
public class GameDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;  
	 
   
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	  
	
	
	public SearchGames getAllGamesByName(String gameName, Integer limit, Integer offset){  
		SearchGames searchGames = new SearchGames();
		 String sql = "select count(*) from schlum where  title ilike  '%"+gameName+"%'";
		List<Game> games = jdbcTemplate.query("select * from schlum where title ilike  '%"+gameName+"%' limit "+limit+" offset "+offset,new ResultSetExtractor<List<Game>>(){  
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
		searchGames.setCount(jdbcTemplate.queryForInt(sql));  
		searchGames.setGames(games);  
		 
		 return searchGames;
			  
	}  
	
	public SearchGames getRandomGames( Integer limit, Integer offset){  
		SearchGames searchGames = new SearchGames();
		List<Game> games = jdbcTemplate.query("select * from schlum order by random() limit "+limit+" offset "+offset,new ResultSetExtractor<List<Game>>(){  
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
		searchGames.setCount(10);
		searchGames.setGames(games);  
		 
		 return searchGames;
		  
}



	public SearchGames getAllGamesByPlatform(String platform, String search, Integer limit, Integer offset) {
		SearchGames searchGames = new SearchGames();
		 String sql = "select count(*) from schlum where platform =  '"+platform+"' and title ilike '%"+search+"%'"; 	
		String query = "select * from schlum where platform =  '"+platform+"' and title ilike '%"+search+"%' limit "+limit+" offset "+offset;
		
		if("ALL".equalsIgnoreCase(platform)){
			query = "select * from schlum where platform =  '"+platform+"' limit "+limit+" offset "+offset;
			sql = "select count(*) from schlum where platform =  '"+platform+"'";
		}
		searchGames.setCount(jdbcTemplate.queryForInt(sql));  
		System.out.println(query);
		List<Game> games =  jdbcTemplate.query(query,new ResultSetExtractor<List<Game>>(){  
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
		searchGames.setGames(games);  
		 
		 return searchGames;
	}  
	
	
	public SearchGames getAllGamesByGenre(String genre, String search, Integer limit, Integer offset) {
		SearchGames searchGames = new SearchGames();
		 String sql = "select count(*) from schlum where genre =  '"+genre+"' and title ilike '%"+search+"%'"; 		       
		String query = "select * from schlum where genre =  '"+genre+"' and title ilike '%"+search+"%' limit "+limit+" offset "+offset;
		if("ALL".equalsIgnoreCase(genre)){
			sql = "select count(*) from schlum where genre =  '"+genre+"'";
			query = "select * from schlum where genre =  '"+genre+"' limit "+limit+" offset "+offset;
		}
		searchGames.setCount(jdbcTemplate.queryForInt(sql));  
		System.out.println(query);
		List<Game> games = jdbcTemplate.query(query,new ResultSetExtractor<List<Game>>(){  
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
		searchGames.setGames(games);  
		 
		 return searchGames;
	}



	public SearchGames getEditorChoiceGames(Integer limit, Integer offset) {
		SearchGames searchGames = new SearchGames();
		List<Game> games = jdbcTemplate.query("select * from schlum where editors_choice = true order by random() limit "+limit+" offset "+offset,new ResultSetExtractor<List<Game>>(){  
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
		searchGames.setCount(10);
		searchGames.setGames(games);  
		 
		 return searchGames;
	}  
	  
}
