package HospitalDto;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import HospitalController.Hospital;

@SuppressWarnings("unchecked")
public class HospitalCRUD {
	static Hospital h = new Hospital();
	static Configuration configuration = new Configuration().configure();
	static SessionFactory factory = configuration.buildSessionFactory();
	static Session session = factory.openSession();
	static Transaction transaction = session.beginTransaction();
	static Scanner sc = new Scanner(System.in);

	public static void saveHospital() {
		System.out.println("\nEnter the hospital details to save the record:-");
		System.out.print("Name: ");
		h.setName(sc.next());
		System.out.print("Founder: ");
		h.setFounder(sc.next());
		System.out.print("GST: ");
		h.setGst(sc.nextLong());
		System.out.print("Year: ");
		h.setYear(sc.nextInt());
		session = factory.openSession();
		int id = (Integer) session.save(h);
		System.out.println("Hospital has been saved with the id: " + id);
		transaction = session.beginTransaction();
		transaction.commit();
		session.close();
	}

	public static void updateHospital() {
		System.out.print("Enter the Hospital id to update:");
		int id = sc.nextInt();
		System.out.println("Enter the name, founder, gst and the year");
		String name = sc.next();
		String founder = sc.next();
		long gst = sc.nextLong();
		int year = sc.nextInt();
		h.setId(id);
		h.setName(name);
		h.setFounder(founder);
		h.setGst(gst);
		h.setYear(year);
		try {
			session.update(h);
			transaction.commit();
			System.out.println("Record has been updated\n");
		} catch (Exception e) {
			System.out.println("Invalid ID\n");
		}
	}

	public static void fetchById() {
		String qry = "select h from Hospital h where h.id=?1";
		System.out.print("Enter the Hospital id to fetch:");
		int id = sc.nextInt();
		Query<Hospital> query = session.createQuery(qry);
		query.setParameter(1, id);
		List<Hospital> hospitals = query.getResultList();
		if (hospitals.size() != 0)
			for (Hospital h : hospitals)
				System.out.println(h);
		else
			System.out.println("No record found\n");
	}

	public static void fetchByFounder() {
		String qry = "select h from Hospital h where h.founder=?1";
		System.out.print("Enter the Hospital founder to fetch:");
		String founder = sc.next();

		Query<Hospital> query = session.createQuery(qry);
		query.setParameter(1, founder);
		List<Hospital> hospitals = query.getResultList();
		if (hospitals.size() != 0)
			for (Hospital h : hospitals)
				System.out.println(h);
		else
			System.out.println("No record found\n");
	}

	public static void fetchByIdAndName() {
		String qry = "select h from Hospital h where h.id=?1 and h.name=?2";
		System.out.print("Enter the Hospital id and name to fetch:");
		int id = sc.nextInt();
		String name = sc.next();
		Query<Hospital> query = session.createQuery(qry);
		query.setParameter(1, id);
		query.setParameter(2, name);
		List<Hospital> hospitals = query.getResultList();
		if (hospitals.size() != 0)
			for (Hospital h : hospitals)
				System.out.println(h);
		else
			System.out.println("No record found\n");
	}

	public static void deleteById() {
		System.out.print("Enter the user id to delete: ");
		int id = sc.nextInt();
		h = session.get(Hospital.class, id);
		if (h != null) {
			session.delete(h);
			transaction.commit();
			System.out.println("Record has been deleted\n");
		} else
			System.err.println("You have entered an invalid id\n");
	}

	public static void deleteByGst() {
		String qry = "select h from Hospital h where h.gst=?1";
		System.out.print("Enter the Hospital gst to delete: ");
		long gst = sc.nextLong();
		Query<Hospital> query = session.createQuery(qry);
		query.setParameter(1, gst);
		try {
			Hospital h = query.getSingleResult();
			int id = h.getId();
			h = session.get(Hospital.class, id);
			session.delete(h);
			transaction.commit();
			System.out.println("Record has been deleted\n");
		} catch (Exception e) {
			System.err.println("You have entered an invalid gst\n");
		}
	}

}
