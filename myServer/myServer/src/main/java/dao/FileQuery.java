package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dao.SqliteDB;
import model.File;


public class FileQuery extends SqliteDB{
	
	
	public void addNewEntry(Object o) {
	String sqlCommand = "INSERT INTO files (vmID, name, creationDate, size , location) "
	 		+ "VALUES(\'"+ ((File)o).getvmID() +"\',\'" + ((File)o).getfileName() + "\',\'" + ((File)o).getCreationDate() + "\',\'" + ((File)o).getfileSize() +"\',\'" + ((File)o).getfileLoc() + "\');" ;
	
	 try (Connection conn = super.connect();
			 PreparedStatement stmt  = conn.prepareStatement(sqlCommand) ){				 
		 stmt.executeUpdate();
        }
	 catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     }
	
	public void addListEntries(ArrayList<File> filesList) {
		
		if(filesList.size() == 0) {
			System.out.println("No files to be added");
		}else {
		  for(Object file : filesList) {
			  addNewEntry(file);
		  }
		}
	}
	
	public List<Object> getEntries() {
		String sqlCommand = "SELECT * FROM files;" ;
		List<Object> myFiles= new ArrayList<Object>();
		
		try (Connection conn = this.connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet result    = stmt.executeQuery(sqlCommand)){
	            while (result.next()) {
	            	File f1=new File();
	            	f1.setvmID(UUID.fromString(result.getString("vmID")));
	            	f1.setfileName(result.getString("name"));
	            	f1.setcreationDate(result.getString("creationDate"));
	            	f1.setfileSize(result.getInt("size"));
	            	f1.setfileLoc(result.getString("location"));
	            	myFiles.add((Object)f1);
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return myFiles;
	}

	@Override
	public void deleteEntryByID(UUID entryId) {
		
		
	}
	public List<Object> getEntriesNameFilter(String name){
		List<Object> myFiles= new ArrayList<Object>();
		try (Connection conn = connect();
		PreparedStatement stat = conn.prepareStatement("SELECT * FROM files WHERE name LIKE ?")){
		stat.setString(1, name+'%');
		ResultSet res = stat.executeQuery();
		 while (res.next()) {
	     	File f1=new File();
	     	f1.setvmID(UUID.fromString(res.getString("vmID")));
	     	f1.setfileName(res.getString("name"));
	     	f1.setcreationDate(res.getString("creationDate"));
	     	f1.setfileSize(res.getInt("size"));
	     	f1.setfileLoc(res.getString("location"));
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
		PreparedStatement stat = conn.prepareStatement("SELECT * FROM files WHERE size >= ?")){
		stat.setInt(1, size);
		ResultSet res = stat.executeQuery();
		 while (res.next()) {
	     	File f1=new File();
	     	f1.setvmID(UUID.fromString(res.getString("vmID")));
	     	f1.setfileName(res.getString("name"));
	     	f1.setcreationDate(res.getString("creationDate"));
	     	f1.setfileSize(res.getInt("size"));
	     	f1.setfileLoc(res.getString("location"));
	     	myFiles.add((Object)f1);
	     }
	   } catch (SQLException e) {
	       System.out.println(e.getMessage());
	   }
		return myFiles;
	}
  
     
}
