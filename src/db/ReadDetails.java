package db;
import java.sql.*;

public class ReadDetails {
	public static void readdetails() {
		//Initialising con, ps & rs as null so that 		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DbConnector.getConnection();
			
			String read = "SELECT * FROM PATIENT";
			ps = con.prepareStatement(read);
			
			rs = ps.executeQuery();
			
			System.out.print("Id\tName\t\tAge\tGender\tAddress\t\tContact\t\tDisease\tUnder\t\tDoctor's ID\n");
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				String gender = rs.getString("GENDER");
				String address = rs.getString("ADDRESS");
				String phno = rs.getString("CONTACT");
				String disease = rs.getString("DISEASE");
				String dr_name = rs.getString("UNDER");
				String dr_id = rs.getString("DOCTOR_ID");
				
				
				System.out.println(id+"\t"+name+"\t\t"+age+"\t"+gender+"\t"+address+"\t"+phno+"\t"+disease+"\t"+dr_name+"\t"+dr_id);
			}
		}catch(SQLException e) {
			System.out.print("Error in displaying");
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(con!=null) {
					con.close();
				}
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException e) {
				System.out.print("Error in closing!!!");
			}
		}
	}
}
