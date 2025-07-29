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
			
			System.out.print("Id\tName\t\tAge\tGender\n");
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				
				System.out.println(id+"\t"+name+"\t"+age+"\t"+gender);
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
