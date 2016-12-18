package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Pokoj;

public class RoomDetailsWindowController {

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
	
	public void setPokoj(Pokoj pokoj){
		this.pokoj = pokoj;
		numerPokojuLbl.setText(String.valueOf(pokoj.getNumerPokoju()));
		liczbaOsobLbl.setText(String.valueOf(pokoj.getIloscOsob()));
		czyDlaPalacychLbl.setText(String.valueOf(pokoj.isCzyPalacy()));
		czyZeZwierzetamiLbl.setText(String.valueOf(pokoj.isCzyZwierzeta()));
		jakiStandard.setText(String.valueOf(pokoj.getStandard()));
		cena.setText(String.valueOf(pokoj.getCena()));
	}
	
	
}
