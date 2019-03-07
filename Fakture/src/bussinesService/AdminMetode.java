package bussinesService;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class AdminMetode {
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public List<User> vratiSveUsere() {

		Session session = sf.openSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("FROM User");
			List<User> users = (List<User>) query.getResultList();
			session.getTransaction().commit();
			return users;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	
	
	
	
}
