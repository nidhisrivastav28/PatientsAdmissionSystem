package db;
import java.util.*;
import java.sql.*;

public class DeleteDetails {
	public static void deletedetails() {
		Scanner sc = new Scanner(System.in);
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			System.out.print("Enter ID of the Patient to Delete:");
			int choice = sc.nextInt();
			
			
			System.out.println("Are you sure you want to delete?Y/N?");
			char c = sc.next().toUpperCase().charAt(0);
			
			if(c=='Y') {
				con = DbConnector.getConnection();
				
				String dlt = "DELETE FROM PATIENT WHERE ID = ?";
				ps = con.prepareStatement(dlt);
				ps.setInt(1, choice);
				
				int rs = ps.executeUpdate();
				if(rs > 0) {
					System.out.print("Deletion Successful!!!");
				}else {
					System.out.println("No Record found with that id");
				}
			}else {
				System.out.println("Deletion cancelled!!!");
			}
		}catch(SQLException e) {
			System.out.println("Error in deletion!" + e.getMessage());
		}
	}
}
