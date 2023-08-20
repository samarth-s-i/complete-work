package oneToOneController;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import oneToOneDTO.PanCard;

public class FetchPanCardByPersonName {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Person Name: ");
		String name = sc.next();
		String jpql = "select p.card from Person p where p.name=?1";
		Query query = manager.createQuery(jpql);
		query.setParameter(1, name);
		try {
			PanCard pc = (PanCard) query.getSingleResult();
			System.out.println("Id: " + pc.getId());
			System.out.println("DOB: " + pc.getDate());
			System.out.println("Number: " + pc.getNumber());
			System.out.println("Pincode: " + pc.getPincode());
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid Person Id");
		}
	}
}
