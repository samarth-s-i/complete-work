package HospitalController;

import java.util.Scanner;

import HospitalDto.HospitalCRUD;

public class Test {
	public static void main(String[] args) {
		int ch = 0;
		do {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("-------------------Hospital-------------------");
			System.out.print("1. Save\n2. Update\n3. Fetch by ID\n4. Fetch by Founder\n5. Fetch by ID and Name\n");
			System.out.println("6. Delete by ID\n7. Delete by GST\n8. Exit\n");
			System.out.println("----------------------------------------------");
			System.out.print("Enter your choice: ");
			ch = scanner.nextInt();
			System.out.println("----------------------------------------------");
			switch (ch) {
			case 1:
				HospitalCRUD.saveHospital();
				break;
			case 2:
				HospitalCRUD.updateHospital();
				break;
			case 3:
				HospitalCRUD.fetchById();
				break;
			case 4:
				HospitalCRUD.fetchByFounder();
				break;
			case 5:
				HospitalCRUD.fetchByIdAndName();
				break;
			case 6:
				HospitalCRUD.deleteById();
				break;
			case 7:
				HospitalCRUD.deleteByGst();
				break;
			case 8:
				System.out.println("Exiting....");
				break;
			default:
				System.out.println("Invalid choice!!\n");
			}
		} while (ch != 8);

	}
}
