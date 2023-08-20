package userData;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUserByPhone {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the phone number: ");
		long ph=sc.nextLong();
		String qry="select u from User u where u.phone=:phone";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		q.setParameter("phone", ph);
		List<User> li=q.getResultList();
		if(li.size()!=0)
			for(User u:li)
				System.out.println(u);
		else
			System.err.println("User not found");
	}
}
