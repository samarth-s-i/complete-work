package oneToOneController;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import oneToOneDTO.PanCard;

public class FetchPanCardByPinCode {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		System.out.print("Enter the pincode to be fetched: ");
		Scanner sc = new Scanner(System.in);
		int pincode = sc.nextInt();
		String jpql = "select pc from PanCard pc where pc.pincode=?1";
		Query query = manager.createQuery(jpql);
		query.setParameter(1, pincode);
		try {
			PanCard pc = (PanCard) query.getSingleResult();
			System.out.println("Id: " + pc.getId());
			System.out.println("Number: " + pc.getNumber());
			System.out.println("DOB: " + pc.getDate());
			System.out.println("Pincode: " + pc.getPincode());
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid pincode");
		}
	}
}
