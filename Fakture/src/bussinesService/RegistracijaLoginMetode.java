package bussinesService;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Adresa;
import model.User;

public class RegistracijaLoginMetode {
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public boolean upisiUseraUBazu(String userName, String password,String imeUsera, String prezimeUsera, String imeFirme, String PIB, String maticniBrojFirme,String drzava,String grad, String ulica, String postanskiBroj ) {
		
		Adresa adresa = new Adresa();
			adresa.setDrzava(drzava);
			adresa.setGrad(grad);
			adresa.setUlica(ulica);
			adresa.setPostanskiBroj(postanskiBroj);
			
		User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setImeUsera(prezimeUsera);
			user.setPrezimeUsera(prezimeUsera);
			user.setImeFirme(imeFirme);
			user.setPIB(PIB);
			user.setMaticniBrojFirme(maticniBrojFirme);
			user.setAdresa(adresa);
			
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
	
	
	
	
	
}
