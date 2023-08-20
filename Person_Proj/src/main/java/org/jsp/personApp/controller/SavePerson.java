package org.jsp.personApp.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.personApp.dto.Person;

public class SavePerson {

	public static void main(String[] args) {
		Person p = new Person();
		p.setName("Sam");
		p.setAge(23);
		p.setPhone(8892);
		p.setPassword("sam123");
		p.setEmail("sam@gmail.com");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(p);
		transaction.begin();
		transaction.commit();
	}

}
