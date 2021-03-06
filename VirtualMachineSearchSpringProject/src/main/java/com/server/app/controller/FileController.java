package com.server.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;

import com.server.app.config.authentication.CustomAuthenticationProvider;
import com.server.app.model.ApiResponse;
import com.server.app.model.File;
import com.server.app.service.FileService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/file")
public class FileController{
	
	@Autowired
	FileService fService=new FileService();
	
	@GetMapping(value =  "/listfiles/{IP}")
	public ApiResponse<List<File>> getFiles(@PathVariable String IP) throws Exception{
		 List<File> files=fService.getFiles(IP);
		return new ApiResponse<>(HttpStatus.OK.value(), "file list fetched successfully.",files);
	}
	
	@GetMapping(value =  "/filesByName/{IP}")
	public ApiResponse<List<File>> getFilesByName(@PathVariable(value = "IP") String IP,@RequestParam (value = "name") String name){
		try {
			
			 List<File> files= fService.getFilesByFileName(IP, name);
			 return new ApiResponse<>(HttpStatus.OK.value(), "file list fetched successfully.",files);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping(value =  "/filesBySize/{IP}")
	public ApiResponse<List<File>> getFilesBySize(@PathVariable(value = "IP") String IP,@RequestParam(value = "size") int size){
		
		try {
			
			List<File> files = fService.getFilesBySize(IP, size);
			return new ApiResponse<>(HttpStatus.OK.value(), "file list fetched successfully.",files);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	@GetMapping(value =  "/filesByDate/{IP}")
	public ApiResponse<List<File>> getFilesByDate(@PathVariable(value = "IP") String IP,@RequestParam(value = "date") String m_Date){
		try {
			
			List<File> files = fService.retFilesByDateMax(IP, m_Date);
			return new ApiResponse<>(HttpStatus.OK.value(), "file list fetched successfully.",files);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	@GetMapping(value =  "/filesDateBtw/{IP}")
	public ApiResponse<List<File>> getFilesByDateBtw(@PathVariable String IP,@RequestParam(value = "f_Date") String f_Date,@RequestParam(value = "t_Date") String t_Date){
		try {
			
			List<File> files = fService.getFilesByDateBtw(IP, f_Date,t_Date);
			return new ApiResponse<>(HttpStatus.OK.value(), "file list fetched successfully.",files);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	@GetMapping(value =  "/listfilesNameMulti/{username}")
	public ApiResponse<List<File>> getAllFilesByNameMulti(@PathVariable(value = "username") String username,@RequestParam(value = "name") String name){
		try {
			
			 List<File> files= fService.getFilesByFileNameMulti(username, name);
		     return new ApiResponse<>(HttpStatus.OK.value(), "file list fetched successfully.",files);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping(value =  "/listfilesBySizeMulti/{username}")
	public ApiResponse<List<File>> getFilesBySizeMulti(@PathVariable(value = "username") String username,@RequestParam(value = "size")  int size){
	    try {
		
			 List<File> files = fService.getFilesBySizeMulti(username, size);
			 return new ApiResponse<>(HttpStatus.OK.value(), "file list fetched successfully.",files);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	
	@GetMapping(value =  "/listfilesByDateMulti/{username}")
	public ApiResponse<List<File>> getFilesByDateMulti(@PathVariable(value = "username") String username,@RequestParam(value = "date") String m_Date){
		try {
			
			List<File> files = fService.retFilesByDateMaxMulti(username, m_Date);
			return new ApiResponse<>(HttpStatus.OK.value(), "file list fetched successfully.",files);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
}