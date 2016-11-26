package repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Pokoj;

public class PokojRepository extends BaseRepository {

	public ArrayList<Pokoj> getAllRooms(){
		
		ArrayList<Pokoj> list = new ArrayList<Pokoj>();
		
		Session session = openConnection();
		Transaction t = session.beginTransaction();
		//Uzytkownik uzytkownik = (Uzytkownik)session.get(Uzytkownik.class, new String(user)); // tu gdzie integer dajemy numer id wiersza
		
		String hql = "FROM model.Pokoj";
		Query query = session.createQuery(hql);
		List<Pokoj> results = query.list();
		
		for(int i = 0; i < results.size(); i++){
			
			int id = results.get(i).getId();
			int numerPokoju = results.get(i).getNumerPokoju();
			int standard = results.get(i).getStandard();
			int iloscOsob = results.get(i).getStandard();
			float cena = results.get(i).getCena();
			
			Pokoj pokoj = new Pokoj();
			
			pokoj.setCena(cena);
			pokoj.setIloscOsob(iloscOsob);
			pokoj.setNumerPokoju(numerPokoju);
			pokoj.setId(id);
			pokoj.setStandard(standard);
			
			list.add(pokoj);
		}

		t.commit();
		session.close();
		
		return list;
	}
}
