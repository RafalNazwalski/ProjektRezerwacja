package controller;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.Pokoj;
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
		if(DatePickerDataOd.getValue().toString() != null
				&& DatePickerDataDo.getValue().toString() != null)
		{
			if(service.ReserveRoom(userId, pokoj.getNumerPokoju(), DatePickerDataOd.getValue().toString(), DatePickerDataDo.getValue().toString()) == true){
				Alert alert = new Alert(AlertType.CONFIRMATION, "Rezerwacja się powiodła!", ButtonType.OK);
				alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				alert.show();
			}
			else{
				Alert alert = new Alert(AlertType.ERROR, "Rezerwacja nieudana!", ButtonType.OK);
				alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				alert.show();
			}
			
		}
	}
}
