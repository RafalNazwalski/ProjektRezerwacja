package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Pokoj;
import services.MainWindowService;

public class MainWindowController implements Initializable {
	
	@FXML
	Label LblUzytkownik;
	
	@FXML
	GridPane MainPanel;
	
	@FXML
	ComboBox<String> DDCena;
	
	@FXML
	ComboBox<String> DDIloscOsob;
	
	@FXML
	ComboBox<String> DDStandard;
	
	@FXML
	Button historiaBTN;
	
	private MainWindowService mainWindowService = new MainWindowService();
	
	public void setUser(String user){
		LblUzytkownik.setText(user);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		SetPropertiesForMainPanel();
		
		displayRooms("wszystkie");
		fillDropdowns();
		//setActionEventToDropDowns();
	}
	
	private void displayRooms(String cena){
		int rowNumber = 0;
		
		ArrayList<Pokoj> pokoje = mainWindowService.displayRooms(cena);
		
		for(Pokoj pokoj : pokoje)
		{
			addRoomRectangle(pokoj, rowNumber);
			rowNumber++;
		}
	}
	
	private void setActionEventToDropDowns(){
		DDCena.valueProperty().addListener(new ChangeListener<String>(){

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				
				displayRooms(newValue);
			}
		});
	}
	
	private void fillDropdowns(){
		
		ObservableList<String> cena = 
			    FXCollections.observableArrayList(
			        "Ponizej 200",
			        "Pomiedzy 200 a 400",
			        "Powyzej 400"
			    );
		DDCena.setItems(cena);
		
		
		ObservableList<String> iloscOsob = 
			    FXCollections.observableArrayList(
			        "Ilosc osob",
			    	"2 osobowy",
			        "pomiedzy 2 a 3",
			        "4 i wiecej"
			    );
		DDIloscOsob.setItems(iloscOsob);
		
		ObservableList<String> standard = 
			    FXCollections.observableArrayList(
			        "Standard",
			    	"Zwykly",
			        "Podwyzszony",
			        "Apartament"
			    );
		DDStandard.setItems(standard);
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
		detailsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try {
					wyswietlOknoSzczegolow(event, pokoj);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
		
		pane.add(lblNumerPokoju, 0, 0);
		pane.add(lblIloscOsob, 1, 0);
		pane.add(lblKomfort, 2, 0);
		pane.add(lblCena, 3, 0);
		pane.add(detailsButton, 4, 0);
		
		MainPanel.add(pane, 0, rowNumber);
		GridPane.setMargin(pane, margin);
	}

	
	private void wyswietlOknoSzczegolow(ActionEvent event, Pokoj pokoj) throws IOException{
		
		FXMLLoader detailsWindow = new FXMLLoader();
		Pane root = detailsWindow.load(getClass().getClassLoader().getResource("application/RoomDetailsWindow.fxml").openStream());
		RoomDetailsWindowController roomDetailsWindowController = (RoomDetailsWindowController)detailsWindow.getController();
		roomDetailsWindowController.setPokoj(pokoj);
		Scene scene = new Scene(root);
		Stage stage =  (Stage) ((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private void wyswietlHistoryWindow(ActionEvent event) throws IOException{
		FXMLLoader wyswietlHistoryWindow = new FXMLLoader();
		Pane root = wyswietlHistoryWindow.load(getClass().getClassLoader().getResource("application/HistoryClientWindow.fxml").openStream());
		//HistoryWindowController historyWindowController = (HistoryWindowController)wyswietlHistoryWindow.getController();
		Scene HistoryWindowScene = new Scene(root);
		Stage stage =  (Stage) ((Node)event.getSource()).getScene().getWindow();
		stage.setScene(HistoryWindowScene);
		stage.show();
	}
	
	private void SetPropertiesForMainPanel()
	{
		Insets insets = new Insets(10, 50, 0, 50);
		MainPanel.setPadding(insets);
	}
}
