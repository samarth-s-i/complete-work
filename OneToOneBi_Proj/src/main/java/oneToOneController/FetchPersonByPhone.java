package oneToOneController;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import oneToOneDTO.Person;

public class FetchPersonByPhone {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the phone to be fetched: ");
		long phone = sc.nextLong();
		String jpql = "select p from Person p where p.phone=?1";
		Query query = manager.createQuery(jpql);
		query.setParameter(1, phone);
		try {
			Person p = (Person) query.getSingleResult();
			System.out.println("Id: " + p.getId());
			System.out.println("Name: " + p.getName());
			System.out.println("Phone: " + p.getPhone());
			System.out.println("Age: " + p.getAge());
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid phone");
		}
	}
}
