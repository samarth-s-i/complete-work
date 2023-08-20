package org.jsp.lifecycle.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.lifecycle.dto.User;

public class DeleteUser {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		User u = manager.find(User.class, 1);// Persistent state
		manager.remove(u);// Removed state
		transaction.begin();
		transaction.commit();
	}

}
