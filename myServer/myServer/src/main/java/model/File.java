package model;


import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
public class File {
	 	private String vmIP;
	    private String fileName;
	    private Date creationDate;
	    private int fileSize;
	    private String fileLoc;

	    public File(String vmIP,String fileName,Date date, int fileSize, String fileLoc){
	        this.vmIP=vmIP;
	        this.fileName=fileName;
	        this.fileSize=fileSize;
	        this.creationDate=date;
	        this.fileLoc=fileLoc;
	    }
	    
	    public File(){
	    }
	    
	    public void setvmIP(String vmIP){
	        this.vmIP=vmIP;
	    }
	    
	    public void setfileName(String fileName){
	        this.fileName=fileName;
	    }
	    
	    public void setfileSize(int fileSize){
	        this.fileSize=fileSize;
	    }
	    
	    public void setcreationDate(String date){
	    	Date d1=new Date();
	    	try {
				d1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			} 
	    	
	        this.creationDate=d1;
	    }
	    
	    public void setfileLoc(String fileLoc) {
	          this.fileLoc=fileLoc;	
	    
	    }
	    public String getvmIP(){
	        return vmIP;
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
	    public String getfileLoc() {
	          return fileLoc;
	    
	    }

}