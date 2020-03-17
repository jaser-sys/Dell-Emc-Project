package com.server.app.service;

import com.server.app.model.User;
import com.server.app.model.UserLogin;
public interface UserServiceable {
	    public User loadUserByUsername(final String username);
	    public boolean userLogin(UserLogin login);
		public User addUser(UserLogin user);	
	    public User returnUser(UserLogin user);
}
