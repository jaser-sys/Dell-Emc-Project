package com.server;

import java.util.Date;

public class File {
	 	private int vmID;
	    private String fileName;
	    private Date creationDate;
	    private int fileSize;

	    public File(int vmID,String fileName,Date date, int fileSize){
	        this.vmID=vmID;
	        this.fileName=fileName;
	        this.fileSize=fileSize;
	        this.creationDate=date;
	    }
	    
	    public File(){
	    }
	    
	    public void setvmID(int vmID){
	        this.vmID=vmID;
	    }
	    
	    public void setfileName(String fileName){
	        this.fileName=fileName;
	    }
	    
	    public void setfileSize(int fileSize){
	        this.fileSize=fileSize;
	    }
	    
	    public void setdate(Date date){
	        this.creationDate=date;
	    }
	    
	    public int getvmID(){
	        return vmID ;
	    }
	    
	    public String getfileName(){
	        return fileName;
	    }
	    
	    public int getfileSize(){
	        return fileSize;
	    }
	    
	    public Date getCreationDate(){
	        return creationDate;
	    }

}
