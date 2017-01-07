package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.HistoriaRezerwacji;

public class HistoryRepository extends BaseRepository {

	public void reserveRoom(HistoriaRezerwacji rezerwacja){
		
		Session session = openConnection();
		Transaction t = session.beginTransaction();
		
		session.save(rezerwacja);
		
		t.commit();
		session.close();
		
	}	
}
