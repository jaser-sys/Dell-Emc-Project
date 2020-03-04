package com.server.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public abstract class SqliteDB  {
	
		public Connection connect() {
	        String DB_url = "jdbc:sqlite:C:\\Users\\abeer\\Desktop\\Dell-Emc-Project\\mySqliteDB\\myDatabase.db";
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(DB_url);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	  }
		abstract public void addNewEntry(Object o);
		abstract public List<Object> getEntries();
		abstract public void deleteEntryByID(UUID entryId);
		

		
}
