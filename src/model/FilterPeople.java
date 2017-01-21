package model;

public enum FilterPeople {

	DOWOLNA("Dowolna"),
	JEDNOOSOBOWY("1 Osobowy"),
	DWULUBTRZYOS("2 lub 3 os."),
	POWYZEJ3OS("Pow 3 os.");
	
	private String label;
	
	FilterPeople(String name){
		this.label = name;
	}
	
	public String toString(){
		return label;
	}
}
