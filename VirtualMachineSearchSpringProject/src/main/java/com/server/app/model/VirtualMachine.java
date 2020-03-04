package com.server.app.model;

import java.util.UUID;

public class VirtualMachine {
	private UUID ID;
	private UUID userId;
	private String IP;
	private String username;
	private String password;

	public VirtualMachine() {
		
	}
	
	public VirtualMachine(UUID userId,String ip,String username, String password){
		this.ID = UUID.randomUUID();
		this.userId = userId;
		this.IP = ip;
		this.username = username;
		this.password = password;
	}
	
	public UUID getID() {
		return this.ID;
	}
	
	public void setID(UUID id) {
		this.ID = id;
	}

	public String getIP() {
		return this.IP;
	}

	public void setIP(String ip) {
		this.IP = ip;
	}

	public String getUserName() {
		return this.username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "VirtualMachine [ID=" + ID + ", userId=" + userId + ", IP=" + IP + ", userName=" + username
				+ ", password=" + password + "]";
	}
	
}

