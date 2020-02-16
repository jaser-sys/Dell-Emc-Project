package com.server;


public class VirtualMachine {
	private int vmID;
	private String vmHostName;
	private String vmUserName;
	private String vmPassword;
	
	

	public VirtualMachine() {
		
	}
	
	public VirtualMachine(int vmID,String vmHostName,String vmUserName, String vmPassword)
	{
		this.vmID=vmID;
		this.vmHostName=vmHostName;
		this.vmUserName=vmUserName;
		this.vmPassword=vmPassword;
	}
	
	public int getVmID() {
		return vmID;
	}


	public void setVmID(int vmID) {
		this.vmID = vmID;
	}


	public String getVmHostName() {
		return vmHostName;
	}


	public void setVmHostName(String vmHostName) {
		this.vmHostName = vmHostName;
	}


	public String getVmUserName() {
		return vmUserName;
	}


	public void setVmUserName(String vmUserName) {
		this.vmUserName = vmUserName;
	}


	public String getVmPassword() {
		return vmPassword;
	}


	public void setVmPassword(String vmPassword) {
		this.vmPassword = vmPassword;
	}

}

