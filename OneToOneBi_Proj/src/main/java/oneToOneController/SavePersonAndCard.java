package oneToOneController;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import oneToOneDTO.PanCard;
import oneToOneDTO.Person;

public class SavePersonAndCard {

	public static void main(String[] args) {
		Person p = new Person();
		p.setName("ABC");
		p.setPhone(777);
		p.setAge(24);

		PanCard card = new PanCard();
		card.setNumber("1wennasj238l");
		card.setDate(LocalDate.parse("1998-01-01"));
		card.setPincode(123456);
		card.setP(p);
		p.setCard(card);// Assigning PanCard for Person
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(p);
		transaction.begin();
		transaction.commit();
	}
}