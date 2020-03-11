package com.server.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.server.app.model.File;
import com.server.app.service.FileService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FileController{
	@Autowired
	FileService fService=new FileService();
	
	@RequestMapping(method = RequestMethod.GET,value =  "/AllEntries")
	public List<File> getFiles(String IP) throws Exception{
		return fService.getFiles(IP);
	}
	
	@RequestMapping(method = RequestMethod.GET,value =  "/ByName")
	public List<File>  getFilesByName(String IP, String name){
		try {
			return fService.getFilesByFileName(IP, name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET,value =  "/BySize")
	public List<File> getFilesBySize(String IP, int size){
		try {
			return fService.getFilesBySize(IP, size);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET,value =  "/ByDate")
	public List<File> getFilesByDate(String IP, String m_Date){
		try {
			return fService.retFilesByDateMax(IP, m_Date);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET,value =  "/dateBtw")
	public List<File> getFilesByDateBtw(String IP, String f_Date, String t_Date){
		try {
			return fService.getFilesByDateBtw(IP, f_Date,t_Date);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
}