package com.server.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.app.dao.FileDao;
import com.server.app.model.File;
import com.server.app.service.FileService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FileController{
	@Autowired
	FileService fService=new FileService();
	
	@RequestMapping(method = RequestMethod.GET,value =  "/AllEntries")
	public List<File> getFiles(){
		return fService.getFiles();
	}
	
	@RequestMapping(method = RequestMethod.GET,value =  "/ByName")
	public List<File>  getFilesByName(String name){
		try {
			return fService.getFilesByFileName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET,value =  "/BySize")
	public List<File> getFilesBySize(int size){
		try {
			return fService.getFilesBySize(size);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET,value =  "/ByDate")
	public List<File> getFilesByDate(String m_Date){
		try {
			return fService.retFilesByDateMax(m_Date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET,value =  "/dateBtw")
	public List<File> getFilesByDateBtw(String f_Date, String t_Date){
		try {
			return fService.getFilesByDateBtw(f_Date,t_Date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
}