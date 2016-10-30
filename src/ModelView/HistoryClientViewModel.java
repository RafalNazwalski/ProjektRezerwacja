package ModelView;

import java.sql.Date;

public class HistoryClientViewModel {
	
	private Date dataOd;
	private Date dataDo;
	private int numerPokoju;
	private int cena;
	
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
	public int getNumerPokoju() {
		return numerPokoju;
	}
	public void setNumerPokoju(int numerPokoju) {
		this.numerPokoju = numerPokoju;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	
}
