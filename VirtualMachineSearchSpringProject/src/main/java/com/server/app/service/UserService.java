package com.server.app.service;

import com.server.app.model.User;
import com.server.app.model.UserLogin;
import com.server.app.dao.UserDaoable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService implements UserServiceable{
	
	@Autowired
	private UserDaoable userDao;
	
	
	@Override
	public User loadUserByUsername(final String username){
		User user=userDao.loadUserByUsername(username);
		return user;
	}
	
	@Override
	public boolean userLogin(UserLogin login) {
		boolean res=userDao.userLogin(login);
		return res;
	}

	@Override
	public boolean addUser(UserLogin user) {
		boolean userAdded=userDao.addUser(user);
		return userAdded;
	}

	@Override
	public User userExist(UserLogin user) {
	
		User user_=userDao.userExist(user);
		return user_;
	}


	
}
