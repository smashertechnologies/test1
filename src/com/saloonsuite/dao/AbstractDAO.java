package com.saloonsuite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class AbstractDAO {

	Logger log = Logger.getLogger(AbstractDAO.class);
	public void close(Statement stmt) {
		
		if ( stmt != null ){
			try {
				stmt.close();
			} catch (SQLException e) {
				log.error("Error while closing the Statement : " + stmt);
				e.printStackTrace();
			}
		}
	}

	public void close(ResultSet resultSet) {
		if ( resultSet != null ){
			try {
				resultSet.close();
			} catch (SQLException e) {
				log.error("Error while closing the ResultSet : " + resultSet);
				e.printStackTrace();
			}
		}
	}

	public void close(PreparedStatement pStmt) {
		if ( pStmt != null ){
			try {
				pStmt.close();
			} catch (SQLException e) {
				log.error("Error while closing the PreparedStatement : " + pStmt);
				e.printStackTrace();
			}
		}
	}

	public void close(Connection con) {
		if ( con != null ){
			try {
				con.close();
			} catch (SQLException e) {
				log.error("Error while closing the Connection : " + con );
				e.printStackTrace();
			}
		}
		
	}
}
