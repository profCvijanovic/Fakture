package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Firma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFirme;
	private String imeFirme;
	private String PIB;
	private String maticniBrojFirme;
	private boolean aktivnaFirma;
	@Embedded
	private Adresa adresa;
	@Embedded
	private List <ZiroRacun> listaZiroRacuna = new ArrayList<ZiroRacun>();
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	private User user;
	@OneToMany(mappedBy="firma")
	private List<Klijent> klijenti = new ArrayList<Klijent>();
	@OneToMany(mappedBy="firma")
	private List<Lager> proizvodi = new ArrayList<Lager>();
	
	public int getIdFirme() {
		return idFirme;
	}
	public void setIdFirme(int idFirme) {
		this.idFirme = idFirme;
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
	public List<ZiroRacun> getListaZiroRacuna() {
		return listaZiroRacuna;
	}
	public void setListaZiroRacuna(List<ZiroRacun> listaZiroRacuna) {
		this.listaZiroRacuna = listaZiroRacuna;
	}

	public boolean isAktivnaFirma() {
		return aktivnaFirma;
	}
	public void setAktivnaFirma(boolean aktivnaFirma) {
		this.aktivnaFirma = aktivnaFirma;
	}
	public List<Klijent> getKlijenti() {
		return klijenti;
	}
	public void setKlijenti(List<Klijent> klijenti) {
		this.klijenti = klijenti;
	}
	public List<Lager> getProizvodi() {
		return proizvodi;
	}
	public void setProizvodi(List<Lager> proizvodi) {
		this.proizvodi = proizvodi;
	}
	
	
}
