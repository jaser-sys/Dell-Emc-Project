package com.server.app.service;

import com.jcraft.jsch.*;
import com.server.app.model.File;
import com.server.app.model.VirtualMachine;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;




public class RemoteVirtualMachine {
	//fields
	private String ip = "ec2-18-191-224-120.us-east-2.compute.amazonaws.com";
	private String user = "root";
	private String password = "Jaser123!@";
	private Channel channel;
    private JSch jsch;
    private Session session;

	//cons
	public RemoteVirtualMachine(String ip,String user,String password) {
		this.ip=ip;
		this.user=user;
		this.password=password;
	}
	
	public RemoteVirtualMachine() {
	}
	
	public RemoteVirtualMachine(VirtualMachine vm) {
		this.ip=vm.getIP();
		this.user=vm.getUserName();
		this.password=vm.getPassword();
	}
	
	public ArrayList<File> getFiles(){
		InputStream inputStream = initializeConnection();
		ArrayList<ArrayList<String>> processedStream = readResposeStream(inputStream);
		 ArrayList<File>  filesList=parseLists(processedStream);
		return filesList;
	}

	
	private InputStream initializeConnection() {
		String myCommand = "hostname\n ls -lR --full-time --group-directories-first \n exit \n";
		InputStream inputStream=null;
		try {
			jsch=new JSch();
			session = jsch.getSession(user,ip, 22);
			session.setUserInfo(new RemoteVirtualMachineInformation(user, password));
	        session.connect();
	       	channel = session.openChannel("shell");
	       	channel.setInputStream(new ByteArrayInputStream(myCommand.getBytes(StandardCharsets.UTF_8)));
	        channel.setOutputStream(System.out);
	        inputStream = channel.getInputStream();
	        channel.connect();	       	
		} catch (IOException |JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputStream;
	}
	
	
	private ArrayList<ArrayList<String>> readResposeStream(InputStream inputStream) {
        StringBuilder outBuff;
        outBuff = new StringBuilder();
        ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>();
        ArrayList<String> singleList = new ArrayList<String>();
        try {
            while (true) {                
                for (int c; ((c = inputStream.read()) >= 0);) {
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
                    if (inputStream.available() > 0) 
                    	continue;
                    //exitStatus = channel.getExitStatus();
                    break;
                }
                
            }//while (parser)
        }catch (IOException e) {
			e.printStackTrace();
		}
        return listOLists;
        
	}
	
	
	private  ArrayList<File> parseLists(ArrayList<ArrayList<String>> listOfLists){
		String LocationOfFile=".";
		ArrayList<File> listOfFiles=new ArrayList<File>();
        for(ArrayList<String> innerLs : listOfLists) {
	        if (innerLs.size()==1) {
	        	String potentialPath=innerLs.get(0);
	        	if(potentialPath.length()>0&&potentialPath.charAt(potentialPath.length()-1)==':') {
	        		LocationOfFile=potentialPath.substring(0, potentialPath.length()-1)+"/";
	        	}
	        }else if(innerLs.size()==9) {
	        		try {
	        			Date date=Date.valueOf(innerLs.get(5).trim());
	        			File f1=new File(this.ip,innerLs.get(8),date,Integer.parseInt(innerLs.get(4).trim()),LocationOfFile);
	        			listOfFiles.add(f1);
	        			System.out.println(f1.toString());
	        		}catch(Exception e) {
	        			continue;
	        		}
	        }
         }//for
		return listOfFiles;//return the list of all files that have been parsed
	}
	
	
	
	
}