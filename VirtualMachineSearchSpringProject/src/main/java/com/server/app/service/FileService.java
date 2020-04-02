package com.server.app.service;


import java.text.ParseException;
import java.util.ArrayList;
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
	public List<File> getFilesByFileName(List<String> IPs,String fileName) throws Exception {
		List<File> list=new ArrayList<File>();
		for(String ip: IPs)
		 list.addAll(fileDao.getFilesByFileName(ip,fileName));
		return list;
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
	public List<File> getFilesByFileNameMulti(String username, String fileName) throws Exception {
		return fileDao.getFilesByFileNameMulti(username,fileName);
	}

	@Override
	public List<File> getFilesBySizeInBytesMulti(String username, int size) throws ParseException {
		return fileDao.getFilesBySizeInBytesMulti(username,size);
	}

	@Override
	public List<File> retFilesByDateMaxMulti(String username, String m_Date) throws Exception {
		return fileDao.retFilesByDateMaxMulti(username,m_Date);
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
