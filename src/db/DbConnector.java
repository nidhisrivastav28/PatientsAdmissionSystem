package db;

import java.sql.*;

public class DbConnector {
		private static final String url = "jdbc:mysql://localhost:3306/patient-application-system";
		private static final String username = "root";
		private static final String password = "nidhi";
		
		public static Connection getConnection() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
//				System.out.println("Driver loaded Successfully!!");
				return con;
			}catch(ClassNotFoundException e){
				System.out.println("Driver not found"+e.getMessage());
			}catch(SQLException e) {
				System.out.println("SQL Error" + e.getMessage());
			}
			return null;
		}
	public static void main(String[] args) {
		getConnection();
	}
}
