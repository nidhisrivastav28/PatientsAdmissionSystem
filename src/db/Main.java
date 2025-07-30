package db;

import java.util.*;
public class Main {
	public static void main(String[] args) {
		
		//Uncomment this only when the table is created for the first time		
		//CreateTable.createPatientTable();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter your choice:");
			System.out.println("1. Insert Patient Details-");
			System.out.println("2. Show Patient Details-");
			System.out.println("3. Update Patient Details-");
			System.out.println("4. Delete Patient Details-");
			System.out.println("5. Exit?");
			int ch = sc.nextInt();
			
			switch(ch) {
				case 1: InsertPatient.insertdetails();
					break;
				case 2: ReadDetails.readdetails();
					break;
				case 3:UpdateDetails.updatedetails();;
					break;
				case 4:ReadDetails.readdetails();
					   DeleteDetails.deletedetails();
					break;
				case 5:System.out.println("Existing...");
					sc.close();
					System.exit(0);
				default:System.out.println("Invalid Choice!!!");
			}
			
		}
	}
}
