package db;

import java.sql.*;

public class CreateTable {
	public static void create() {
		try {
			Connection con = DbConnector.getConnection();
			Statement stmt = con.createStatement();
			
			String patientSchema = "CREATE TABLE IF NOT EXISTS PATIENT("+
						"ID INT PRIMARY KEY AUTO_INCREMENT," +
						"NAME VARCHAR(100) NOT NULL," +
						"AGE INT," +
						"GENDER VARCHAR(10)" +
						")";
			stmt.executeUpdate(patientSchema);

			String doctorSchema = "CREATE TABLE IF NOT EXISTS DOCTOR("+
						"ID INT PRIMARY KEY AUTO_INCREMENT," +
						"NAME VARCHAR(100) NOT NULL," +
						"SPECIALISATION VARCHAR(30)" +
						")";
			stmt.executeUpdate(doctorSchema);

			String admissionSchema = "CREATE TABLE IF NOT EXISTS ADMISSION(" +
						"PATIENT_ID INT," +
						"DOCTOR_ID INT," +
						"WARD VARCHAR(50),"+
						"PRIMARY KEY (PATIENT_ID, DOCTOR_ID)," +
						"FOREIGN KEY (PATIENT_ID) REFERENCES PATIENT(ID) ON DELETE CASCADE," +
						"FOREIGN KEY (DOCTOR_ID) REFERENCES DOCTOR(ID) ON DELETE CASCADE" +
						")";
			stmt.executeUpdate(admissionSchema);

			System.out.println("All tables created successfully!!");
			
			stmt.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
