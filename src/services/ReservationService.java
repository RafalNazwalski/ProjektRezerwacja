package services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.HistoriaRezerwacji;
import model.ReserveResult;
import repository.HistoryRepository;

public class ReservationService
{
	HistoryRepository repository = new HistoryRepository();
	
	public ReserveResult ReserveRoom(int userId, int roomId, String dateFrom, String dateTo)
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
			return ReserveResult.ERROR;
		}

		List<HistoriaRezerwacji> listaZajetychPokoi = repository.ZajetePokoje(dataOd, dataDo);
		
		for (HistoriaRezerwacji historiaRezerwacji : listaZajetychPokoi) {
			System.out.println("Wyswietlam pokojID:" + historiaRezerwacji.getPokoj_Id() + " oraz roomID: " + roomId);
		}
		
		boolean idExists = listaZajetychPokoi.stream()
	            .anyMatch(t -> t.getPokoj_Id() == (roomId) && 
	            (
	            		( dataOd.after( t.getDataOd() )  && dataOd.before(t.getDataDo() ) ) || 
	            		( dataDo.after( t.getDataOd() ) && dataDo.before(t.getDataDo() ) ) ||
	            		( dataOd.equals( t.getDataOd() ) || dataOd.equals( t.getDataDo() ) ) ||
	            		( dataDo.equals( t.getDataDo() ) || dataDo.equals( t.getDataDo() ) )
	            		
	            		));
		
		if(idExists == true){
			return ReserveResult.ZAJETY;
		}
		
		rezerwacja.setPokoj_Id(roomId);
		rezerwacja.setUzytkownik_Id(userId);
		rezerwacja.setCzyAnulowano(false);
		rezerwacja.setDataDo(dataDo);
		rezerwacja.setDataOd(dataOd);
		if(repository.reserveRoom(rezerwacja) == true){
			return ReserveResult.OK;
		}
		
		return ReserveResult.ERROR;
		
	}
}
