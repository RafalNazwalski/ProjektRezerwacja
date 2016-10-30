package model;




public class Uzytkownik {

	private int Id;
	private String Login;
	private String Haslo;
	private Rola rola;
	private int Rola_Id;
	
	
	public int getRola_Id() {
		return Rola_Id;
	}

	public void setRola_Id(int rola_Id) {
		Rola_Id = rola_Id;
	}

	public Rola getRola() {
		return rola;
	}

	public void setRola(Rola rola) {
		this.rola = rola;
	}

	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	
	public String getLogin() {
		return Login;
	}
	
	public void setLogin(String login) {
		Login = login;
	}
	
	public String getHaslo() {
		return Haslo;
	}
	
	public void setHaslo(String haslo) {
		Haslo = haslo;
	}
	
	
}
