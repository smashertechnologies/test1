package com.saloonsuite.util;

public abstract class CustomerInfoConstants extends ApplicationConstants {
	
	public static final String TABLE_NAME = "CUSTOMER_INFO";
	public static final String VIEW_NAME = "VW_CUSTOMER_INFO";
	public static final String CUSTOMER_ID_COL = "customer_id";
	public static final String CUSTOMER_TITLE_COL = "customer_title";
	public static final String UPRATING_COL = "uprating";
	public static final String DOWNRATING_COL = "downrating";
	public static final String IMG_NAME_COL = "img_name";
	public static final String EMAIL_COL = "email";
	public static final String SELECT_ALL_CUSTOMERINFO= "SELECT "+ CUSTOMER_ID_COL + "," + CUSTOMER_TITLE_COL + ","
	   + UPRATING_COL + "," + DOWNRATING_COL	  + "," + IMG_NAME_COL	+ "," + EMAIL_COL	
	   +" FROM " + TABLE_NAME;
}
