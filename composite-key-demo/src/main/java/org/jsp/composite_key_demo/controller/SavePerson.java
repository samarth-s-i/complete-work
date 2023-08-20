package org.jsp.composite_key_demo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.composite_key_demo.dto.Person;
import org.jsp.composite_key_demo.dto.PersonId;

public class SavePerson {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your age, name, phone and email:");
		int age = s.nextInt();
		String name = s.next();
		long phone = s.nextLong();
		String email = s.next();
		PersonId id = new PersonId();
		id.setEmail(email);
		id.setPhone(phone);
		Person p = new Person();
		p.setAge(age);
		p.setName(name);
		p.setId(id);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(p);
		transaction.begin();
		transaction.commit();
	}
}
