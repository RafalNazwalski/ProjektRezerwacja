package model;
// Generated 2016-11-13 14:49:11 by Hibernate Tools 5.2.0.Beta1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HistoriaRezerwacji")
public class HistoriaRezerwacji {

	@Id
	@GeneratedValue
	private int Id;
	
	@Column(name = "DataOd")
	private Date dataOd;
	
	@Column(name = "DataDo")
	private Date dataDo;

	@Column(name = "Uzytkownik_Id")
	private int uzytkownik_Id;
	
	@Column(name = "Pokoj_Id")
	private int pokoj_Id;
	
	@Column(name = "CzyAnulowano")
	private boolean czyAnulowano;

	public HistoriaRezerwacji() {
	}

	public HistoriaRezerwacji (int Id , Date dataOd, Date dataDo, int uzytkownik_Id, int pokoj_Id, boolean czyAnulowano) {
		this.Id = Id;
		this.dataOd = dataOd;
		this.dataDo = dataDo;
		this.uzytkownik_Id = uzytkownik_Id;
		this.pokoj_Id = pokoj_Id;
		this.czyAnulowano = czyAnulowano;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getDataOd() {
		return dataOd;
	}

	public void setDataOd(Date dataOd) {
		this.dataOd = dataOd;
	}

	public Date getDataDo() {
		return dataDo;
	}

	public void setDataDo(Date dataDo) {
		this.dataDo = dataDo;
	}

	public int getUzytkownik_Id() {
		return uzytkownik_Id;
	}

	public void setUzytkownik_Id(int uzytkownik_Id) {
		this.uzytkownik_Id = uzytkownik_Id;
	}

	public int getPokoj_Id() {
		return pokoj_Id;
	}

	public void setPokoj_Id(int pokoj_Id) {
		this.pokoj_Id = pokoj_Id;
	}

	public boolean isCzyAnulowano() {
		return czyAnulowano;
	}

	public void setCzyAnulowano(boolean czyAnulowano) {
		this.czyAnulowano = czyAnulowano;
	}

	
}
