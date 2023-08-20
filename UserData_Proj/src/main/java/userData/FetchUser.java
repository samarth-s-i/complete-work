package userData;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUser {
public static void main(String[] args) {
	Session s=new Configuration().configure().buildSessionFactory().openSession();
	String hql="select u from User u";
	Query<User> q=s.createQuery(hql);
	List<User> users=q.getResultList();
	for(User u:users)
		System.out.println(u);
}
}
