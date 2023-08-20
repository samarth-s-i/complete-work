package oneToOneController;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import oneToOneDTO.PanCard;

public class FetchPanCardById {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		System.out.print("Enter the Id to be fetched: ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		PanCard pc = manager.find(PanCard.class, id);
		if (pc != null) {
			System.out.println("Id: " + pc.getId());
			System.out.println("Number: " + pc.getNumber());
			System.out.println("DOB: " + pc.getDate());
			System.out.println("Pincode: " + pc.getPincode());
		} else
			System.err.println("You have entered an invalid id");
	}
}
