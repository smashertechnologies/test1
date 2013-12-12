package com.saloonsuite.util;

public abstract class UserInfoConstants extends ApplicationConstants {

	public static final String TABLE_NAME = "USER_INFO";
	public static final String USER_ID_COL = "user_id";
	public static final String FIRSTNAME_COL = "firstname";
	public static final String LASTNAME_COL = "lastname";
	public static final String EMAIL_COL = "email";
	public static final String MOBILENO = "mobileno";
	public static final String SELECT_ALL_USERINFO= "SELECT "+ USER_ID_COL + "," + FIRSTNAME_COL + ","+LASTNAME_COL +","
										   + EMAIL_COL + "," + MOBILENO	
										   +" FROM " + TABLE_NAME;
	
	public static final String CREATE_NEW_USERINFO_QUERY = "INSERT INTO " + TABLE_NAME + 
											"(" + FIRSTNAME_COL +","+LASTNAME_COL +","+EMAIL_COL+","+MOBILENO+") " +
											" VALUES "+
											"(?,?,?,?)";
	
	public static final String SELECT_USERINFO_BYEMAIL= "SELECT "+ USER_ID_COL + "," + FIRSTNAME_COL + ","+LASTNAME_COL +","
	   + EMAIL_COL + "," + MOBILENO	
	   +" FROM " + TABLE_NAME + " WHERE " + EMAIL_COL + "=?";
	
}
