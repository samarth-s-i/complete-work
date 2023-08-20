package org.jsp.personApp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.personApp.dto.Person;

public class UpdatePerson {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Scanner s = new Scanner(System.in);
		Person p = new Person();
		System.out.print("\nEnter the Id to update the reocrd: ");
		int id = s.nextInt();
		p.setId(id);
		System.out.println("Enter your details:");
		System.out.print("Name: ");
		String name = s.next();
		System.out.print("Age: ");
		int age = s.nextInt();
		System.out.print("Email: ");
		String email = s.next();
		System.out.print("Phone: ");
		long phone = s.nextLong();
		System.out.print("Password: ");
		String password = s.next();
		p.setName(name);
		p.setAge(age);
		p.setEmail(email);
		p.setPhone(phone);
		p.setPassword(password);
		manager.merge(p);
		transaction.begin();
		transaction.commit();
	}

}
