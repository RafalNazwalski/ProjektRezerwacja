package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Rola")
public class Rola implements java.io.Serializable {

	private static final long serialVersionUID = 1813550944244328494L;

	@Id
	private Integer id;
	private String nazwa;

	public Rola() {
	}

	public Rola(String nazwa) {
		this.nazwa = nazwa;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

}
