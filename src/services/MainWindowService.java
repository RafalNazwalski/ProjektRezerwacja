package services;

import java.util.ArrayList;

import model.FilterPrice;
import model.Pokoj;
import repository.PokojRepository;

public class MainWindowService {

	PokojRepository pokojRepository = new PokojRepository();
	
	public ArrayList<Pokoj> displayRooms(FilterPrice price){
		return pokojRepository.getRooms(price);
	}
}
