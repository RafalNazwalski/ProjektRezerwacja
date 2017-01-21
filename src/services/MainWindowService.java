package services;

import java.util.List;

import model.FilterPeople;
import model.FilterPrice;
import model.FilterStandard;
import model.Pokoj;
import repository.PokojRepository;

public class MainWindowService {

	PokojRepository pokojRepository = new PokojRepository();
	
	public List<Pokoj> displayRooms(FilterPrice price, FilterPeople people, FilterStandard standard){
		return pokojRepository.getRooms(price, people, standard);
	}
}
