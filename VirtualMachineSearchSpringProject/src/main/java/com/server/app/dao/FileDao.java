package com.server.app.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
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
	public void addFile(String IP, File f) {
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
	public void deleteFileByVmIP(String vmIP) {
		
	}

	
	public void addFiles(String IP, List<File> filesList) {

		if(filesList.size() == 0) {
			System.out.println("No files to be added");
		}else {
		  for(File file : filesList) {
			  addFile(IP,file);
		  }
		}
	}
	
	public List<File> getAll(String IP) throws ParseException {
		List<File> myFiles= new ArrayList<File>();
		try (Connection conn = connect();
		PreparedStatement stat = conn.prepareStatement("SELECT * FROM file WHERE vmIP like ?")){
		stat.setString(1, IP);
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


	@Override
	public List<File> getFilesByFileName(String IP, String fileName) throws Exception {
		List<File> myFiles= new ArrayList<File>();
		try (Connection conn = connect();
		PreparedStatement stat = conn.prepareStatement("SELECT * FROM file WHERE vmIP like ? AND name LIKE ?")){
		stat.setString(1, IP);
		stat.setString(2, fileName+'%');
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
	public List<File> getFilesBySizeInBytes(String IP, int size) throws ParseException{
		List<File> myFiles= new ArrayList<File>();
		try (Connection conn = connect();
		PreparedStatement stat = conn.prepareStatement("SELECT * FROM file WHERE vmIP like ? AND size >= ?")){
		stat.setString(1, IP);
		stat.setInt(2, size);
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

	
	@Override
	public List<File> retFilesByDateMax(String IP, String m_Date) throws Exception{
		List<File> myFiles= new ArrayList<File>();
		try (Connection conn = connect();
		PreparedStatement stat = conn.prepareStatement("SELECT * FROM file WHERE vmIP like ? AND DATE(creationDate) <= ?")){
		stat.setString(1, IP);
		stat.setString(2, m_Date);
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
	
	public List<File> retFilesByDateBtw(String IP, String f_Date, String t_Date) throws Exception{
		List<File> myFiles= new ArrayList<File>();
		try (Connection conn = connect();
		PreparedStatement stat = conn.prepareStatement("SELECT * FROM file WHERE vmIP like ? AND DATE(creationDate) BETWEEN ? AND ?")){
		stat.setString(1, IP);
		stat.setString(2, f_Date);
		stat.setString(3, t_Date);
		ResultSet res = stat.executeQuery();
		 while (res.next()) {
			 File f1=new File();
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
		return null;
	}

	@Override
	public <S extends File> Iterable<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public Optional<File> findById(Long id) {
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		return false;
	}

	@Override
	public Iterable<File> findAll() {
		return null;
	}

	@Override
	public Iterable<File> findAllById(Iterable<Long> ids) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		
	}

	@Override
	public void delete(File entity) {
		
	}

	@Override
	public void deleteAll(Iterable<? extends File> entities) {
		
	}

	@Override
	public void deleteAll() {
		
	}


  
     
}
