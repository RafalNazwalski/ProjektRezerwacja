package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import model.Pokoj;
import services.MainWindowService;

public class MainWindowController implements Initializable {
	
	@FXML
	Label LblUzytkownik;
	
	@FXML
	GridPane MainPanel;
	
	private MainWindowService mainWindowService = new MainWindowService();
	
	public void setUser(String user){
		LblUzytkownik.setText(user);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		SetPropertiesForMainPanel();
		
		mainWindowService.displayAllUsers();
		
		int rowNumber = 0;
		
		for(Pokoj pokoj : mainWindowService.displayAllUsers())
		{
			addRoomRectangle(pokoj, rowNumber);
			rowNumber++;
		}
	}
	
	private void addRoomRectangle(Pokoj pokoj, int rowNumber){
		GridPane pane = new GridPane();
		Insets insets = new Insets(5,5,5,5);
		Insets margin = new Insets(5, 0, 0, 0);
		
		pane.setMaxHeight(50);
		pane.setMinWidth(700);
		pane.setPadding(insets);
		pane.setStyle("-fx-border: 5px solid black;");
		pane.getColumnConstraints().add(new ColumnConstraints(150));
		pane.getColumnConstraints().add(new ColumnConstraints(150));
		pane.getColumnConstraints().add(new ColumnConstraints(150));
		pane.getColumnConstraints().add(new ColumnConstraints(150));
		pane.getColumnConstraints().add(new ColumnConstraints(100));
		
		pane.setStyle("-fx-background-color:lightblue;");
		
		String numerPokoju = "Numer pokoju: " +  String.valueOf(pokoj.getNumerPokoju());
		String iloscOsob = "Ilosc osob: " + String.valueOf(pokoj.getIloscOsob());
		String komfort = "Komfort: " + String.valueOf(pokoj.getStandard());
		String cena = "Cena: " + String.valueOf(pokoj.getCena()) + ",-";
		
		Label lblNumerPokoju = new Label();
		lblNumerPokoju.setText(numerPokoju);
		lblNumerPokoju.setStyle("-fx-font-family: Arial;");
		//lblNumerPokoju.setStyle("-fx-font-size:20px; color:green; -fx-font-family:Arial;");
		
		Label lblIloscOsob = new Label();
		lblIloscOsob.setText(iloscOsob);
		
		Label lblKomfort = new Label();
		lblKomfort.setText(komfort);
		
		Label lblCena = new Label();
		lblCena.setText(cena);
		
		Button detailsButton = new Button();
		detailsButton.setText("Szczegoly");
		
		pane.add(lblNumerPokoju, 0, 0);
		pane.add(lblIloscOsob, 1, 0);
		pane.add(lblKomfort, 2, 0);
		pane.add(lblCena, 3, 0);
		pane.add(detailsButton, 4, 0);
		
		MainPanel.add(pane, 0, rowNumber);
		MainPanel.setMargin(pane, margin);
	}
	
	private void SetPropertiesForMainPanel()
	{
		Insets insets = new Insets(10, 50, 0, 50);
		MainPanel.setPadding(insets);
	}
}
