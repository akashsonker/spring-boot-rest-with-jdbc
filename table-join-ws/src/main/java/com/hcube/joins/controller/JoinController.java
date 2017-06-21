package com.hcube.joins.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcube.joins.model.DBSource;
import com.hcube.joins.util.RestURI;

@RestController
public class JoinController {
	private static final Logger logger = LoggerFactory.getLogger(JoinController.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	// Map to store DBSource, ideally we should use database
	Map<String, DBSource> dbData = new HashMap<String, DBSource>();

	@RequestMapping(value = RestURI.CON_DETAILS, method = RequestMethod.GET)
	public DBSource getDummySource() {
		logger.info("Start getDummySource");
		DBSource src = new DBSource();
		src.setUrl("myurl");
		src.setUser("akash");
		src.setPassword("123");
		src.setTableName("emp");
		src.setSourceName("mysql");
		dbData.put(src.getSourceName(), src);
		return src;
	}

	@RequestMapping(value="/insert",method = RequestMethod.GET)
	public String index() {
		
		jdbcTemplate.execute("insert into customer(name,email,created_date)values('xxxx','666@yahoo.com', '2017-02-17')");
		
		return "data inserted Successfully";
	}
}
