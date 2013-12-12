import com.saloonsuite.util.validator.DataValidator;


public class MainClass {

	
	public static void main(String[] args) {
		
		System.out.println(DataValidator.isNumeric("12355w3"));
		System.out.println(DataValidator.isNumeric("123553"));
		System.out.println(DataValidator.isNumeric(null));
		System.out.println(DataValidator.checkForLength(null, 10));
		
	}
}
