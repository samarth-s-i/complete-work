package org.jsp.EmployeeApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.EmployeeApp.dto.Employee;

@SuppressWarnings("unchecked")
public class EmployeeDao {
	Session s = new Configuration().configure().buildSessionFactory().openSession();

	public Employee saveEmployee(Employee e) {
		Transaction t = s.beginTransaction();
		s.save(e);
		t.commit();
		return e;
	}

	public Employee updateEmployee(Employee e) {
		Transaction t = s.beginTransaction();
		s.update(e);
		t.commit();
		return e;
	}

	public boolean foundOrnot(int id) {
		String hql = "select e from Employee e where e.id=?1";
		Query<Employee> q = s.createQuery(hql);
		q.setParameter(1, id);
		if (q.getResultList().size() != 0) {
			s.clear();
			return true;
		}
		s.clear();
		return false;
	}

	public Employee verifyEmployee(long phone, String password) {
		String hql = "select e from Employee e where e.phone=?1 and e.password=?2";
		Query<Employee> q = s.createQuery(hql);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		List<Employee> li = q.getResultList();
		if (li.size() != 0)
			return li.get(0);
		return null;
	}

	public boolean deleteEmployee(long phone, String password) {
		Employee e = verifyEmployee(phone, password);
		if (e != null) {
			s.delete(e);
			Transaction t = s.beginTransaction();
			t.commit();
			return true;
		}
		return false;
	}

	public List<Employee> viewEmployee() {
		Query<Employee> q = s.createQuery("select e from Employee e");
		return q.getResultList();
	}
}
