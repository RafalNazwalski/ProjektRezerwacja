package repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Uzytkownik;

public class UzytkownikRepository extends BaseRepository {

	public boolean getUserFromDatabase(String login, String haslo){
		
		Session session = openConnection();
		Transaction t = session.beginTransaction();
		//Uzytkownik uzytkownik = (Uzytkownik)session.get(Uzytkownik.class, new String(user)); // tu gdzie integer dajemy numer id wiersza
		
		String hql = "FROM model.Uzytkownik WHERE login = :login AND haslo = :haslo";
		Query query = session.createQuery(hql);
		query.setParameter("login", login);
		query.setParameter("haslo", haslo);
		List<Uzytkownik> results = query.list();
		
		for(int i = 0; i < results.size(); i++){
			System.out.println("Pokazuje login: " + results.get(i).getLogin());
			System.out.println("Pokazuje haslo: "+ results.get(i).getHaslo());
		}

		t.commit();
		session.close();
		
		//closeConnection();
		
		if( !results.isEmpty() && login.equals(results.get(0).getLogin()) && haslo.equals(results.get(0).getHaslo()) ){
			System.out.println("Zwrocilem true");
			return true;
		}
		else{
			return false;			
		}
	}
}
