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
	public List<File> getFilesByFileName(String fileName) {
		return fileDao.getFilesByFileName(fileName);
	}

	@Override
	public List<File> getFilesBySize(int size) {
		return fileDao.getFilesBySizeInBytes(size);
	}

	@Override
	public List<File> getFiles() {
		try {
			return fileDao.getAll();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addFile(UUID vmID, String fileName, Date creationDate, long sizeInBytes, String location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFileByVmID(UUID vmID) {
		// TODO Auto-generated method stub
		
	}

}
