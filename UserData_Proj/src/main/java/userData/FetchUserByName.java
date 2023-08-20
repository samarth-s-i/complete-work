package userData;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUserByName {
	public static void main(String[] args) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		String qry = "select u from User u where u.name=?1";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name to be fetched: ");
		String name = sc.next();
		Query<User> q = s.createQuery(qry);
		q.setParameter(1, name);
		List<User> users = q.getResultList();
		if (users.size() > 0)
			for (User u : users)
				System.out.println("User found! Details of the user-\n\n" + u);
		else
			System.err.println("User not found with the name: "+name);
	}
}
