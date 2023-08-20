package userData;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchPhoneByName {
	public static void main(String[] args) {
		String qry = "select u.phone from User u where u.name=:name";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the user name: ");
		String name = sc.next();
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<Long> q = s.createQuery(qry);
		q.setParameter("name", name);
		List<Long> l = q.getResultList();
		if (l.size() != 0)
			for (Long n : l)
				System.out.println(n);
		else
			System.err.println("No record found!");
	}
}
