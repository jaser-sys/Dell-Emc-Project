package com.server.app.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.server.app.model.File;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public class FileDao implements FileDaoable{
	@Autowired
    DataSource dataSource;
	
	@Override
	public Connection connect() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}



	@Override
	public void addFile(File f) {
		String sqlCommand = "INSERT INTO file (vmIP, name, creationDate, size , location) "
 		+ "VALUES(\'"+ f.getVmIP() +"\',\'" + f.getFileName() + "\',\'" + f.getCreationDate() + "\',\'" + f.getSizeInBytes() +"\',\'" + f.getLocation() + "\');" ;
		 try (Connection conn = this.connect();
			PreparedStatement stmt  = conn.prepareStatement(sqlCommand) ){				 
			stmt.executeUpdate();
	    }catch (SQLException e) {
		        System.out.println(e.getMessage());
	    }
	}

	@Override
	public void deleteFileByVmID(UUID vmID) {
		// TODO Auto-generated method stub
		
	}

	
	public void addFiles(List<File> filesList) {
		if(filesList.size() == 0) {
			System.out.println("No files to be added");
		}else {
		  for(File file : filesList) {
			  addFile(file);
		  }
		}
	}
	
	public List<File> getAll() throws ParseException {
		String sqlCommand = "SELECT * FROM file;" ;
		List<File> myFiles= new ArrayList<File>();
		
		try (Connection conn = this.connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet result    = stmt.executeQuery(sqlCommand)){
	            while (result.next()) {
	            	File f1=new File();
	            	Date date = Date.valueOf(result.getString("creationDate"));
	            	f1.setVmIP(result.getString("vmIP"));
	            	f1.setFileName(result.getString("name"));
	            	f1.setCreationDate(date);
	            	f1.setSizeInBytes(result.getInt("size"));
	            	f1.setLocation(result.getString("location"));
	            	myFiles.add(f1);
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return myFiles;
	}


	@Override
	public List<File> getFilesByFileName(String fileName) throws Exception {
		List<File> myFiles= new ArrayList<File>();
		try (Connection conn = connect();
		PreparedStatement stat = conn.prepareStatement("SELECT * FROM file WHERE name LIKE ?")){
		stat.setString(1, fileName+'%');
		ResultSet res = stat.executeQuery();
		 while (res.next()) {
	     	File f1=new File();
        	Date date =Date.valueOf(res.getString("creationDate"));
	     	f1.setVmIP(res.getString("vmIP"));
	     	f1.setFileName(res.getString("name"));
	     	f1.setCreationDate(date);
	     	f1.setSizeInBytes(res.getLong("size"));
	     	f1.setLocation(res.getString("location"));
	     	myFiles.add(f1);
	     }
	   } catch (SQLException e) {
	       System.out.println(e.getMessage());
	   }
		return myFiles;
	}

	
	@Override
	public List<File> getFilesBySizeInBytes(int size) throws ParseException{
		List<File> myFiles= new ArrayList<File>();
		try (Connection conn = connect();
		PreparedStatement stat = conn.prepareStatement("SELECT * FROM file WHERE size >= ?")){
		stat.setInt(1, size);
		ResultSet res = stat.executeQuery();
		 while (res.next()) {
			 File f1=new File();
         	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         	Date date = Date.valueOf(res.getString("creationDate"));
         	f1.setVmIP(res.getString("vmIP"));
         	f1.setFileName(res.getString("name"));
         	f1.setCreationDate(date);
         	f1.setSizeInBytes(res.getInt("size"));
         	f1.setLocation(res.getString("location"));
         	myFiles.add(f1);
	     }
	   } catch (SQLException e) {
	       System.out.println(e.getMessage());
	   }
		return myFiles;
	}

	
	@Override
	public List<File> retFilesByDateMax(String m_Date) throws Exception{
		List<File> myFiles= new ArrayList<File>();
		try (Connection conn = connect();
		PreparedStatement stat = conn.prepareStatement("SELECT * FROM file WHERE DATE(creationDate) <= ?")){
		stat.setString(1, m_Date);
		ResultSet res = stat.executeQuery();
		 while (res.next()) {
			 File f1=new File();
         	Date date = Date.valueOf(res.getString("creationDate"));
         	f1.setVmIP(res.getString("vmIP"));
         	f1.setFileName(res.getString("name"));
         	f1.setCreationDate(date);
         	f1.setSizeInBytes(res.getInt("size"));
         	f1.setLocation(res.getString("location"));
         	myFiles.add(f1);
	     }
	   } catch (SQLException e) {
	       System.out.println(e.getMessage());
	   }
		return myFiles;
		
	}
	
	public List<File> retFilesByDateBtw(String f_Date, String t_Date) throws Exception{
		List<File> myFiles= new ArrayList<File>();
		try (Connection conn = connect();
		PreparedStatement stat = conn.prepareStatement("SELECT * FROM file WHERE DATE(creationDate) BETWEEN ? AND ?")){
		stat.setString(1, f_Date);
		stat.setString(2, t_Date);
		ResultSet res = stat.executeQuery();
		 while (res.next()) {
			 File f1=new File();
         	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         	Date date =Date.valueOf(res.getString("creationDate"));
         	f1.setVmIP(res.getString("vmIP"));
         	f1.setFileName(res.getString("name"));
         	f1.setCreationDate(date);
         	f1.setSizeInBytes(res.getInt("size"));
         	f1.setLocation(res.getString("location"));
         	myFiles.add(f1);
	     }
	   } catch (SQLException e) {
	       System.out.println(e.getMessage());
	   }
		return myFiles;
	}
	
	
	@Override
	public <S extends File> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends File> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<File> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<File> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<File> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(File entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends File> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


  
     
}
