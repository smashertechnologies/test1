package com.saloonsuite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.saloonsuite.dao.connection.ConnectionFactory;
import com.saloonsuite.util.validator.BaseValidator;

public class Authenticator {

	public static boolean isValid(String strUserName,String password) {

		boolean isValidUser = false;
		
		if(BaseValidator.isNullOrBlank(strUserName) || BaseValidator.isNullOrBlank(password))
			return false;
		String strQuery = "SELECT * FROM USER_LOGIN_INFO WHERE username=? and password =? and activated=1 and reset_password=0";
		PreparedStatement pStmt;
		try {
			pStmt = ConnectionFactory.getConnection().prepareStatement(strQuery);
			pStmt.setString(1,strUserName);
			pStmt.setString(2, password);
			ResultSet rSet = pStmt.executeQuery();
			if ( rSet.next())
				isValidUser = true;
			pStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error while contacting the validation server. Can not authenticate user.");
		}
		return isValidUser;
	}
}
