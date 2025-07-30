package db;
import java.util.*;
import java.sql.*;

public class InsertPatient {
	public static void insertdetails() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name of Patient:");
		String name = sc.nextLine();
		
		System.out.println("Enter the age of Patient:");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the gender of Patient:");
		String gender = sc.nextLine();
			
		System.out.println("Enter the address of Patient:");
		String address = sc.nextLine();
		
		System.out.println("Enter contact number of Patient:");
		String phno = sc.nextLine();
		
		System.out.println("Enter the disease of Patient:");
		String disease = sc.nextLine();
		
		System.out.println("Patient is under consideration of:");
		String dr_name = sc.nextLine();
		
		System.out.println("Enter Doctor's Id:");
		String d_id = sc.nextLine();
		
		try {
			Connection con = DbConnector.getConnection();
			String inst = "INSERT INTO PATIENT(NAME,AGE,GENDER,ADDRESS,CONTACT,DISEASE,UNDER,DOCTOR_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(inst);
			
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, gender);
			ps.setString(4, address);
			ps.setString(5, phno);
			ps.setString(6, disease);
			ps.setString(7, dr_name);
			ps.setString(8, d_id);
			
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
		}
	}
}
