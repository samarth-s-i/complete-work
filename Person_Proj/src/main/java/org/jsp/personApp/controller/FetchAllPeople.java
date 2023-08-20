package org.jsp.personApp.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.personApp.dto.Person;

public class FetchAllPeople {

	public static void main(String[] args) {
		String qry = "select p from Person p";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		@SuppressWarnings("unchecked")
		List<Person> persons = q.getResultList();
		for (Person p : persons)
			System.out.println(p);
	}

}
