package org.jsp.user_product_app.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.user_product_app.dto.User;

public class UserDao {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public User register(User u) {
		manager.persist(u);
		transaction.begin();
		transaction.commit();
		return u;
	}

	@SuppressWarnings("resource")
	public User update(int id) {

		User u = manager.find(User.class, id);
		if (u != null) {
			Scanner s = new Scanner(System.in);
			System.out.println("Enter the Name, Phone, Email and Password");
			u.setName(s.next());
			u.setPhone(s.nextLong());
			u.setEmail(s.next());
			u.setPassword(s.next());
			manager.merge(u);
			transaction.begin();
			transaction.commit();
			return u;
		} else {
			System.err.println("Invalid Id");
			return u;
		}
	}

	public void loginPhone(User u) {
		String qry = "select u from User u where u.phone=?1 and u.password=?2";
		Query query = manager.createQuery(qry);
		query.setParameter(1, u.getPhone());
		query.setParameter(2, u.getPassword());
		User u = (User) query.getSingleResult();
		if (u != null) {
			System.out.println("Name: " + u.getName());
			System.out.println("Phone: " + u.getPhone());
			System.out.println("Email: " + u.getEmail	());
		}
	}
}
