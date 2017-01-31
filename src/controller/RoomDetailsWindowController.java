package controller;


import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.HistoriaRezerwacji;
import model.Pokoj;
import model.ReserveResult;
import repository.HistoryRepository;
import services.ReservationService;

public class RoomDetailsWindowController {

	ReservationService service = new ReservationService();
	
	
	int roomId;
	int userId;
	
	@FXML
	DatePicker DatePickerDataOd;
	
	@FXML
	DatePicker DatePickerDataDo;
	
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
	Button anulujBTN;
	
	Pokoj pokoj;
	
	public void setPokoj(Pokoj pokoj, int userId){
		this.pokoj = pokoj;
		this.userId = userId;
		this.roomId = pokoj.getId();
		numerPokojuLbl.setText(String.valueOf(pokoj.getNumerPokoju()));
		liczbaOsobLbl.setText(String.valueOf(pokoj.getIloscOsob()));
		czyDlaPalacychLbl.setText(String.valueOf(pokoj.isCzyPalacy() == true ? "Tak" : "Nie"));
		czyZeZwierzetamiLbl.setText(String.valueOf(pokoj.isCzyZwierzeta() == true ? "Tak" : "Nie"));
		jakiStandard.setText(String.valueOf(pokoj.getStandard() == 1 ?  "Zwykły" : pokoj.getStandard() == 2 ? "Podwyższony" : "Apartament"));
		cena.setText(String.valueOf(pokoj.getCena()) + ",-");
	}
	
	@FXML
	public void closeWindow(){
		Stage stage = (Stage)anulujBTN.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void reserveRoom()
	{	
		if(DatePickerDataOd.getValue().toString() != null
				&& DatePickerDataDo.getValue().toString() != null)
		{
			ReserveResult result = service.ReserveRoom(userId, pokoj.getNumerPokoju(), DatePickerDataOd.getValue().toString(), DatePickerDataDo.getValue().toString());

			Alert alert = new Alert(AlertType.ERROR, null, ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.setContentText(result.toString());
			
			if(result ==  ReserveResult.OK)
			{
				alert.setAlertType(AlertType.CONFIRMATION);
			}
			
			alert.show();
	}
	}
}
