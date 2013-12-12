package com.saloonsuite.util.validator;

public abstract class DataValidator extends BaseValidator{


	public final static boolean checkForLength(String str,int length){
		
		if(isNull(str))
			return false;
		return ( str.length() <= length );
		
	}
	
	public final static boolean isNumeric(String str){
		
		if(isNullOrBlank(str))
				return false;
		return (str.matches("[0-9]+"));
		
	}
	
	public final static boolean isCharacters(String str){
		
		if(isNullOrBlank(str))
				return false;
		return (str.matches("[a-zA-Z]+"));
		
	}

	//More methods for utility purpose can be added here.
	
}
