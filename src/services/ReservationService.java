package services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.HistoriaRezerwacji;
import repository.HistoryRepository;

public class ReservationService
{
	HistoryRepository repository = new HistoryRepository();
	
	public boolean ReserveRoom(int userId, int roomId, String dateFrom, String dateTo)
	{
		Date dataOd;
		Date dataDo;
		HistoriaRezerwacji rezerwacja = new HistoriaRezerwacji();
			
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try{
			dataOd = format.parse(dateFrom);
			dataDo = format.parse(dateTo);
		}
		catch(ParseException ex){
			System.out.println("nie udalo sie!\r\n" + ex.getMessage());
			return false;
		}
		
		rezerwacja.setPokoj_Id(roomId);
		rezerwacja.setUzytkownik_Id(userId);
		rezerwacja.setCzyAnulowano(false);
		rezerwacja.setDataDo(dataDo);
		rezerwacja.setDataOd(dataOd);
		return repository.reserveRoom(rezerwacja);
	}
}
