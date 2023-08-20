package org.jsp.OneToManyUni.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.OneToManyUni.dto.Answer;
import org.jsp.OneToManyUni.dto.Question;

public class SaveQuestionAndAnswers {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Question q = new Question();
		q.setQuestion("What is Hibernate?");
		q.setQuestionedBy("Sam");

		Answer a1 = new Answer();
		a1.setAnswer("It is an open source framework");
		a1.setAnsweredBy("Kiran");

		Answer a2 = new Answer();
		a2.setAnswer("It is a non-invasive framework");
		a2.setAnsweredBy("Pavan");

		Answer a3 = new Answer();
		a3.setAnswer("It is an ORM tool");
		a3.setAnsweredBy("Nag");

//		List<Answer> answers = new ArrayList<Answer>();
//		answers.add(a3);
//		answers.add(a2);
//		answers.add(a1);

		q.setAnswers(new ArrayList<Answer>(Arrays.asList(a1, a2, a3)));

		EntityTransaction transaction = manager.getTransaction();
		manager.persist(q);
		transaction.begin();
		transaction.commit();
	}
}
