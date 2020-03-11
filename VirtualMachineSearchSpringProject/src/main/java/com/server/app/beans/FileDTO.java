package com.server.app.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class FileDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String vmIP;
    private String fileName;
    private Date creationDate;
    private long sizeInBytes;
    private String location;
    
	public FileDTO() {
		super();
	}
	
	public FileDTO(String vmIP, String fileName, Date creationDate, long sizeInBytes, String location) {
		super();
		this.vmIP = vmIP;
		this.fileName = fileName;
		this.creationDate = creationDate;
		this.sizeInBytes = sizeInBytes;
		this.location = location;
	}

	public String getVmIP() {
		return vmIP;
	}

	public void setVmIP(String vmIP) {
		this.vmIP = vmIP;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public long getSizeInBytes() {
		return sizeInBytes;
	}

	public void setSizeInBytes(long sizeInBytes) {
		this.sizeInBytes = sizeInBytes;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
    
}
