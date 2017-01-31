package model;

public enum ReserveResult {

	OK("Rezerwacja powiodła!"),
	ERROR("Rezerwacja się nie powiodła!"),
	ZAJETY("Pokoj jest zajety!");
	
	private String label;
	
	ReserveResult(String name){
		this.label = name;
	}
	
	public String toString(){
		return label;
	}
}
