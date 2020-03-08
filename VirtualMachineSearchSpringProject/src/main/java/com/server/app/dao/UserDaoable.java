package com.server.app.dao;
import java.sql.Connection;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.stereotype.Repository;

import com.server.app.model.User;


@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface UserDaoable extends CrudRepository<User, Long> {

	public Connection connect();
    public boolean userLogin(String username, String password);
	public User addUser(User user);	
    public User returnUser(String username, String password);

}
