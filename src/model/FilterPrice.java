package model;

public enum FilterPrice {
	
	PONIZEJ200("Ponizej 200"),
	OD200DO400("Pomiedzy 200 a 400"),
	POWYZEJ400("Powyzej 400");

	private String label;
	
	FilterPrice(String name)
	{
		this.label = name;
	}
	
	public String toString(){
		return label;
	}
	
}
