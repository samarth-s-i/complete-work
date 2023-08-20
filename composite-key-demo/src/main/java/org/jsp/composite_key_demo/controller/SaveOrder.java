package org.jsp.composite_key_demo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.composite_key_demo.dto.FoodOrder;

public class SaveOrder {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		FoodOrder order = new FoodOrder();
		order.setFood_item("Gobi");
		order.setCost(60);
		manager.persist(order);
		transaction.begin();
		transaction.commit();
	}
}
