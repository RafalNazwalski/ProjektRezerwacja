package controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Pokoj;
import repository.HistoryRepository;
import services.ReservationService;

public class RoomDetailsWindowController {

	ReservationService service = new ReservationService();
	
	int roomId;
	int userId;
	
	@FXML
	Button ButtonRezerwacja;
	
	@FXML
	Label numerPokojuLbl;
	
	@FXML
	Label liczbaOsobLbl;
	
	@FXML
	Label czyDlaPalacychLbl;
	
	@FXML
	Label czyZeZwierzetamiLbl;
	
	@FXML
	Label jakiStandard;
	
	@FXML
	Label cena;
	
	@FXML
	TextField TextBoxDataOd;
	
	@FXML
	TextField TextBoxDataDo;
	
	@FXML
	Button anulujBTN;
	
	Pokoj pokoj;
	
	public void setPokoj(Pokoj pokoj, int userId){
		this.pokoj = pokoj;
		this.userId = userId;
		this.roomId = pokoj.getId();
		System.out.println(this.userId);
		numerPokojuLbl.setText(String.valueOf(pokoj.getNumerPokoju()));
		liczbaOsobLbl.setText(String.valueOf(pokoj.getIloscOsob()));
		czyDlaPalacychLbl.setText(String.valueOf(pokoj.isCzyPalacy()));
		czyZeZwierzetamiLbl.setText(String.valueOf(pokoj.isCzyZwierzeta()));
		jakiStandard.setText(String.valueOf(pokoj.getStandard()));
		cena.setText(String.valueOf(pokoj.getCena()));
	}
	
	@FXML
	public void closeWindow(){
		Stage stage = (Stage)anulujBTN.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void reserveRoom()
	{
		String dateFrom = TextBoxDataDo.getText();
		String dateTo = TextBoxDataOd.getText();
		
		if(dateFrom != null && dateTo != null)
		{
			service.ReserveRoom(userId, pokoj.getNumerPokoju(), dateFrom, dateTo);
		}
	}
}
