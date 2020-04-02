package com.server.app.dao;

import java.sql.Connection;
import java.text.ParseException;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.server.app.model.File;


@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface FileDaoable extends CrudRepository<File, Long> {
    public Connection connect();
	public List<File> getFilesByFileName(String IP, String fileName) throws Exception;
	public List<File> getFilesBySizeInBytes(String IP, int size) throws ParseException;
	public List<File> retFilesByDateMax(String IP, String m_Date) throws Exception;
	public List<File> retFilesByDateBtw(String IP, String f_Date, String t_Date) throws Exception;
	public List<File> getFilesByFileNameMulti(String username, String fileName) throws Exception;
	public List<File> getFilesBySizeInBytesMulti(String username, int size) throws ParseException;
	public List<File> retFilesByDateMaxMulti(String username, String m_Date) throws Exception;
	public void addFile(String IP, File f);
	public void deleteFileByVmIP(String vmIP);
	
}
