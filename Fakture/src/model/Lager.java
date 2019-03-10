package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Lager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lagerId;
	private String sifraProizvoda;
	private String imeProizvoda;
	private double ulaznaCena;
	private double izlaznaCena;
	private int kolicina;
	private double pdv;
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	private Firma firma;
	
	public int getLagerId() {
		return lagerId;
	}
	public void setLagerId(int lagerId) {
		this.lagerId = lagerId;
	}
	public String getSifraProizvoda() {
		return sifraProizvoda;
	}
	public void setSifraProizvoda(String sifraProizvoda) {
		this.sifraProizvoda = sifraProizvoda;
	}
	public String getImeProizvoda() {
		return imeProizvoda;
	}
	public void setImeProizvoda(String imeProizvoda) {
		this.imeProizvoda = imeProizvoda;
	}
	public double getUlaznaCena() {
		return ulaznaCena;
	}
	public void setUlaznaCena(double ulaznaCena) {
		this.ulaznaCena = ulaznaCena;
	}
	public double getIzlaznaCena() {
		return izlaznaCena;
	}
	public void setIzlaznaCena(double izlaznaCena) {
		this.izlaznaCena = izlaznaCena;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public double getPdv() {
		return pdv;
	}
	public void setPdv(double pdv) {
		this.pdv = pdv;
	}
	public Firma getFirma() {
		return firma;
	}
	public void setFirma(Firma firma) {
		this.firma = firma;
	}

}
