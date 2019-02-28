package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String imeUsera;
	private String prezimeUsera;
	private String imeFirme;
	private String PIB;
	private String maticniBrojFirme;
	@Embedded
	private Adresa adresa;
	@Embedded
	private List <ZiroRacun> listaZiroRacuna = new ArrayList<ZiroRacun>();
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	
	

}
