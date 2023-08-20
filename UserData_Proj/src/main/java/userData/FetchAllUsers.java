package userData;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchAllUsers {

	public static void main(String[] args) {
		String qry = "select u.name from User u";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<String> q=s.createQuery(qry);
		List<String> u=q.getResultList();
		if(u.size()!=0) {
				System.out.println(u);
		}
	}

}
