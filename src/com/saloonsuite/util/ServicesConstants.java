package com.saloonsuite.util;

public class ServicesConstants extends ApplicationConstants {

	
	public static final String TABLE_NAME = "service_master";
	public static final String SERVICE_ID_COL = "service_id";
	public static final String SERVICE_NAME_COL = "service_name";
	public static final String SELECT_ALL_SERVICES= "SELECT "+ SERVICE_ID_COL + "," 
	   + SERVICE_NAME_COL 	
	   +" FROM " + TABLE_NAME;
	
}
