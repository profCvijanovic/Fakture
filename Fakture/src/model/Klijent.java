package model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
@Entity
public class Klijent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int klijentId;
	private String imeFirme;
	private String PIB;
	private String maticniBrojFirme;
	@Embedded
	private Adresa adresa;
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	private Firma firma;
	
	public int getKlijentId() {
		return klijentId;
	}
	public void setKlijentId(int klijentId) {
		this.klijentId = klijentId;
	}
	public String getImeFirme() {
		return imeFirme;
	}
	public void setImeFirme(String imeFirme) {
		this.imeFirme = imeFirme;
	}
	public String getPIB() {
		return PIB;
	}
	public void setPIB(String pIB) {
		PIB = pIB;
	}
	public String getMaticniBrojFirme() {
		return maticniBrojFirme;
	}
	public void setMaticniBrojFirme(String maticniBrojFirme) {
		this.maticniBrojFirme = maticniBrojFirme;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	public Firma getFirma() {
		return firma;
	}
	public void setFirma(Firma firma) {
		this.firma = firma;
	}
	
	
}
