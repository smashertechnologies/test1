package com.saloonsuite.util;

public abstract class CustomerAddressConstants  extends ApplicationConstants {
	
	public static final String TABLE_NAME = "customer_address_info";
	public static final String CUSTOMER_ID_COL = "customer_id";
	public static final String ADDRESS_1_COL = "address_1";
	public static final String ADDRESS_2_COL = "address_2";
	public static final String CITY_COL = "city";
	public static final String STATE_COL = "state";
	public static final String ZIPCODE_COL = "zipcode";
	
	public static final String SELECT_ALL_CUSTOMERADDRESS= "SELECT "+ CUSTOMER_ID_COL + "," + ADDRESS_1_COL + ","+ADDRESS_2_COL +","
	   + CITY_COL + "," + STATE_COL	  + "," + ZIPCODE_COL	
	   +" FROM " + TABLE_NAME;
	
	public static final String SELECT_BY_CUSTOMER_ID= "SELECT "+ CUSTOMER_ID_COL + "," + ADDRESS_1_COL + ","+ADDRESS_2_COL +","
	   + CITY_COL + "," + STATE_COL	  + "," + ZIPCODE_COL	
	   +" FROM " + TABLE_NAME + " WHERE " + CUSTOMER_ID_COL +"=?";
	
}
