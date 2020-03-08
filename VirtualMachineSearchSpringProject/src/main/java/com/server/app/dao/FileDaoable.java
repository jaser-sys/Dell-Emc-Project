package com.server.app.dao;

import java.sql.Connection;
import java.text.ParseException;
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
	public List<File> getFilesByFileName(String fileName) throws Exception;
	public List<File> getFilesBySizeInBytes(int size) throws ParseException;
	public List<File> retFilesByDateMax(String m_Date) throws Exception;
	public List<File> getFilesByDateBtw(String f_Date, String t_Date) throws Exception;
	public void addFile(File f);
	public void deleteFileByVmID(UUID vmID);
	
}
