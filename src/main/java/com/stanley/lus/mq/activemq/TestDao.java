package com.stanley.lus.mq.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class TestDao {
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	@Transactional(readOnly=false)  
	public void insert(final String name) {  
	    jdbcTemplate.update("insert into test(name) values(?)", name);  
	  
	}
}
