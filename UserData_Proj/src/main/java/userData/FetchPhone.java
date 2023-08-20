package userData;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchPhone {
	public static void main(String[] args) {
		String qry="select u.phone from User u";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<Long> q=s.createQuery(qry);
		List<Long> l=q.getResultList();
		if(l.size()!=0)
			for(Long n:l)
				System.out.println(n);
	}
}
