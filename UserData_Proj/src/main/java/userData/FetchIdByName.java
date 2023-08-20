package userData;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchIdByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name to fetch IDs: ");
		String name = sc.next();
		String qry = "select u.id from User u where u.name=?1";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<Integer> q=s.createQuery(qry);
		q.setParameter(1, name);
		List<Integer> li=q.getResultList();
		if(li.size()!=0)
			for(Integer i:li)
				System.out.println(i);
		else
			System.err.println("No user found with the name "+name);
	}
}
