package com.server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class FileQuery extends SqliteDB{
	public void addNewEntry(Object o) {
	String sqlCommand = "INSERT INTO files (vmID, Name, creationDate, Location) "
	 		+ "VALUES("+ ((File)o).getVmID() +",\'" + ((File)o).getName() + "\',\'" + ((File)o).getSize() + "\',\'" + ((File)o).getCreationDate() +"\',\'" + ((File)o).getLocation() + "\');" ;
	
	 try (Connection conn = super.connect();
			 PreparedStatement stmt  = conn.prepareStatement(sqlCommand) ){				 
		 stmt.executeUpdate();
        }
	 catch (SQLException e) {
            System.out.println(e.getMessage());
        }
}
}
