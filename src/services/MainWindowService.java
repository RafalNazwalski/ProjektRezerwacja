package services;

import java.util.ArrayList;

import model.Pokoj;
import repository.PokojRepository;

public class MainWindowService {

	PokojRepository pokojRepository = new PokojRepository();
	
	public ArrayList<Pokoj> displayAllUsers(){
		return pokojRepository.getAllRooms();
	}
}
