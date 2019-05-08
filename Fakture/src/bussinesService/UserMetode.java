package bussinesService;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Adresa;
import model.Firma;
import model.Klijent;
import model.User;

public class UserMetode {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public User vratiUseraPoId(int idUser) {
		Session session = sf.openSession();
		User user = null;
		try {
			session.beginTransaction();
				String hql = "FROM User WHERE userId = :idUser";
				Query query = session.createQuery(hql);
				query.setParameter("idUser", idUser);
				user = (User)query.getResultList().get(0);
			session.getTransaction().commit();
			return user;
		}catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}
	
	public Firma vratiFirmuPoId(int idFirma) {
		Session session = sf.openSession();
		Firma firma = null;
		try {
			session.beginTransaction();
				String hql = "FROM Firma WHERE idFirme = :idFirme";
				Query query = session.createQuery(hql);
				query.setParameter("idFirme", idFirma);
				firma = (Firma)query.getResultList().get(0);
			session.getTransaction().commit();
			return firma;
		}catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}
	
	public Firma vratiFirmuPoImenuFirme(String imeFirme) {
		Session session = sf.openSession();
		Firma firma = null;
		try {
			session.beginTransaction();
				String hql = "FROM Firma WHERE imeFirme = :imeFirme";
				Query query = session.createQuery(hql);
				query.setParameter("imeFirme", imeFirme);
				firma = (Firma)query.getResultList().get(0);
			session.getTransaction().commit();
			return firma;
		}catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}
	
	public List<Firma> vratisveFirmeUsera(int idUser) {
		Session session = sf.openSession();
		User user = vratiUseraPoId(idUser);
		List<Firma> firme = new ArrayList<Firma>();
		try {
			session.beginTransaction();
				String hql = "FROM Firma WHERE user = :user";
				Query query = session.createQuery(hql);
				query.setParameter("user", user);
				firme = query.getResultList();
			session.getTransaction().commit();
			return firme;
		}catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}
	
	public boolean dodajFirmuUBazu(String imeFirme, String pib,String maticniBrojFirme, String drzava, String grad, String ulica, String postanskiBroj, int idUser) {
		
		Adresa adresa = new Adresa();
			adresa.setDrzava(drzava);
			adresa.setGrad(grad);
			adresa.setUlica(ulica);
			adresa.setPostanskiBroj(postanskiBroj);
		
		User user = vratiUseraPoId(idUser);
		
		Firma firma = new Firma();
			firma.setAdresa(adresa);
			firma.setUser(user);
			firma.setImeFirme(imeFirme);
			firma.setPIB(pib);
			firma.setMaticniBrojFirme(maticniBrojFirme);
		
		Session session = sf.openSession();
		try {
			session.beginTransaction();
				session.save(firma);
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}
	
	public Klijent vratiKlijentaPoImenuKlijenta(String imeKlijenta) {
		Session session = sf.openSession();
		Klijent klijent = null;
		try {
			session.beginTransaction();
				String hql = "FROM Klijent WHERE imeFirme = :imeFirme";
				Query query = session.createQuery(hql);
				query.setParameter("imeFirme", imeKlijenta);
				klijent = (Klijent)query.getResultList().get(0);
			session.getTransaction().commit();
			return klijent;
		}catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}
	
	public boolean upisiKlijentaUBazu(String imeFirme, String pib,String maticniBrojFirme, String drzava, String grad, String ulica, String postanskiBroj, int idFirma) {
		
		Adresa adresa = new Adresa();
			adresa.setDrzava(drzava);
			adresa.setGrad(grad);
			adresa.setUlica(ulica);
			adresa.setPostanskiBroj(postanskiBroj);
		
		Firma firma = vratiFirmuPoId(idFirma);
		
		Klijent klijent = new Klijent();
			klijent.setImeFirme(imeFirme);
			klijent.setPIB(pib);
			klijent.setMaticniBrojFirme(maticniBrojFirme);
			klijent.setAdresa(adresa);
			klijent.setFirma(firma);
		
		Session session = sf.openSession();
		try {
			session.beginTransaction();
				session.save(klijent);
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
		
	}
	
	public boolean dodajFirmuUseru(int idUser, String imeFirme) {
		Session session = sf.openSession();
		User user = null;
		List<Firma> listaFirmi = new ArrayList<Firma>();
		Firma firma = vratiFirmuPoImenuFirme(imeFirme);
		try {
			session.beginTransaction();
				String hql = "FROM User WHERE userId = :idUser";
				Query query = session.createQuery(hql);
				query.setParameter("idUser", idUser);
				user = (User)query.getResultList().get(0);
				listaFirmi = user.getFirme();
				listaFirmi.add(firma);
				session.update(user);
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}
	
	public boolean dodajKlijentaFirmi(int idFirme, String imeKlijenta) {
		Session session = sf.openSession();
		Firma firma = null;
		List<Klijent> listaKlijenata = new ArrayList<Klijent>();
		Klijent klijent = vratiKlijentaPoImenuKlijenta(imeKlijenta);
		try {
			session.beginTransaction();
				String hql = "FROM Firma WHERE idFirme = :idFirme";
				Query query = session.createQuery(hql);
				query.setParameter("idFirme", idFirme);
				firma = (Firma)query.getResultList().get(0);
				listaKlijenata = firma.getKlijenti();
				listaKlijenata.add(klijent);
				session.update(firma);
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}
	
	
	
	
	
	
}
