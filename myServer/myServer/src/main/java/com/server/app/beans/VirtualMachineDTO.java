package com.server.app.beans;

import java.io.Serializable;
import java.util.UUID;

public class VirtualMachineDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private UUID ID;
	private UUID userId;
	private String IP;
	private String userName;
	private String password;
	public VirtualMachineDTO() {
		super();
	}
	public VirtualMachineDTO(UUID iD, UUID userId, String iP, String userName, String password) {
		super();
		ID = iD;
		this.userId = userId;
		IP = iP;
		this.userName = userName;
		this.password = password;
	}
	public UUID getID() {
		return ID;
	}
	public void setID(UUID iD) {
		ID = iD;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
