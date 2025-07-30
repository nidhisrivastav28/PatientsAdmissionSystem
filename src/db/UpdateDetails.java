package db;
import java.sql.*;
import java.util.*;

public class UpdateDetails {
    public static void updatePatientDetails() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Patient ID: ");
		int id = sc.nextInt();
		System.out.println("Enter age of Patient: ");
		int age = sc.nextInt();
		
		try {
			Connection con = DbConnector.getConnection();
			String updt = "UPDATE PATIENT SET AGE = ? WHERE ID = ?";
			PreparedStatement ps = con.prepareStatement(updt);
			
			ps.setInt(1, age);
			ps.setInt(2, id);
			
			int rows = ps.executeUpdate();
			if(rows>0) {
				System.out.println("Patient Details Updated Successfully!!!");
			}else {
				System.out.println("Update Failed!!!");
			}
			ps.close();
			con.close();
			
		}catch(SQLException e) {
			System.out.print("Error occured!!!" + e.getMessage());
		} finally {
			sc.close();
		}
	}
	
	public static void updateDoctorDetails() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Dooctor ID: ");
		int id = sc.nextInt();
		System.out.println("Enter Specialisation of the Doctor: ");
		String spcl = sc.nextLine();
		
		try {
			Connection con = DbConnector.getConnection();
			String updt = "UPDATE DOCTOR SET SPECIALISATION = ? WHERE ID = ?";
			PreparedStatement ps = con.prepareStatement(updt);
			
			ps.setString(1, spcl);
			ps.setInt(2, id);
			
			int rows = ps.executeUpdate();
			if(rows>0) {
				System.out.println("Doctor Details Updated Successfully!!!");
			}else {
				System.out.println("Update Failed!!!");
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