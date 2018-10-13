package com.assignment2.part1.jdbc.crud;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;


import com.assignment2.part1.jdbc.domain.Category;

public class FindAllCategories extends MappingSqlQuery<Category> {
	private static Logger logger = LoggerFactory.getLogger(
			FindAllCategories.class);
	private static final  String SQL_SELECT_ALL_CATEGORY = 
			"select * from category";
	
	public FindAllCategories(DataSource datasource) {
		super(datasource,SQL_SELECT_ALL_CATEGORY);
	}
	
	protected Category mapRow (ResultSet rs, int rowNum) throws SQLException {
		Category category = new Category();
		
		category.setId(rs.getLong("id"));
		category.setName(rs.getString("name"));
		
		return category;	
		
	}



}
