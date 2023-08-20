package org.jsp.many_to_many_uni.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.many_to_many_uni.dto.Batch;
import org.jsp.many_to_many_uni.dto.Student;

public class SaveBatchAndStudent {
	public static void main(String[] args) {
		Batch b1 = new Batch();
		b1.setCode("SEHE01");
		b1.setSubject("JAVA");

		Batch b2 = new Batch();
		b2.setCode("SEHE02");
		b2.setSubject("J2EE");

		Batch b3 = new Batch();
		b3.setCode("SEHE03");
		b3.setSubject("Hibernate");

		Student s1 = new Student();
		s1.setName("Samarth");
		s1.setPerc(85);
		s1.setPhone(888);

		Student s2 = new Student();
		s2.setName("Laxmi");
		s2.setPerc(95);
		s2.setPhone(999);

		Student s3 = new Student();
		s3.setName("Nags");
		s3.setPerc(90);
		s3.setPhone(777);

		b1.setStudents(new ArrayList<Student>(Arrays.asList(s1, s2, s3)));
		b2.setStudents(new ArrayList<Student>(Arrays.asList(s1, s2, s3)));
		b3.setStudents(new ArrayList<Student>(Arrays.asList(s1, s2, s3)));

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		transaction.begin();
		transaction.commit();
	}
}
