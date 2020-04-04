package com.server.app.beans;

import java.io.Serializable;


public class VirtualMachineDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String IP;
	private String userName;
	private String password;
	private String path;
	public VirtualMachineDTO() {
		super();
	}
	public VirtualMachineDTO( String iP, String userName, String password, String path) {
		
		IP = iP;
		this.userName = userName;
		this.password = password;
		this.path=path;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
