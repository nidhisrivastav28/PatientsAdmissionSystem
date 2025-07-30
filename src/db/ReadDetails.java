package db;
import java.sql.*;
import java.util.Scanner;

public class ReadDetails {
	public static void readPatientDetails() {		
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
	
	public static void readPatientDetailsByName() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter patient name: ");
		String pname = sc.nextLine();
		try {
			con = DbConnector.getConnection();
			
			String read = "SELECT * FROM PATIENT WHERE name LIKE ?";
			ps = con.prepareStatement(read);
			ps.setString(1, "%" + pname + "%");
			
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
				sc.close();
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
	
	public static void readDoctorDetails() {		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DbConnector.getConnection();
			
			String read = "SELECT * FROM DOCTOR";
			ps = con.prepareStatement(read);
			
			rs = ps.executeQuery();
			
			System.out.print("Id\tName\t\tSpecialisation\n");
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String specialisation = rs.getString("specialisation");
				
				System.out.println(id+"\t"+name+"\t"+specialisation);
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
	
	public static void readDoctorDetailsBySpecialisation() {		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter specialisation: ");
		String spcl = sc.nextLine();
		try {
			con = DbConnector.getConnection();
			
			String read = "SELECT * FROM DOCTOR WHERE SPECIALISATION LIKE ?";
			ps = con.prepareStatement(read);
			ps.setString(1, "%" + spcl + "%");
			
			rs = ps.executeQuery();
			
			System.out.print("Id\tName\t\tSpecialisation\n");
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String specialisation = rs.getString("specialisation");
				
				System.out.println(id+"\t"+name+"\t"+specialisation);
			}
		}catch(SQLException e) {
			System.out.print("Error in displaying");
		}finally {
			try {
				sc.close();
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
	
	public static void readAdmissionDetails() {		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DbConnector.getConnection();
			
			String read = "SELECT"+
				    "a.PATIENT_ID, a.DOCTOR_ID, a.WARD"+
				    "p.NAME AS PATIENT_NAME,"+
				    "d.NAME AS DOCTOR_NAME,"+
				    "FROM ADMISSION a"+
				    "JOIN PATIENT p ON a.PATIENT_ID = p.ID"+
				    "JOIN DOCTOR d ON a.DOCTOR_ID = d.ID";
			ps = con.prepareStatement(read);
			
			rs = ps.executeQuery();
			
			System.out.print("P_Id\tP_Name\t\tD_Id\tD_Name\t\tWard\n");
			while(rs.next()) {
				int pid = rs.getInt(1);
				int did = rs.getInt(2);
				String ward = rs.getString(3);
				String pname = rs.getString(4);
				String dname = rs.getString(5);
				
				System.out.println(pid+"\t"+pname+"\t"+did+"\t"+dname+"\t"+ward);
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