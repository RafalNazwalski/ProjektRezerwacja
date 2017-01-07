package repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Uzytkownik;

public class UzytkownikRepository extends BaseRepository {

	public Uzytkownik getUserFromDatabase(String login, String haslo){
		
		Session session = openConnection();
		Transaction t = session.beginTransaction();
		
		String hql = "FROM model.Uzytkownik WHERE login = :login AND haslo = :haslo";
		Query query = session.createQuery(hql);
		query.setParameter("login", login);
		query.setParameter("haslo", haslo);
		List<Uzytkownik> results = query.list();
		t.commit();
		session.close();
		
		for(Uzytkownik user : results)
		{
			if(login.equals(results.get(0).getLogin()) && haslo.equals(results.get(0).getHaslo()))
			{
				return user;
			}
		}
		
		return null;
	}
}
