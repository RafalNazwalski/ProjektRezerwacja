package model;

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
	private Integer Id;
	
	@Column(name = "DataOd")
	private Date dataOd;
	
	@Column(name = "DataDo")
	private Date dataDo;

	@Column(name = "Uzytkownik_Id")
	private Integer uzytkownik_Id;
	
	@Column(name = "Pokoj_Id")
	private Integer pokoj_Id;
	
	@Column(name = "CzyAnulowano")
	private boolean czyAnulowano;

	public HistoriaRezerwacji() {
	}

	public HistoriaRezerwacji (Integer Id , Date dataOd, Date dataDo, Integer uzytkownik_Id, Integer pokoj_Id, boolean czyAnulowano) {
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

	public void setId(Integer id) {
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

	public void setUzytkownik_Id(Integer uzytkownik_Id) {
		this.uzytkownik_Id = uzytkownik_Id;
	}

	public int getPokoj_Id() {
		return pokoj_Id;
	}

	public void setPokoj_Id(Integer pokoj_Id) {
		this.pokoj_Id = pokoj_Id;
	}

	public boolean isCzyAnulowano() {
		return czyAnulowano;
	}

	public void setCzyAnulowano(boolean czyAnulowano) {
		this.czyAnulowano = czyAnulowano;
	}
}
