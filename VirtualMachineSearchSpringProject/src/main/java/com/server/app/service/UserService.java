package com.server.app.service;

import com.server.app.model.User;
import com.server.app.dao.UserDaoable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService implements UserServiceable{
	
	@Autowired
	private UserDaoable userDao;
	
	
	@Override
	public boolean userLogin(String username, String password) {
		boolean res=userDao.userLogin(username, username);
		return res;
	}

	@Override
	public User addUser(User user) {
		User user_=userDao.addUser(user);
		return user_;
	}

	@Override
	public User returnUser(String username, String password) {
	
		User user_=userDao.returnUser(username,password);
		return user_;
	}


	
}
