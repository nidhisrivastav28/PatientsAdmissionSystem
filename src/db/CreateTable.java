package db;

import java.sql.*;

public class CreateTable {
	public static void createPatientTable() {
		try {
			Connection con = DbConnector.getConnection();
			Statement stmt = con.createStatement();
			
			String sql = "CREATE TABLE IF NOT EXISTS PATIENT("+
						"ID INT PRIMARY KEY AUTO_INCREMENT," +
						"NAME VARCHAR(100) NOT NULL," +
						"AGE INT," +
						"GENDER VARCHAR(10)," +
						"ADDRESS VARCHAR(100),"+
						"CONTACT VARCHAR(10),"+
						"DISEASE VARCHAR(100),"+
						"UNDER VARCHAR(100),"+
						"DOCTOR_ID VARCHAR(5)"+
						")"; 
			stmt.executeUpdate(sql);
			System.out.println("Patient Table created Successfully!!");
			
			stmt.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
