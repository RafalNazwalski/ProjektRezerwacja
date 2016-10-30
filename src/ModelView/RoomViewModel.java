package ModelView;

public class RoomViewModel {
	private byte ileOsobWPokoju;
	private boolean czyDlaPalacych;
	private boolean czyZwierzeta;
	private int standard;
	private float cena;
	private int numerPokoju;
	
	public int getIleOsobWPokoju() {
		return ileOsobWPokoju;
	}
	public void setIleOsobWPokoju(byte ileOsobWPokoju) {
		this.ileOsobWPokoju = ileOsobWPokoju;
	}
	public boolean isCzyDlaPajacych() {
		return czyDlaPalacych;
	}
	public void setCzyDlaPajacych(boolean czyDlaPajacych) {
		this.czyDlaPalacych = czyDlaPajacych;
	}
	public boolean isCzyZwierzeta() {
		return czyZwierzeta;
	}
	public void setCzyZwierzeta(boolean czyZwierzeta) {
		this.czyZwierzeta = czyZwierzeta;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(float cena) {
		this.cena = cena;
	}
	public int getNumerPokoju() {
		return numerPokoju;
	}
	public void setNumerPokoju(int numerPokoju) {
		this.numerPokoju = numerPokoju;
	}
}


