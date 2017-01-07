package services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.HistoriaRezerwacji;
import repository.HistoryRepository;

public class ReservationService
{
	HistoryRepository repository = new HistoryRepository();
	
	public void ReserveRoom(int userId, int roomId, String dateFrom, String dateTo)
	{
		Date dataOd;
		Date dataDo;
		HistoriaRezerwacji rezerwacja = new HistoriaRezerwacji();
		
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			dataOd = format.parse(dateFrom);
			dataDo = format.parse(dateTo);
			rezerwacja.setPokoj_Id(roomId);
			rezerwacja.setUzytkownik_Id(userId);
			rezerwacja.setCzyAnulowano(false);
			rezerwacja.setDataDo(dataDo);
			rezerwacja.setDataOd(dataOd);
			repository.reserveRoom(rezerwacja);
		}
		catch(Exception ex)
		{
			System.out.println("nie udalo sie!\r\n" + ex.getMessage());
		}
		
		//catch zbyt ogolny - powinien dotyczyc tylko parsowania i wyswietlic komunikat, ze nie dziala
	}
}
