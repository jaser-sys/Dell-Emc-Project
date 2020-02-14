package com.server;

import com.jcraft.jsch.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
        

public class SshRemoteExecution {
	private String host = "ec2-18-191-224-120.us-east-2.compute.amazonaws.com";
	private String user = "root";
	private String password = "Jaser123!@";

	public SshRemoteExecution(String host,String user,String password) {
		this.host=host;
		this.user=user;
		this.password=password;
	}
	
	public SshRemoteExecution() {
		
	}
	
	public ArrayList<File> remoteExecution() {
		ArrayList<File> listOfFiles=new ArrayList<File>();
		String LocationOfFile=".";
        ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>();
        ArrayList<String> singleList = new ArrayList<String>();
        String myCommand = "hostname\n ls -lR --full-time --group-directories-first \n exit \n";

        try {
            
            JSch jsch = new JSch();
            Session session = jsch.getSession(user,host, 22);
            session.setUserInfo(new SshRemoteUserInformation(user, password));
            session.connect();
            Channel channel = session.openChannel("shell");
            channel.setInputStream(new ByteArrayInputStream(myCommand.getBytes(StandardCharsets.UTF_8)));
            channel.setOutputStream(System.out);
            InputStream in = channel.getInputStream();
            StringBuilder outBuff;
            outBuff = new StringBuilder();
            //int exitStatus = -1;
            
            channel.connect();
            
            while (true) {                
                for (int c; ((c = in.read()) >= 0);) {
                    outBuff.append((char) c);
                    if((char)c == ' '){
                        singleList.add((outBuff.toString()));
                        outBuff = new StringBuilder();
                    }if((char) c == '\n'){
                        String lastElem=outBuff.toString();
                       lastElem = lastElem.replace("\r\n","");
                        singleList.add((lastElem));
                        singleList.removeAll(Arrays.asList(" ", null));
                        listOLists.add(singleList);
                        outBuff = new StringBuilder();
                        singleList= new ArrayList<String>();
                    }
                }
            
                if (channel.isClosed()) {
                    if (in.available() > 0) continue;
                    //exitStatus = channel.getExitStatus();
                    break;
                }
                
            }//while (parser)
            
            
            channel.disconnect();
            session.disconnect();
            
            
            for(ArrayList<String> innerLs : listOLists) {
		        if (innerLs.size()==1) {
		        	String potentialPath=innerLs.get(0);
		        	if(potentialPath.length()>0&&potentialPath.charAt(potentialPath.length()-1)==':') {
		        		LocationOfFile=potentialPath.substring(0, potentialPath.length()-1)+"/";
		        	}
		        }else if(innerLs.size()==9) {
		        		try {
		        			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		        			Date date=format.parse(innerLs.get(5).trim());
		        			File f1=new File(this.host,innerLs.get(8),date,Integer.parseInt(innerLs.get(4).trim()),LocationOfFile);
		        			listOfFiles.add(f1);
		        		}catch(Exception e) {
		        			continue;
		        		}
		        }
	         }//for
        
        } catch (IOException | JSchException ioEx) {
            System.err.println(ioEx.toString());
        }//catch
		return listOfFiles;
	}
	
//	public static void main(String args []) {
//		SshRemoteExecution o= new SshRemoteExecution();
//		ArrayList<File> files=o.remoteExecution();
//		for(File f:files) {
//			System.out.println(f.getvmIP()+ " "+f.getfileName()+" "+f.getCreationDate()+" "+f.getfileSize()+" "+f.getfileLoc());
//		}
//	}
}//class
