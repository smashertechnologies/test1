package com.saloonsuite.base;

import java.util.Properties;

public class AppProperties extends Properties{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Properties props = new Properties();
	private AppProperties() {
	}
	
	public static Properties getProperties() {
		return props;
	}

	public static String getValue(String propertyName) {
		return props.getProperty(propertyName);
	}
}
