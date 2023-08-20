package org.jsp.lifecycle.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.lifecycle.dto.User;

public class TestLifeCycle {

	public static void main(String[] args) {
		User u = new User();
		u.setId(1);
		u.setName("Sam");
		u.setPhone(888);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.merge(u);// Persistent state
		transaction.begin();
		transaction.commit();
		u.setName("Virat");
		u.setPhone(999);
		transaction.begin();
		transaction.commit();
	}

}
