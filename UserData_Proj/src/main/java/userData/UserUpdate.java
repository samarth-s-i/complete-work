package userData;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserUpdate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the id to update the records: ");
		int id = sc.nextInt();
		System.out.println("Enter the name, phone and the password to be updated: ");
		String name = sc.nextLine();
		name = sc.nextLine();
		long phone = sc.nextLong();
		String password = sc.next();
		User u = new User();
		u.setId(id);
		u.setName(name);
		u.setPhone(phone);
		u.setPassword(password);
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		try {
			s.update(u);
			t.commit();
			System.out.println("Data is updated");
		}catch(Exception e) {
			System.err.println("You have entered an invalid id!");
		}
	}

}
