package com.server.app.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.server.app.model.File;

public interface FileServiceable {
	public List<File> getFilesByFileName(String fileName) throws Exception;
	public List<File> getFilesBySize(int size) throws Exception;
	public List<File> getFiles();
	public void addFile(File f);
	public void addFiles(List<File> list);
	public void deleteFileByVmID(UUID vmID);   
}
