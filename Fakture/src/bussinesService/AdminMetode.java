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
	
	public boolean azurirajEmail(User user, String noviMail) {
		user.setUserName(noviMail);
		
		Session session = sf.openSession();
		try {
			session.beginTransaction();
				session.update(user);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	}
	

	public User vratiUseraPoMailu(String userName) {

		Session session = sf.openSession();
		try {
			session.beginTransaction();
				Query query = session.createQuery("FROM User WHERE userName = :userName ");
				query.setParameter("userName", userName);
				List<User> users = (List<User>) query.getResultList();
				User user =  users.get(0);
					if(user != null) {
						session.getTransaction().commit();
						return user;
					}else {
						session.getTransaction().commit();
						return null;
					}
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public boolean aktivirajUsera(String userName) {

		Session session = sf.openSession();
		try {
			session.beginTransaction();
				Query query = session.createQuery("FROM User WHERE userName = :userName ");
				query.setParameter("userName", userName);
				List<User> users = (List<User>) query.getResultList();
				User user =  users.get(0);
					if(user != null) {
						user.setAktivanUser(true);
						session.update(user);
						session.getTransaction().commit();
						return true;
					}else {
						session.getTransaction().commit();
						return false;
					}
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	}
	
	
	
	
	
	
}
