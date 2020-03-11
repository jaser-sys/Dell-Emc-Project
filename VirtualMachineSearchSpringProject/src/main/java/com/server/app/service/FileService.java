package com.server.app.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.app.dao.FileDao;
import com.server.app.model.File;

@Service
public class FileService implements FileServiceable{
	@Autowired
	private FileDao fileDao;
	@Override
	public List<File> getFilesByFileName(String fileName) throws Exception {
		return fileDao.getFilesByFileName(fileName);
	}

	@Override
	public List<File> getFilesBySize(int size) throws Exception {
		return fileDao.getFilesBySizeInBytes(size);
	}

	public List<File> retFilesByDateMax(String m_Date) throws Exception{
		return fileDao.retFilesByDateMax(m_Date);
	}
	
	@Override
	public List<File> getFilesByDateBtw(String f_Date, String t_Date) throws Exception{
		return fileDao.retFilesByDateBtw(f_Date, t_Date);
	}
	
	@Override
	public List<File> getFiles() {
		try {
			return fileDao.getAll();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addFile(File f) {
		fileDao.addFile(f);		
	}

	@Override
	public void deleteFileByVmID(UUID vmID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFiles(List<File> list) {
		fileDao.addFiles(list);
		
	}

}
