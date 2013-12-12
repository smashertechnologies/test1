import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.saloonsuite.dao.CustomerInfoDAO;
import com.saloonsuite.dao.CustomerInfoDAOImpl;
import com.saloonsuite.data.entity.CustomerInfo;



public class TestConnection {

	private static final String DB_HOST = "localhost";
	private static final String DB_NAME = "esal";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "password";

	
	private Connection getConnection() {
		Connection con  = null;
		try{
	
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://"+ DB_HOST +"/"+ DB_NAME +"?"
		              + "user="+DB_USER+"&password="+DB_PASSWORD);

			
		}catch (Exception ex) {
			con = null;
	
		}
		return con;
	}
	public void testConnect() {
		
		Connection con = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://"+ DB_HOST +"/"+ DB_NAME +"?"
		              + "user="+DB_USER+"&password="+DB_PASSWORD);

			
			System.out.println("Connection State : " + con );
			String QUERY="SELECT * FROM esal.user_info where firstname=?";
			//ResultSet rSet = con.createStatement().executeQuery(QUERY);
			PreparedStatement pStmt = con.prepareStatement(QUERY);
			pStmt.setString(1, "Users1");
			ResultSet rSet = pStmt.executeQuery();
			if(rSet.next()) {
				
				do{
					
					System.out.println("Name :" + rSet.getString("firstname") + " " + rSet.getString("lastname") + "(" + rSet.getString("email") + "," + rSet.getString("mobileno") +")");
					
					
				}while(rSet.next());
				
			} else {
				System.out.println("No Record Found!");
			}
			
			
		} catch ( Exception ex) {

			ex.printStackTrace();
		}
		
	}
	
	public boolean createNewUser() {
		
		Connection con = getConnection();
		try {
		if ( con != null ){
		
			/*String QUERY = "INSERT INTO esal.USER_LOGIN_INFO (username,password,firstname,lastname,email,mobileno) VALUES (?,?,?,?,?,?)";
			PreparedStatement pStmt = con.prepareStatement(QUERY);
			pStmt.setString(1, "ronakgpatel");
			pStmt.setString(2, "password");
			pStmt.setString(3, "Ronak");
			pStmt.setString(4, "Patel");
			pStmt.setString(5, "rgpatel@live.com");
			pStmt.setLong(6, 9898556078l);
			int count = pStmt.executeUpdate();*/
			
			/*if ( count <= 0)
				return false;*/
			
			
		} else {
			System.err.println("Connection not found to the database.");
			return false;
		}
		} catch ( Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		/*TestConnection con = new  TestConnection();
		con.testConnect();
		con.createNewUser();
		con.testConnect();
*/
		
		
		CustomerInfoDAO dao = new CustomerInfoDAOImpl();
		
		List<CustomerInfo> all = (List<CustomerInfo>)dao.getAll();
		for(CustomerInfo c : all ) {
			System.out.println(c);
		}
		
		
		
	}

	static Properties props = new Properties();
	
	static {
	
		try {
			File f = new File("D:\\workspace\\saloonsuite\\db.properties");
			props.load(new FileInputStream(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("Could not find configuration bundle for initializing application. Startup aborted.");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error while loading configuration bundle for initializing application. Startup aborted.");
			System.exit(0);
		}
	}
	
	public static String getValue(String propertyName) {
		return props.getProperty(propertyName);
	}
}
