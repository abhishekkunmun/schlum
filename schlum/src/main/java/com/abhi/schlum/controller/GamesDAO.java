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
import com.abhi.schlum.model.ToDoMapper;



@Service
public class GameDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;  
	 
   
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	  
	
	
	public List<Game> getAllGamesByNamer(String gameName, int limit){  
			 return jdbcTemplate.query("select * from schlum.schlum where game like  '%"+gameName+"%'",new ResultSetExtractor<List<Game>>(){  
			    @Override  
			     public List<Game> extractData(ResultSet rs) throws SQLException,  
			            DataAccessException {  
			      
			        List<Game> list=new ArrayList<Game>();  
			        while(rs.next()){  
			        	Game t=new Game();  
			        t.setId(rs.getInt(1));  
			        t.setName(rs.getString(2));  
			        t.setUserName(rs.getString(3));
			        t.setMeta(rs.getString(4));
			        t.setDescription(rs.getString(5));
			        t.setStatus(rs.getString(6));
			        
			    	
			       
			        t.setPriority(rs.getInt(8));
			        t.setDate(rs.getDate(9));
			        t.setCreated(rs.getDate(10));
			        
			        list.add(t);  
			        }  
			        return list;  
			        }  
			    });  
			  
	}  
	
	public Game getGameById(Integer taskId){
		String sql = "select * from hackerearth.todo where id = ?";

		ToDo task = (ToDo)jdbcTemplate.queryForObject(
				sql, new Object[] { taskId },
				new ToDoMapper());

		return task;
	}
	  
}
