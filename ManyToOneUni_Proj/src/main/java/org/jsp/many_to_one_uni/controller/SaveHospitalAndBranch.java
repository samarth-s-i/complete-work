package org.jsp.many_to_one_uni.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.many_to_one_uni.dto.Branch;
import org.jsp.many_to_one_uni.dto.Hospital;

public class SaveHospitalAndBranch {

	public static void main(String[] args) {
		Hospital h = new Hospital();
		h.setName("Apollo");
		h.setFounder("Narendra Modi");
		h.setGst("ASIDE123");

		Branch b1 = new Branch();
		b1.setName("BSK");
		b1.setPhone(123);
		b1.setEmail("apbsk@gmail.com");
		b1.setHospital(h);

		Branch b2 = new Branch();
		b2.setName("JP Nagar");
		b2.setPhone(456);
		b2.setEmail("apjpn@gmail.com");
		b2.setHospital(h);

		Branch b3 = new Branch();
		b3.setName("Jayanagar");
		b3.setPhone(789);
		b3.setEmail("apjyn@gmail.com");
		b3.setHospital(h);

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		transaction.begin();
		transaction.commit();
	}

}
