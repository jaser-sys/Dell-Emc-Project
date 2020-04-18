package com.server.app.model;

import java.util.UUID;

public class VirtualMachine {
	private UUID ID;
	private UUID userId;
	private String IP;
	private String username;
	private String password;
	private String path;

	public VirtualMachine() {
		
	}
	
	public VirtualMachine(UUID userId,String ip,String username, String password, String path){
		this.ID = UUID.randomUUID();
		this.userId = userId;
		this.IP = ip;
		this.username = username;
		this.password = password;
		this.path = path;
	}
	public VirtualMachine(UUID vmId, UUID userId,String ip,String username, String password, String path){
		this.ID = vmId;
		this.userId = userId;
		this.IP = ip;
		this.username = username;
		this.password = password;
		this.path = path;
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
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "VirtualMachine [ID=" + ID + ", userId=" + userId + ", IP=" + IP + ", username=" + username
				+ ", password=" + password + ", path=" + path + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof VirtualMachine) 
			if(((VirtualMachine) obj).getID().equals(this.getID()))
				if(((VirtualMachine) obj).getUserId().equals(this.getUserId()))
					if(((VirtualMachine) obj).getIP().equals(this.getIP()))
						if(((VirtualMachine) obj).getUserName().equals(this.getUserName()))
							if(((VirtualMachine) obj).getPassword().equals(this.getPassword()))
								if(((VirtualMachine) obj).getPath().equals(this.getPath()))
									return true;
		return false;
	}


}

