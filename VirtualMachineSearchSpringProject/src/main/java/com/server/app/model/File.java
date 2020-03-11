package com.server.app.model;
 

import java.sql.Date;  

public class File {
	 	private String vmIP;
	    private String fileName;
	    private Date creationDate;
	    private long sizeInBytes;
	    private String location;

	    public File(String vmIP,String fileName,Date date, long sizeInBytes, String location){
	        this.vmIP=vmIP;
	        this.fileName=fileName;
	        this.sizeInBytes=sizeInBytes;
	        this.creationDate=date;
	        this.location=location;
	    }
	   
	    public File(){
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

		@Override
		public String toString() {
			return "File [vmIP=" + vmIP + ", fileName=" + fileName + ", creationDate=" + creationDate + ", sizeInBytes="
					+ sizeInBytes + ", location=" + location + "]";
		}
	    
}
