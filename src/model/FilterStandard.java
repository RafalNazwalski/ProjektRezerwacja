package model;

public enum FilterStandard {

	WSZYSTKIE("Wszystkie"),
	ZWYKLY("Zwykly"),
	PODWYZSZONY("Podwyzszony"),
	APARTAMENT("Apartament");
	
	private String label;
	
	FilterStandard(String name)
	{
		this.label = name;
	}
	
	public String toString(){
		return label;
	}
	
}
