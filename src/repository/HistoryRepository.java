package repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.HistoriaRezerwacji;
import model.Pokoj;

public class HistoryRepository extends BaseRepository {

	public void reserveRoom(HistoriaRezerwacji rezerwacja){
		
		Session session = openConnection();
		Transaction t = session.beginTransaction();
		
		session.save(rezerwacja);
		
		t.commit();
		session.close();
		
	}
	
	public ArrayList<HistoriaRezerwacji> getHistory(int userId){
		
		
		ArrayList<HistoriaRezerwacji> list = new ArrayList<HistoriaRezerwacji>();
		
		Session session = openConnection();
		Transaction t = session.beginTransaction();
		
		String hql = "FROM model.HistoriaRezerwacji WHERE Uzytkownik_Id = :userId";
		Query query = session.createQuery(hql);
		query.setParameter("userId", userId);
		try
		{
			List<HistoriaRezerwacji> results = query.list();
			
			for(HistoriaRezerwacji historia : results){			
				list.add(historia);
			}			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		

		t.commit();
		session.close();
		
		return list;
	}
}
