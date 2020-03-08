package com.server.app.model;
import java.util.UUID;

public class User {
	
	private UUID id_;
	private String username_;
	private String password_;

	public User(String username, String password) {
		
	   this.id_=UUID.randomUUID();
	   this.username_=username;
	   this.password_=password;
	
	}
	public User() {
		
	}
	public UUID getId_() {
		return id_;
	}

	public void setId_(UUID id_) {
		this.id_ = id_;
	}

	public String getUsername_() {
		return username_;
	}

	public void setUsername_(String username_) {
		this.username_ = username_;
	}

	public String getPassword_() {
		return password_;
	}

	public void setPassword_(String password_) {
		this.password_ = password_;
	}

		
}
