package com.server.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.sql.DataSource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.stereotype.Repository;

import com.server.app.model.User;
import com.server.app.model.UserLogin;



@Repository
@CrossOrigin(origins = "http://localhost:4200")
public class UserDao implements UserDaoable{
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
    public boolean userLogin(UserLogin login) {
		boolean isAUser=false;
		try (Connection conn = connect();
				PreparedStatement stat = conn.prepareStatement("SELECT * FROM user WHERE username_ LIKE ? and password_ LIKE ? ")){
				stat.setString(1, login.getUsername()+'%');
				stat.setString(2, login.getPassword() + '%');
				ResultSet res = stat.executeQuery();
				if(res !=null) {
					isAUser=true;
				}
		       } catch (SQLException e) {
		       System.out.println(e.getMessage());
		     }
			
    	return isAUser;
    }
	
	@Override
	public User addUser(UserLogin user) {
		User user_=new User(user.getUsername(), user.getPassword());
		String sqlCommand = "INSERT INTO user (id, username_, password_)"
		 		+ "VALUES(\'"+ user_.getId_()+"\',\'"+ user_.getUsername_()+"\',\'" +  user_.getPassword_() + "\');" ;
		 try (Connection conn = this.connect();
				PreparedStatement stmt  = conn.prepareStatement(sqlCommand) ){				 
			 	stmt.executeUpdate();
	        }
		 catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	return user_;
	}
	
	@Override
    public User returnUser(UserLogin user) {
		User user_=new User();
		try (Connection conn = connect();
				PreparedStatement stat = conn.prepareStatement("SELECT * FROM user WHERE username_ LIKE ? and password_ LIKE ? ")){
				stat.setString(1, user.getUsername()+'%');
				stat.setString(2, user.getPassword() + '%');
				ResultSet res = stat.executeQuery();
				while(res.next()) {
					
					user_.setId_(UUID.fromString(res.getString("id")));
					user_.setUsername_(res.getString("username_"));
					user_.setPassword_(res.getString("password_"));
					
				}
		       } catch (SQLException e) {
		       System.out.println(e.getMessage());
		     }
		return user_;
    	
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
	@Override
	public <S extends User> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> findAllById(Iterable<Long> ids) {
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
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
