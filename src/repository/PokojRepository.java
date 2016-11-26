package repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Pokoj;

public class PokojRepository extends BaseRepository {
	ArrayList<Pokoj> list = new ArrayList<Pokoj>();

	public ArrayList<Pokoj> getRooms(String price){
		
		
		Session session = openConnection();
		Transaction t = session.beginTransaction();
		//Uzytkownik uzytkownik = (Uzytkownik)session.get(Uzytkownik.class, new String(user)); // tu gdzie integer dajemy numer id wiersza
		
		String hql = "FROM model.Pokoj";
		Query query = session.createQuery(hql);
		List<Pokoj> results = query.list();
		
		for(int i = 0; i < results.size(); i++){			

			switch(price)
			{
				case "ponizej 200zl":
					
					if(results.get(i).getCena() < 200)
					{
						addRoom(results.get(i));
					}
					
					break;
				case "wszystkie":
					addRoom(results.get(i));
					break;
			}
			
			
		}

		t.commit();
		session.close();
		
		return list;
	}
	
	private void addRoom(Pokoj pokoj)
	{
		Pokoj nowyPokoj = new Pokoj();
		
		int id = pokoj.getId();
		int numerPokoju = pokoj.getNumerPokoju();
		int standard = pokoj.getStandard();
		int iloscOsob = pokoj.getStandard();
		float cena = pokoj.getCena();
		
		nowyPokoj.setCena(cena);
		nowyPokoj.setIloscOsob(iloscOsob);
		nowyPokoj.setNumerPokoju(numerPokoju);
		nowyPokoj.setId(id);
		nowyPokoj.setStandard(standard);
		
		list.add(pokoj);
	}
}
