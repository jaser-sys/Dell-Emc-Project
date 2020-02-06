package com.server;

import java.sql.Connection;
import java.util.List;

public interface SqliteDBInterface {
	Connection connect();
	public void addNewEntry(Object o);
	public List<Object> getAllEntries();
}
