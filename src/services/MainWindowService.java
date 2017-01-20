package services;

import java.util.List;

import model.FilterPrice;
import model.Pokoj;
import repository.PokojRepository;

public class MainWindowService {

	PokojRepository pokojRepository = new PokojRepository();
	
	public List<Pokoj> displayRooms(FilterPrice price){
		return pokojRepository.getRooms(price);
	}
}
