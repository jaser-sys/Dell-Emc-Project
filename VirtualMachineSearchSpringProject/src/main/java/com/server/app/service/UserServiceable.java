package com.server.app.service;

import com.server.app.model.User;

public interface UserServiceable {
	   public boolean userLogin(String username, String password);
		public User addUser(User user);	
	    public User returnUser(String username, String password);
}
