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
	String sqlCommand = "INSERT INTO files (vmIP, Name, creationDate,Size ,Location) "
	 		+ "VALUES("+ ((File)o).getvmIP() +",\'" + ((File)o).getfileName() + "\',\'" + ((File)o).getCreationDate() + "\',\'" + ((File)o).getfileSize() +"\',\'" + ((File)o).getfileLoc() + "\');" ;
	
	 try (Connection conn = super.connect();
			 PreparedStatement stmt  = conn.prepareStatement(sqlCommand) ){				 
		 stmt.executeUpdate();
        }
	 catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     }
	
	public List<Object> getAllEntries() {
		String sqlCommand = "SELECT * FROM files;" ;
		List<Object> myFiles= new ArrayList<Object>();
		
		try (Connection conn = this.connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet result    = stmt.executeQuery(sqlCommand)){
	            while (result.next()) {
	            	File f1=new File();
	            	f1.setvmIP(result.getString("vmIP"));
	            	f1.setfileName(result.getString("Name"));
	            	f1.setcreationDate(result.getString("creationDate"));
	            	f1.setfileSize(result.getInt("fileSize"));
	            	f1.setfileLoc(result.getString("fileLoc"));
	            	myFiles.add((Object)f1);
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return myFiles;
	}

	@Override
	public void deleteEntryByID(int entryId) {
		
		
	}
	
  
     
}
