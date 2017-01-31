package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Uzytkownik")
public class Uzytkownik{

	@Id 
	@GeneratedValue
	private Integer id;
	
	@Column(name = "Login")
	private String login;
	
	@Column(name = "Haslo")
	private String haslo;
	
	public Uzytkownik() {}

	public Uzytkownik(String login, String haslo) {
		this.login = login;
		this.haslo = haslo;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

}
