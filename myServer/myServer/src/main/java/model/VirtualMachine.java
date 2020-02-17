package model;

import java.util.UUID;

public class VirtualMachine {
	private UUID ID;
	private String IP;
	private String userName;
	private String password;
	

	public VirtualMachine() {
		
	}
	
	public VirtualMachine(String ip,String username, String password)
	{
		this.ID = UUID.randomUUID();
		this.IP = ip;
		this.userName = username;
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
		return this.userName;
	}


	public void setUserName(String username) {
		this.userName = username;
	}


	public String getPassword() {
		return this.password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
}

