package db;

import java.util.*;
public class Main {
	public static void main(String[] args) {
			
	    CreateTable.create();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter your choice:");
			System.out.println("1. Insert Patient Details-");
			System.out.println("2. Show Patient Details-");
			System.out.println("3. Search Patient Details By Name-");
			System.out.println("4. Update Patient Details-");
			System.out.println("5. Delete Patient Details-");
			System.out.println("6. Insert Doctor Details-");
			System.out.println("7. Show Doctor Details-");
			System.out.println("8. Search Doctor Details By Specialisation-");
			System.out.println("9. Update Doctor Details-");
			System.out.println("10. Delete Doctor Details-");
			System.out.println("11. Insert Patient Admission Details-");
			System.out.println("12. Show Patient Admission Details-");
			System.out.println("13. Exit?");
			int ch = sc.nextInt();
			
			switch(ch) {
				case 1: InsertRecords.insertPatientDetails();
					break;
				case 2: ReadDetails.readPatientDetails();
					break;
				case 3:ReadDetails.readPatientDetailsByName();
					break;
				case 4:UpdateDetails.updatePatientDetails();
					break;
				case 5:DeleteDetails.deletePatientDetails();
					break;
				case 6:InsertRecords.insertDoctorDetails();
					break;
				case 7:ReadDetails.readDoctorDetails();
					break;
				case 8:ReadDetails.readDoctorDetailsBySpecialisation();
					break;
				case 9:UpdateDetails.updateDoctorDetails();
					break;
				case 10:DeleteDetails.deleteDoctorDetails();
					break;
				case 11:InsertRecords.insertAdmissionDetails();
					break;
				case 12:ReadDetails.readAdmissionDetails();
					break;
				case 13:System.out.println("Existing...");
					sc.close();
					System.exit(0);
				default:System.out.println("Invalid Choice!!!");
			}
			
		}
	}
}
