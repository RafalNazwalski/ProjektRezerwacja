package repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.FilterPrice;
import model.Pokoj;

public class PokojRepository extends BaseRepository {
	
	public List<Pokoj> getRooms(FilterPrice price){
		
		Session session = openConnection();
		Transaction t = session.beginTransaction();
		String hql = "FROM model.Pokoj";
		Query query = session.createQuery(hql);
		List<Pokoj> results = query.list();
		
		for(int i = 0; i < results.size(); i++){			

			
			//dokonczyc filtry
			switch(price)
			{
				case PONIZEJ200:
					if(results.get(i).getCena() < 200)
					{
						addRoom(results.get(i));
					}
					
					break;
				case WSZYSTKIE:
					addRoom(results.get(i));
					break;
			}
			
			
		}

		t.commit();
		session.close();
		
		return results;
	}
	
	private void addRoom(Pokoj pokoj)
	{
		ArrayList<Pokoj> list = new ArrayList<Pokoj>();	
		
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
