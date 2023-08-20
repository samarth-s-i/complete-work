package org.jsp.personApp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.personApp.dto.Person;

public class VerifyPerson {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the-");
		System.out.print("Phone Number: ");
		long phone = s.nextLong();
		System.out.print("Password: ");
		String password = s.next();
		String qry = "select p from Person p where p.phone=?1 and p.password=?2";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println("Hello Mr " + p.getName() + " Login succesful!");
		} catch (NoResultException e) {
			System.err.println("Phone number or password is incorrect");
		}
	}

}
