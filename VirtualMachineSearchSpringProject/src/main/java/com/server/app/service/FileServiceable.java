package com.server.app.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.server.app.model.File;

public interface FileServiceable {
	public List<File> getFilesByFileName(String fileName);
	public List<File> getFilesBySize(int size);
	public List<File> getFiles();
	public void addFile(UUID vmID,  String fileName, Date creationDate, long sizeInBytes, String location);
	public void deleteFileByVmID(UUID vmID);   
}
