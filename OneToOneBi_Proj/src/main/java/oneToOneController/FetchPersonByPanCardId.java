package oneToOneController;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import oneToOneDTO.Person;

public class FetchPersonByPanCardId {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Pan Card Id: ");
		int id = sc.nextInt();
		String jpql = "select pc.p from PanCard pc where pc.id=?1";
//		String jpql = "select p from Person p where p.card.id=?1";
		Query query = manager.createQuery(jpql);
		query.setParameter(1, id);
		try {
			Person p = (Person) query.getSingleResult();
			System.out.println("Id: " + p.getId());
			System.out.println("Name: " + p.getName());
			System.out.println("Phone: " + p.getPhone());
			System.out.println("Age: " + p.getAge());
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid Pan Card Id");
		}
	}
}
