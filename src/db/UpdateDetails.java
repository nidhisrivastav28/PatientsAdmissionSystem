package db;
import java.sql.*;
import java.util.*;

public class UpdateDetails {
    public static void updatedetails() {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        PreparedStatement ps = null;

        try {
            System.out.print("Enter ID of the Patient to Update: ");
            int id = sc.nextInt();
            sc.nextLine(); // clear buffer

            System.out.println("What do you want to update?");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Gender");
            System.out.println("4. All fields");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            con = DbConnector.getConnection();
            String updateQuery = "";

            switch (choice) {
                case 1:
                    System.out.print("Enter new Name: ");
                    String name = sc.nextLine();
                    updateQuery = "UPDATE PATIENT SET NAME = ? WHERE ID = ?";
                    ps = con.prepareStatement(updateQuery);
                    ps.setString(1, name);
                    ps.setInt(2, id);
                    break;

                case 2:
                    System.out.print("Enter new Age: ");
                    int age = sc.nextInt();
                    updateQuery = "UPDATE PATIENT SET AGE = ? WHERE ID = ?";
                    ps = con.prepareStatement(updateQuery);
                    ps.setInt(1, age);
                    ps.setInt(2, id);
                    break;

                case 3:
                    System.out.print("Enter new Gender: ");
                    String gender = sc.nextLine();
                    updateQuery = "UPDATE PATIENT SET GENDER = ? WHERE ID = ?";
                    ps = con.prepareStatement(updateQuery);
                    ps.setString(1, gender);
                    ps.setInt(2, id);
                    break;

                case 4:
                    System.out.print("Enter new Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Gender: ");
                    String newGender = sc.nextLine();
                    System.out.print("Enter new Address: ");
                    String address = sc.nextLine();
                    System.out.print("Enter new Contact Number: ");
                    String phno = sc.nextLine();
                    System.out.print("Enter new Disease: ");
                    String disease = sc.nextLine();
                    System.out.print("Enter Under Consultation Of: ");
                    String under = sc.nextLine();
                    System.out.print("Enter new Doctor ID: ");
                    String drId = sc.nextLine();

                    updateQuery = "UPDATE PATIENT SET NAME = ?, AGE = ?, GENDER = ?, ADDRESS = ?, CONTACT = ?, DISEASE = ?, UNDER = ?, DOCTOR_ID = ? WHERE ID = ?";
                    ps = con.prepareStatement(updateQuery);
                    ps.setString(1, newName);
                    ps.setInt(2, newAge);
                    ps.setString(3, newGender);
                    ps.setString(4, address);
                    ps.setString(5, phno);
                    ps.setString(6, disease);
                    ps.setString(7, under);
                    ps.setString(8, drId);
                    ps.setInt(9, id);
                    break;

                default:
                    System.out.println("Invalid choice.");
                    return;
            }

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Patient details updated successfully!");
            } else {
                System.out.println("No patient found with ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Error while updating: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources.");
            }
        }
    }
}
