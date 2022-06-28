package staff.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	static Connection con;
	private static final String DB_DRIVER="org.postgresql.Driver";
	private static final String DB_CONNECTION="jdbc:postgresql://ec2-44-195-162-77.compute-1.amazonaws.com:5432/d941dgpst6c5bh";
	private static final String DB_USER="usbwdjxnhxgvdj";
	private static final String DB_PASSWORD="633b06777d2ff1b45a04cbdbce96f8fbad852af2e7c79a0b6027750e7e1d4552";
	
	public static Connection getConnection() {
		try {
			//load the driver
			Class.forName(DB_DRIVER);
			
			try {
				con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
				System.out.println("Connected");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch(ClassNotFoundException e ) {
			e.printStackTrace();
		}
		return con;
	}
}
