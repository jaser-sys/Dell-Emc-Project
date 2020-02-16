package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dao.FileQuery;


@RestController
@RequestMapping(value ="/Files")
public class FileController{
	
	FileQuery dbinstance=new FileQuery();
	
	@RequestMapping(method = RequestMethod.GET,value =  "/AllEntries")
	public List<Object> getAllFiles(){
		return dbinstance.getAllEntries();
	}
	
	@RequestMapping(method = RequestMethod.GET,value =  "/filterByName")
	public List<Object>  getEntriesNameFilter(String name){
		return dbinstance.getEntriesNameFilter(name);
	}
	
	@RequestMapping(method = RequestMethod.GET,value =  "/filterBySize")
	public List<Object>  getEntriesSizeFilter(int size){
		return dbinstance.getEntriesSizeFilter(size);
	}
	
}