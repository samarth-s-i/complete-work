package org.jsp.composite_key_demo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.composite_key_demo.dto.FoodOrder;

public class UpdateOrder {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		FoodOrder order = manager.find(FoodOrder.class, 1);
		order.setCost(80);
		manager.merge(order);
		transaction.begin();
		transaction.commit();
	}
}
