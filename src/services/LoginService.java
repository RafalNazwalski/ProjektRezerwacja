package services;

import model.Uzytkownik;
import repository.UzytkownikRepository;

public class LoginService {

	UzytkownikRepository uzytkownikRepository = new UzytkownikRepository();
	
	public Uzytkownik getUser(String login, String haslo){
		return uzytkownikRepository.getUserFromDatabase(login, haslo);		
	}
}
