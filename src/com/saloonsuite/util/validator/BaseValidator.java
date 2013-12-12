package com.saloonsuite.util.validator;

import com.saloonsuite.util.BaseUtility;

public abstract class BaseValidator extends BaseUtility {
	public final static boolean isNull(Object obj){
		return obj == null;
	}
	
	public final static boolean isNullOrBlank(String str) {
		
		if ( isNull(str))
			return true;
		
		return ("".equalsIgnoreCase(str.trim()));
		
	}
}
