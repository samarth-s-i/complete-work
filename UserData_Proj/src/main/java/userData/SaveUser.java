package userData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveUser {

	public static void main(String[] args) {
		User u=new User();
		u.setName("ABC");
		u.setPhone(888);
		u.setPassword("a123");
		Configuration cfg=new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		int id=(Integer)s.save(u);
		System.out.println("User saved with id: "+id);
		Transaction t=s.beginTransaction();
		t.commit();
		s.close();
		factory.close();
	}

}
