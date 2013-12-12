package com.saloonsuite.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.saloonsuite.data.entity.DataObject;


public interface BaseDAO {

	public boolean save();
	public boolean saveOrUpdate();
	public boolean delete();
	public boolean create();
	public boolean exists();
	public List<? extends DataObject> getAll();
	public DataObject get();
	public void close(java.sql.Statement stmt);
	public void close(ResultSet resultSet);
	public void close(PreparedStatement pStmt);
	public void close(Connection con);
}
