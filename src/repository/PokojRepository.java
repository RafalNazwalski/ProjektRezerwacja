package repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.FilterPeople;
import model.FilterPrice;
import model.FilterStandard;
import model.Pokoj;

public class PokojRepository extends BaseRepository {

	public List<Pokoj> getRooms(FilterPrice price, FilterPeople people, FilterStandard standard) {

		Session session = openConnection();
		Transaction t = session.beginTransaction();
		String hql = "FROM model.Pokoj";
		Query query = session.createQuery(hql);
		List<Pokoj> results = query.list();

		switch (price) {
			case PONIZEJ200:
				results.removeIf(x -> x.getCena() >= 200);
				break;
			case OD200DO400:
				results.removeIf(x -> x.getCena() < 200 || x.getCena() > 400);
				break;
			case POWYZEJ400:
				results.removeIf(x -> x.getCena() < 400);
				break;
			default:
				break;
		}

		switch (people) {
		case JEDNOOSOBOWY:
			results.removeIf(x -> x.getIloscOsob() != 1 );
			break;
		case DWULUBTRZYOS:
			results.removeIf(x -> x.getIloscOsob() < 2 || x.getIloscOsob() > 3);
			break;
		case POWYZEJ3OS:
			results.removeIf(x -> x.getIloscOsob() <= 3);
			break;
		default:
			break;
		}
		
		switch (standard) {
		case ZWYKLY:
			results.removeIf(x -> x.getStandard() != 1);
			break;
		case PODWYZSZONY:
			results.removeIf(x -> x.getStandard() < 2 || x.getStandard() > 2);
			break;
		case APARTAMENT:
			results.removeIf(x -> x.getStandard() < 3);
			break;
		default:
			break;
	}
		
		t.commit();
		session.close();

		return results;
	}

	private void addRoom(Pokoj pokoj) {
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
