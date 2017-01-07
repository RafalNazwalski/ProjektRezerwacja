package services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.HistoriaRezerwacji;
import repository.HistoryRepository;

public class HistoryService {

	HistoryRepository repository = new HistoryRepository();
	
	public ObservableList<HistoriaRezerwacji> HistoryList(int userId)
	{
		ObservableList<HistoriaRezerwacji> list = FXCollections.observableArrayList(repository.getHistory(userId));
		
		System.out.println(list.size());
		
		return list;
	}
}
