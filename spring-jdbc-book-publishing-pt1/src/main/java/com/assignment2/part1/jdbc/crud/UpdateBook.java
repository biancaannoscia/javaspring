package com.assignment2.part1.jdbc.crud;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UpdateBook {
	private JdbcTemplate jdbcTemplate;
	
	public UpdateBook (DataSource dataSource) {	
		// create a JdbcTemplate and set data source
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        this.jdbcTemplate = jdbcTemplate;
	}
	
	public void update(Long bookID) {
		jdbcTemplate.update("update book set title = 'Kurt Vonnegut' where id = ?", bookID);

	}

}
