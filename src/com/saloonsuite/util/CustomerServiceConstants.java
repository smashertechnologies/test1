package com.saloonsuite.util;

public abstract class CustomerServiceConstants extends ApplicationConstants{

	public static final String TABLE_NAME = "CUSTOMER_SERVICE";
	public static final String CUSTOMER_ID_COL = "customer_id";
	public static final String SERVICE_ID_COL = "service_id";
	public static final String SERVICE_NAME_COL = "service_name";
	public static final String UPRATING_COL = "uprating";
	public static final String DOWNRATING_COL = "downrating";
	public static final String SELECT_ALL_CUSTOMERSERVICE= "SELECT "+ CUSTOMER_ID_COL + "," 
	   + UPRATING_COL + "," + DOWNRATING_COL	  + "," + SERVICE_ID_COL	+ "," + SERVICE_NAME_COL	
	   +" FROM " + TABLE_NAME;
	
	public static final String SELECT_BY_CUSTOMER_ID= "SELECT "+ CUSTOMER_ID_COL + "," 
	   + UPRATING_COL + "," + DOWNRATING_COL	  + "," + SERVICE_ID_COL	+ "," + SERVICE_NAME_COL	
	   +" FROM " + TABLE_NAME +" WHERE " + CUSTOMER_ID_COL + "=?";
	
}
