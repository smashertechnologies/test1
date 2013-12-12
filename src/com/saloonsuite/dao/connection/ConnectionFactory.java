package com.saloonsuite.dao.connection;

import static com.saloonsuite.base.AppProperties.getValue;
import static com.saloonsuite.util.ApplicationConstants.DB_HOST;
import static com.saloonsuite.util.ApplicationConstants.DB_NAME;
import static com.saloonsuite.util.ApplicationConstants.DB_PASS;
import static com.saloonsuite.util.ApplicationConstants.DB_USERNAME;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionFactory {

	private static Connection con = null;
	private ConnectionFactory() {
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://"+ getValue(DB_HOST) +"/"+ getValue(DB_NAME) +"?"
			              + "user="+getValue(DB_USERNAME)+"&password="+getValue(DB_PASS));

				
			}catch (Exception ex) {
				con = null;
				ex.printStackTrace();
			}
	}
	
	public static Connection getConnection() {

		if ( con == null )
			new ConnectionFactory();
		return con;
		
	}
}
