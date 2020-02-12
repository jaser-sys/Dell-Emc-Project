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
	public List<Object> getEntriesNameFilter(String name){
		List<Object> myFiles= new ArrayList<Object>();
		try (Connection conn = connect();
		PreparedStatement stat = conn.prepareStatement("SELECT * FROM files WHERE Name LIKE ?")){
		stat.setString(1, name+'%');
		ResultSet res = stat.executeQuery();
		 while (res.next()) {
	     	File f1=new File();
	     	f1.setvmIP(res.getString("vmIP"));
	     	f1.setfileName(res.getString("Name"));
	     	f1.setcreationDate(res.getString("creationDate"));
	     	f1.setfileSize(res.getInt("Size"));
	     	f1.setfileLoc(res.getString("Location"));
	     	myFiles.add((Object)f1);
	     }
	   } catch (SQLException e) {
	       System.out.println(e.getMessage());
	   }
		return myFiles;
	}
	public List<Object> getEntriesSizeFilter(int size){
		List<Object> myFiles= new ArrayList<Object>();
		try (Connection conn = connect();
		PreparedStatement stat = conn.prepareStatement("SELECT * FROM files WHERE Size >= ?")){
		stat.setInt(1, size);
		ResultSet res = stat.executeQuery();
		 while (res.next()) {
	     	File f1=new File();
	     	f1.setvmIP(res.getString("vmIP"));
	     	f1.setfileName(res.getString("Name"));
	     	f1.setcreationDate(res.getString("creationDate"));
	     	f1.setfileSize(res.getInt("Size"));
	     	f1.setfileLoc(res.getString("Location"));
	     	myFiles.add((Object)f1);
	     }
	   } catch (SQLException e) {
	       System.out.println(e.getMessage());
	   }
		return myFiles;
	}
  
     
}
