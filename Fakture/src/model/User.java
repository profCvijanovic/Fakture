package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String password;
	private String imeUsera;
	private String prezimeUsera;
	private String kontaktTelefon;
	private boolean aktivanUser;
	@OneToMany
	private List<Firma> firme = new ArrayList<Firma>();
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImeUsera() {
		return imeUsera;
	}
	public void setImeUsera(String imeUsera) {
		this.imeUsera = imeUsera;
	}
	public String getPrezimeUsera() {
		return prezimeUsera;
	}
	public void setPrezimeUsera(String prezimeUsera) {
		this.prezimeUsera = prezimeUsera;
	}
	public List<Firma> getFirme() {
		return firme;
	}
	public void setFirme(List<Firma> firme) {
		this.firme = firme;
	}
	public boolean isAktivanUser() {
		return aktivanUser;
	}
	public void setAktivanUser(boolean aktivanUser) {
		this.aktivanUser = aktivanUser;
	}
	public String getKontaktTelefon() {
		return kontaktTelefon;
	}
	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}
	
	
}
