package com.server.app.dao;
import java.sql.Connection;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.stereotype.Repository;

import com.server.app.model.User;
import com.server.app.model.UserLogin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface UserDaoable extends CrudRepository<User, Long> {

	public Connection connect();
	public User loadUserByUsername(final String username);
    public boolean userLogin(UserLogin login);
	public User addUser(UserLogin user);	
    public User returnUser(UserLogin user);

}
