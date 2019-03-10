package bussinesService;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Firma;
import model.User;

public class RegistracijaLoginMetode {
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Validacija validacija = new Validacija();
	
	public boolean upisiUseraUBazu(String userName, String password,String imeUsera, String prezimeUsera, String kontaktTelefon) {
			
		User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setImeUsera(imeUsera);
			user.setPrezimeUsera(prezimeUsera);
			user.setKontaktTelefon(kontaktTelefon);
		Session session = sf.openSession();
		try {
			session.beginTransaction();
				session.save(user);
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
		
	}
	
	public boolean daLiPostojiUser(String userName) {
		
	Session session = sf.openSession();
	try {
		session.beginTransaction();
			Query query = session.createQuery("FROM User WHERE userName = :userName");
			query.setParameter("userName", userName);
			List <User> users = (List<User>)query.getResultList();
			if(users.size()==1) {
				session.getTransaction().commit();
				return true;
			}else {
				session.getTransaction().commit();
				return false;
			}	
	}catch (Exception e) {
		session.getTransaction().rollback();
		return false;
	}finally {
		session.close();
	}
}

	public User vratiUsera(String userName) {
		
	Session session = sf.openSession();
	try {
		session.beginTransaction();
			Query query = session.createQuery("FROM User WHERE userName = :userName");
			query.setParameter("userName", userName);
			List <User> users = (List<User>)query.getResultList();
			User user = users.get(0);
		session.getTransaction().commit();
		return user;
	}catch (Exception e) {
		session.getTransaction().rollback();
		return null;
	}finally {
		session.close();
	}
}

	public boolean daLiJeDobarPassword(String userName,String passwordSaUlaza) {
		
	Session session = sf.openSession();
	try {
		session.beginTransaction();
			Query query = session.createQuery("FROM User WHERE userName = :userName");
			query.setParameter("userName", userName);
			List <User> users = (List<User>)query.getResultList();
			String passwordIzBaze = users.get(0).getPassword();
			if(passwordIzBaze.equals(passwordSaUlaza)) {
				session.getTransaction().commit();
				return true;
			}else {
				session.getTransaction().commit();
				return false;
			}	
	}catch (Exception e) {
		session.getTransaction().rollback();
		return false;
	}finally {
		session.close();
	}
}
	
	public boolean daLiJeAdmin(String userName, String password) {
		
		String adminUserName = "prof.cvijanovic@gmail.com";
		String adminPassword = "nenadcv17";
		
		Session session = sf.openSession();
		try {
			session.beginTransaction();
				Query query = session.createQuery("FROM User WHERE userName = :userName");
				query.setParameter("userName", userName);
				List <User> users = (List<User>)query.getResultList();
				if(users.get(0).getUserName().equals(adminUserName) && users.get(0).getPassword().equals(validacija.konvertujPasswordUSifru(adminPassword))) {
					session.getTransaction().commit();
					return true;
				}else {
					session.getTransaction().commit();
					return false;
				}	
		}catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}	
	
	public void podesiAktivacijuAdmina(User user) {
		
		Session session = sf.openSession();
		try {
			session.beginTransaction();	
				user.setAktivanUser(true);
				session.update(user);
			session.getTransaction().commit();
			
		}catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}	
	
}
