package com.saloonsuite.util;

public class UserLoginConstants extends ApplicationConstants {
	
	public static final String TABLE_NAME = "USER_LOGIN_INFO";
	public static final String USER_ID_COL = "user_id";
	public static final String USERNAME_COL = "username";
	public static final String PASSWORD_COL = "password";
	public static final String ACTIVATED_COL = "activated";
	public static final String RESET_PASSWORD_COL = "reset_password";
	public static final String SELECT_ALL_USERINFO= "SELECT "+ USER_ID_COL + "," + USERNAME_COL + ","+ACTIVATED_COL +","
										   + RESET_PASSWORD_COL	
										   +" FROM " + TABLE_NAME;
	
	public static final String SELECT_USERLOGIN_BYUSERID= "SELECT "+ USER_ID_COL + "," + USERNAME_COL + ","+ACTIVATED_COL +","
	   + RESET_PASSWORD_COL	
	   +" FROM " + TABLE_NAME + " WHERE " + USER_ID_COL + "=?";
	public static final String SELECT_USERLOGIN_BYUSERNAME= "SELECT "+ USER_ID_COL + "," + USERNAME_COL + ","+ACTIVATED_COL +","
	   + RESET_PASSWORD_COL	
	   +" FROM " + TABLE_NAME + " WHERE " + USERNAME_COL + "=?";
	
	public static final String CREATE_USERLOGIN_QUERY = "INSERT INTO " + TABLE_NAME + 
	"(" + USER_ID_COL +","+USERNAME_COL +","+PASSWORD_COL+","+ACTIVATED_COL+"," + RESET_PASSWORD_COL+") " +
	" VALUES "+
	"(?,?,?,?,?)";
}
