package services;

import repository.UzytkownikRepository;

public class LoginService {

	UzytkownikRepository uzytkownikRepository = new UzytkownikRepository();
	
	public boolean UserInDatabase(String login, String haslo){
		return uzytkownikRepository.getUserFromDatabase(login, haslo);		
	}
}
