package userData;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UserLoginValidation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the phone number: ");
		long ph = sc.nextLong();
		System.out.print("Enter the password: ");
		String password = sc.next();
		String qry = "select u from User u where phone=?1 and password=?2";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q = s.createQuery(qry);
		q.setParameter(1, ph);
		q.setParameter(2, password);
		List<User> u = q.getResultList();
		if (u.size() != 0) {
			System.out.println("\n\n\n--------------User login succesful------------\n\n\n User details-\n\n");
			System.out.println("ID: "+u.get(0).getId());
			System.out.println("Name: "+u.get(0).getName());
			System.out.println("Password: "+u.get(0).getPhone());
		}
		else
			System.err.println("----------------------Invalid phone number or password------------------");
	}

}
