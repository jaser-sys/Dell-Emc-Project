package com.server.app.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBInitializeConfig {
	@Autowired
	private DataSource dataSource;
	@PostConstruct
	public Connection initialize(){
		Connection connection=null;
		try {
			connection = dataSource.getConnection();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
