package org.jsp.personApp.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.personApp.dto.Person;

public class FetchPerson {
	static Scanner sc = new Scanner(System.in);
	static EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

	public static void fetchByPhone() {
		long phone = sc.nextLong();
		Query q = manager.createNamedQuery("findByPhone");
		q.setParameter(1, phone);
		@SuppressWarnings("unchecked")
		List<Person> persons = q.getResultList();
		for (Person p : persons)
			System.out.println(p);
	}

	public static void main(String[] args) {

		boolean flag = true;

		do {
			System.out.println("-----------------Menu------------------");
			System.out.println(
					"1. Fetch Person By Phone\n2. Fetch Person By Email\n3. Fetch Person By Name\n4. Fetch all names");
			System.out.println("5. Fetch age By ID\n6.Fetch ID By Name\n7. Fetch phone By Name\n8. Exit");
			System.out.println("---------------------------------------");
			System.out.print("Enter your choice: ");
			int ch = sc.nextInt();
			System.out.println("---------------------------------------");
			switch (ch) {
			case 1:
				fetchByPhone();
				break;
			case 2:
				fetchByEmail();
				break;
			case 3:
				fetchByName();
				break;
			case 4:
				fetchAll();
				break;
			case 5:
				fetchById();
				break;
			case 6:
				fetchIdByName();
				break;
			case 7:
				fetchPhoneByName();
				break;
			case 8:
				System.out.println("Exiting....");
				flag = false;
				break;
			default:
				System.out.println("Invalid choice");
			}
		} while (flag);
	}

	private static void fetchPhoneByName() {
		String name = sc.next();
		Query q = manager.createNamedQuery("fetchPhoneByName");
		q.setParameter(1, name);
		@SuppressWarnings("unchecked")
		List<Person> persons = q.getResultList();
		for (Person p : persons)
			System.out.println(p);
	}

	private static void fetchIdByName() {
		String name = sc.next();
		Query q = manager.createNamedQuery("fetchIdByName");
		q.setParameter(1, name);
		@SuppressWarnings("unchecked")
		List<Person> persons = q.getResultList();
		for (Person p : persons)
			System.out.println(p);
	}

	private static void fetchById() {
		int id = sc.nextInt();
		Query q = manager.createNamedQuery("fetchById");
		q.setParameter(1, id);
		@SuppressWarnings("unchecked")
		List<Person> persons = q.getResultList();
		for (Person p : persons)
			System.out.println(p);
	}

	private static void fetchAll() {
		Query q = manager.createNamedQuery("fetchAll");
		@SuppressWarnings("unchecked")
		List<Person> persons = q.getResultList();
		for (Person p : persons)
			System.out.println(p);
	}

	private static void fetchByName() {
		String name = sc.next();
		Query q = manager.createNamedQuery("fetchByName");
		q.setParameter(1, name);
		@SuppressWarnings("unchecked")
		List<Person> persons = q.getResultList();
		for (Person p : persons)
			System.out.println(p);
	}

	private static void fetchByEmail() {
		String email = sc.next();
		Query q = manager.createNamedQuery("fetchByEmail");
		q.setParameter(1, email);
		@SuppressWarnings("unchecked")
		List<Person> persons = q.getResultList();
		for (Person p : persons)
			System.out.println(p);
	}

}
