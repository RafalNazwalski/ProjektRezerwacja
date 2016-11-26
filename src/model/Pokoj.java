package model;
// Generated 2016-11-13 14:49:11 by Hibernate Tools 5.2.0.Beta1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pokoj")
public class Pokoj {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "NumerPokoju")
	private int numerPokoju;

	@Column(name = "Cena")
	private float cena;
	
	@Column(name = "CzyZwierzeta")
	private boolean czyZwierzeta;
	
	@Column(name = "CzyPalacy")
	private boolean czyPalacy;
	
	@Column(name = "Standard")
	private int standard;
	
	@Column(name = "IloscOsob")
	private int iloscOsob;

	public Pokoj() {
	}

	public Pokoj(int numerPokoju, float cena, boolean czyZwierzeta, boolean czyPalacy, int standard, int iloscOsob) {
		this.numerPokoju = numerPokoju;
		this.cena = cena;
		this.czyZwierzeta = czyZwierzeta;
		this.czyPalacy = czyPalacy;
		this.standard = standard;
		this.iloscOsob = iloscOsob;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumerPokoju() {
		return this.numerPokoju;
	}

	public void setNumerPokoju(int numerPokoju) {
		this.numerPokoju = numerPokoju;
	}

	public float getCena() {
		return this.cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public boolean isCzyZwierzeta() {
		return this.czyZwierzeta;
	}

	public void setCzyZwierzeta(boolean czyZwierzeta) {
		this.czyZwierzeta = czyZwierzeta;
	}

	public boolean isCzyPalacy() {
		return this.czyPalacy;
	}

	public void setCzyPalacy(boolean czyPalacy) {
		this.czyPalacy = czyPalacy;
	}

	public int getStandard() {
		return this.standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public int getIloscOsob() {
		return this.iloscOsob;
	}

	public void setIloscOsob(int iloscOsob) {
		this.iloscOsob = iloscOsob;
	}

}
