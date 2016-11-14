package repository;

import java.util.List;

import model.Uzytkownik;

public class UzytkownikRepository extends BaseRepository {

	public boolean getUserFromDatabase(String login, String haslo){
		
		openConnection();

		List<Uzytkownik> usersList = session.createQuery(String.format("From Uzytkownik where login = 'uzytkownik'", login, haslo )).list();
		
		closeConnection();
		
		if(usersList.isEmpty()){
			return false;
		}
		else{
			return true;
		}
	}
}
