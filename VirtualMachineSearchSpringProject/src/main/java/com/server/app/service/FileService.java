package com.server.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.app.dao.FileDao;
import com.server.app.model.File;

@Service
public class FileService implements FileServiceable{
	@Autowired
	private FileDao fileDao;
	@Override
	public List<File> getFilesByFileName(String IP,String fileName) throws Exception {
		return fileDao.getFilesByFileName(IP,fileName);
	}

	@Override
	public List<File> getFilesBySize(String IP,int size) throws Exception {
		return fileDao.getFilesBySizeInBytes(IP,size);
	}

	public List<File> retFilesByDateMax(String IP,String m_Date) throws Exception{
		return fileDao.retFilesByDateMax(IP,m_Date);
	}
	
	@Override
	public List<File> getFilesByDateBtw(String IP,String f_Date, String t_Date) throws Exception{
		return fileDao.retFilesByDateBtw(IP,f_Date, t_Date);
	}
	
	@Override
	public List<File> getFiles(String IP) throws Exception {
		System.out.println("************"+IP);
			return fileDao.getAll(IP);

	}

	@Override
	public void addFile(String IP,File f) {
		fileDao.addFile(IP,f);		
	}

	@Override
	public void deleteFileByVmIP(String vmIP) {
		
		
	}

	@Override
	public void addFiles(String IP,List<File> list) {
		fileDao.addFiles(IP,list);

	}

}
