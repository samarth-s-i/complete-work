package org.jsp.personApp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.personApp.dto.Person;

public class FetchPersonById {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the ID to be fetched: ");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Person p = manager.find(Person.class, id);
		if (p != null) {
			System.out.println("\n\n-------------Person Details-------------\n");
			System.out.println("ID\t: " + p.getId());
			System.out.println("Name\t: " + p.getName());
			System.out.println("Age\t: " + p.getAge());
			System.out.println("Email\t: " + p.getEmail());
			System.out.println("Phone\t: " + p.getPhone());
		} else
			System.err.println("Invalid ID");
	}

}
