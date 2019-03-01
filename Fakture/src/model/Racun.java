package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Racun {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int racunId;
	private String tipRacuna;
	private int redniBrojRacuna;
	@OneToOne
	private Klijent klijent;
	@OneToOne
	private User user;
	private Date datumIzdavanja;
	private Date datumPrometa;
	private String valuta;
	@OneToMany
	private List<Lager> listaProizvoda = new ArrayList<Lager>();
	private double avansBezPdv;
	private double avansSaPdv;
	private double rabat;
	private double konacnaCenaBezPdv;
	private double konacnaCenaSaPdv;
	
	public int getRacunId() {
		return racunId;
	}
	public void setRacunId(int racunId) {
		this.racunId = racunId;
	}
	public int getRedniBrojRacuna() {
		return redniBrojRacuna;
	}
	public void setRedniBrojRacuna(int redniBrojRacuna) {
		this.redniBrojRacuna = redniBrojRacuna;
	}
	public Klijent getKlijent() {
		return klijent;
	}
	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDatumIzdavanja() {
		return datumIzdavanja;
	}
	public void setDatumIzdavanja(Date datumIzdavanja) {
		this.datumIzdavanja = datumIzdavanja;
	}
	public Date getDatumPrometa() {
		return datumPrometa;
	}
	public void setDatumPrometa(Date datumPrometa) {
		this.datumPrometa = datumPrometa;
	}
	public String getValuta() {
		return valuta;
	}
	public void setValuta(String valuta) {
		this.valuta = valuta;
	}
	public List<Lager> getListaProizvoda() {
		return listaProizvoda;
	}
	public void setListaProizvoda(List<Lager> listaProizvoda) {
		this.listaProizvoda = listaProizvoda;
	}
	public double getAvansBezPdv() {
		return avansBezPdv;
	}
	public void setAvansBezPdv(double avansBezPdv) {
		this.avansBezPdv = avansBezPdv;
	}
	public double getAvansSaPdv() {
		return avansSaPdv;
	}
	public void setAvansSaPdv(double avansSaPdv) {
		this.avansSaPdv = avansSaPdv;
	}
	public double getRabat() {
		return rabat;
	}
	public void setRabat(double rabat) {
		this.rabat = rabat;
	}
	public double getKonacnaCenaBezPdv() {
		return konacnaCenaBezPdv;
	}
	public void setKonacnaCenaBezPdv(double konacnaCenaBezPdv) {
		this.konacnaCenaBezPdv = konacnaCenaBezPdv;
	}
	public double getKonacnaCenaSaPdv() {
		return konacnaCenaSaPdv;
	}
	public void setKonacnaCenaSaPdv(double konacnaCenaSaPdv) {
		this.konacnaCenaSaPdv = konacnaCenaSaPdv;
	}
	public String getTipRacuna() {
		return tipRacuna;
	}
	public void setTipRacuna(String tipRacuna) {
		this.tipRacuna = tipRacuna;
	}
		
}
