package org.jsp.composite_key_demo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.composite_key_demo.dto.Person;
import org.jsp.composite_key_demo.dto.PersonId;

public class FetchPersonByEmailAndPhone {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter phone and email:");
		long phone = s.nextLong();
		String email = s.next();
		PersonId pid = new PersonId();
		pid.setPhone(phone);
		pid.setEmail(email);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Person p = manager.find(Person.class, pid);
		if (p != null) {
			System.out.println("Name: " + p.getName());
			System.out.println("Age: " + p.getAge());
			System.out.println("Email: " + p.getId().getEmail());
			System.out.println("Phone: " + p.getId().getPhone());
		} else
			System.err.println("You have entered invalid email or phone number");
	}
}
