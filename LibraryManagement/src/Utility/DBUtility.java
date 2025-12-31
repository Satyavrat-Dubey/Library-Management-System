package Utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
	public static Connection getConnection() {
		Connection con=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/Basicdb";
		String user="root";
		String pass="root@123";
		 con=DriverManager.getConnection(url, user, pass);
	} 
	catch(Exception e) {
		e.printStackTrace();
	}
	return con;

}
}
