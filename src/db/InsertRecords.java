package db;
import java.util.*;
import java.sql.*;

public class InsertRecords {
	public static void insertPatientDetails() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name of Patient: ");
		String name = sc.nextLine();
		
		System.out.println("Enter the age of Patient: ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the gender of Patient: ");
		String gender = sc.nextLine();
		
		try {
			Connection con = DbConnector.getConnection();
			String inst = "INSERT INTO PATIENT (name, age, gender) VALUES (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(inst);
			
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, gender);
			
			int rows = ps.executeUpdate();
			if(rows>0) {
				System.out.println("Successfully Inserted Patient Details!!!");
			}else {
				System.out.println("Insertion Failed!!!");
			}
			ps.close();
			con.close();
			
		}catch(SQLException e) {
			System.out.print("Error occured!!!" + e.getMessage());
		} finally {
			sc.close();
		}
	}
	
	public static void insertDoctorDetails() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name of Doctor: ");
		String name = sc.nextLine();
		
		System.out.println("Enter specialisation of the Doctor: ");
		String specialisation = sc.nextLine();
		
		try {
			Connection con = DbConnector.getConnection();
			String inst = "INSERT INTO DOCTOR (name, specialisation) VALUES (?, ?)";
			PreparedStatement ps = con.prepareStatement(inst);
			
			ps.setString(1, name);
			ps.setString(2, specialisation);
			
			int rows = ps.executeUpdate();
			if(rows>0) {
				System.out.println("Successfully Inserted Doctor Details!!!");
			}else {
				System.out.println("Insertion Failed!!!");
			}
			ps.close();
			con.close();
			
		}catch(SQLException e) {
			System.out.print("Error occured!!!" + e.getMessage());
		} finally {
			sc.close();
		}
	}
	
	public static void insertAdmissionDetails() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Patient ID: ");
		int pID = sc.nextInt();
		
		System.out.println("Enter Doctor ID: ");
		int dID = sc.nextInt();

		System.out.print("Enter ward: ");
		String ward = sc.nextLine();
		
		try {
			Connection con = DbConnector.getConnection();
			String inst = "INSERT INTO ADMISSION (patient_id, doctor_id, ward) VALUES (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(inst);
			
			ps.setInt(1, pID);
			ps.setInt(2, dID);
			ps.setString(3, ward);
			
			int rows = ps.executeUpdate();
			if(rows>0) {
				System.out.println("Successfully Inserted Admission Details!!!");
			}else {
				System.out.println("Insertion Failed!!!");
			}
			ps.close();
			con.close();
			
		}catch(SQLException e) {
			System.out.print("Error occured!!!" + e.getMessage());
		} finally {
			sc.close();
		}
	}
}