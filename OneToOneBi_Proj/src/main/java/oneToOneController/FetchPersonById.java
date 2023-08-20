package oneToOneController;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import oneToOneDTO.Person;

public class FetchPersonById {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Person Id to be fetched: ");
		int id = sc.nextInt();
		Person p = manager.find(Person.class, id);
		if (p != null) {
			System.out.println("Id: " + p.getId());
			System.out.println("Name: " + p.getName());
			System.out.println("Phone: " + p.getPhone());
			System.out.println("Age: " + p.getAge());
		} else
			System.err.println("You have enetered an invalid id");
	}
}
