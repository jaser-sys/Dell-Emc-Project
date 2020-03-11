package com.server.app.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.server.app.model.File;

public interface FileServiceable {
	public List<File> getFilesByFileName(String IP,String fileName) throws Exception;
	public List<File> getFilesBySize(String IP,int size) throws Exception;
	public List<File> retFilesByDateMax(String IP,String m_Date) throws Exception;
	public List<File> getFilesByDateBtw(String IP,String f_Date, String t_Date) throws Exception;
	public List<File> getFiles(String IP);
	public void addFile(String IP,File f);
	public void addFiles(String IP,List<File> list);
	public void deleteFileByVmID(UUID vmID);   
}
