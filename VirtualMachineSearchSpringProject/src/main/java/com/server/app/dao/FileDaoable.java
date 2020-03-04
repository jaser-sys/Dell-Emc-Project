package com.server.app.dao;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.server.app.model.File;


@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface FileDaoable extends CrudRepository<File, Long> {
    public Connection connect();
	public List<File> getFilesByFileName(String fileName);
	public List<File> getFilesBySizeInBytes(int size);
	public void addFile(UUID vmID,  String fileName, Date creationDate, long sizeInBytes, String location);
	public void deleteFileByVmID(UUID vmID);
	
}
