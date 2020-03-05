package com.server.app.model;
 
import java.util.Date;
import java.util.UUID;  

public class File {
	 	private UUID vmID;
	    private String fileName;
	    private Date creationDate;
	    private long sizeInBytes;
	    private String location;

	    public File(UUID vmID,String fileName,Date date, long sizeInBytes, String location){
	        this.vmID=vmID;
	        this.fileName=fileName;
	        this.sizeInBytes=sizeInBytes;
	        this.creationDate=date;
	        this.location=location;
	    }
	   
	    public File(){
	    }

		public UUID getVmID() {
			return vmID;
		}

		public void setVmID(UUID vmID) {
			this.vmID = vmID;
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
			return "File [vmID=" + vmID + ", fileName=" + fileName + ", creationDate=" + creationDate + ", sizeInBytes="
					+ sizeInBytes + ", location=" + location + "]";
		}
	    
}
