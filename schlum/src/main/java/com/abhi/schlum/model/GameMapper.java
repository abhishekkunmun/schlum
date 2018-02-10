package com.abhi.schlum.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class GameMapper implements RowMapper {  
 public Game mapRow(ResultSet rs, int rowNum) throws SQLException {  
	 Game game = new Game();  
	  task.setId(rs.getInt(1));  
      task.setName(rs.getString(2));  
      task.setUserName(rs.getString(3));
      task.setMeta(rs.getString(4));
      task.setDescription(rs.getString(5));
      task.setStatus(rs.getString(6));
      
  	String allLabels = rs.getString(7);
  	if(allLabels!=null && !allLabels.isEmpty()){
  		 List<String> labels= Arrays.asList(allLabels.split("\\|"));
  		 task.setLabels(labels);
  	}
     
      task.setPriority(rs.getInt(8));
      task.setDate(rs.getDate(9));
      task.setCreated(rs.getDate(10));
  return task;  
 }  
}