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
		
		try {
			Connection con = DbConnector.getConnection();
			String inst = "INSERT INTO PATIENT(name,age,gender) VALUES (?, ?, ?)";
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
		}
	}
}
