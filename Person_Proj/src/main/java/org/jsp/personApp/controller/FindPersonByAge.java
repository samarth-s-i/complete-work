package org.jsp.personApp.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.personApp.dto.Person;

public class FindPersonByAge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the age to find the person: ");
		int age = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createNamedQuery("findByAge");
		q.setParameter(1, age);
		@SuppressWarnings("unchecked")
		List<Person> persons = q.getResultList();
		for (Person p : persons)
			System.out.println(p);
	}

}
