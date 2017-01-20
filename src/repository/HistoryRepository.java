package repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.HistoriaRezerwacji;

public class HistoryRepository extends BaseRepository {

	public boolean reserveRoom(HistoriaRezerwacji rezerwacja){
		
		Session session = openConnection();
		Transaction t = session.beginTransaction();
		try{			
			session.save(rezerwacja);
			t.commit();
			session.close();
		}
		catch(Exception ex){
			System.out.println("nie udalo sie!\r\n" + ex.getMessage());
			return false;
		}
		return true;	
	}
	
	public List<HistoriaRezerwacji> getHistory(int userId){
		
		List<HistoriaRezerwacji> results = null;
		
		Session session = openConnection();
		Transaction t = session.beginTransaction();
		
		String hql = "FROM model.HistoriaRezerwacji WHERE Uzytkownik_Id = :userId";
		Query query = session.createQuery(hql);
		query.setParameter("userId", userId);
		try
		{			
			results  = query.list();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}

		t.commit();
		session.close();
		
		return results;
	}
}
