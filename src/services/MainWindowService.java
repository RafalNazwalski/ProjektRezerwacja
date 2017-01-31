package services;

import java.util.Date;
import java.util.List;

import model.FilterPeople;
import model.FilterPrice;
import model.FilterStandard;
import model.HistoriaRezerwacji;
import model.Pokoj;
import repository.HistoryRepository;
import repository.PokojRepository;

public class MainWindowService {

	PokojRepository pokojRepository = new PokojRepository();
	HistoryRepository historyRepository = new HistoryRepository();
	
	public List<Pokoj> displayRooms(FilterPrice price, FilterPeople people, FilterStandard standard, boolean tylkoWolne, Date wolneDataOd, Date wolneDataDo){
		List<Pokoj> listaPokoi = pokojRepository.getRooms(price, people, standard);
		
		if(tylkoWolne && wolneDataOd != null && wolneDataDo != null)
		{
			List<HistoriaRezerwacji> listaZajetychPokoi = historyRepository.ZajetePokoje(wolneDataOd, wolneDataDo);
			
			for(HistoriaRezerwacji historia : listaZajetychPokoi)
			{
				listaPokoi.removeIf(x -> x.getNumerPokoju() == historia.getPokoj_Id());
			}
		}
		
		return listaPokoi;
	}
}
