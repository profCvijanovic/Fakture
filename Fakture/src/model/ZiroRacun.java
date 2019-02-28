package model;

import javax.persistence.Embeddable;

@Embeddable
public class ZiroRacun {
	
	private String brojZiroRacuna;
	private String banka;
	
	public String getBrojZiroRacuna() {
		return brojZiroRacuna;
	}
	public void setBrojZiroRacuna(String brojZiroRacuna) {
		this.brojZiroRacuna = brojZiroRacuna;
	}
	public String getBanka() {
		return banka;
	}
	public void setBanka(String banka) {
		this.banka = banka;
	}
	
	
}
