package controller;

import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.FilterPeople;
import model.FilterPrice;
import model.FilterStandard;
import model.Pokoj;
import services.MainWindowService;

public class MainWindowController implements Initializable {
	
	int userId;
	
	@FXML
	Label LblUzytkownik;
	
	@FXML
	GridPane MainPanel;
	
	@FXML
	ComboBox<FilterPrice> DDCena;
	
	@FXML
	ComboBox<FilterPeople> DDIloscOsob;
	
	@FXML
	ComboBox<FilterStandard> DDStandard;
	
	@FXML
	Button historiaBTN;
	
	@FXML
	Button wylogujBTN;
	
	@FXML
	CheckBox CheckBoxTylkoWolne;
	
	@FXML
	DatePicker DatePickerWolneOd;
	
	@FXML
	DatePicker DatePickerWolneDo;
	
	private MainWindowService mainWindowService = new MainWindowService();
	
	public void setUser(String user, int id){
		LblUzytkownik.setText(user);
		this.userId = id;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		SetPropertiesForMainPanel();
		displayRooms(FilterPrice.WSZYSTKIE, FilterPeople.DOWOLNA, FilterStandard.WSZYSTKIE, false);
		fillDropdowns();
		setActionEventToDropDowns();
	}
	
	private void displayRooms(FilterPrice cena, FilterPeople people, FilterStandard standard, boolean tylkoWolne){
		ClearRooms();
		
		int rowNumber = 0;
		
		Date dataWolneOd = null;
		Date dataWolneDo = null;
		
		if(tylkoWolne == true && DatePickerWolneOd.getValue() != null && DatePickerWolneDo.getValue() != null)
		{
			dataWolneOd = new Date(DatePickerWolneOd.getValue().getYear(), DatePickerWolneOd.getValue().getMonthValue(), DatePickerWolneOd.getValue().getDayOfMonth() );
			dataWolneDo = new Date(DatePickerWolneDo.getValue().getYear(), DatePickerWolneDo.getValue().getMonthValue(), DatePickerWolneDo.getValue().getDayOfMonth());
						
			System.out.println(dataWolneOd);
			System.out.println(dataWolneDo);
		}
		
		List<Pokoj> pokoje = mainWindowService.displayRooms(cena, people, standard, tylkoWolne, dataWolneOd, dataWolneDo);
		
		for(Pokoj pokoj : pokoje)
		{
			addRoomRectangle(pokoj, rowNumber);
			rowNumber++;
		}
	}
	
	private void setActionEventToDropDowns(){
		
		DDCena.setValue(FilterPrice.WSZYSTKIE);
		DDIloscOsob.setValue(FilterPeople.DOWOLNA);
		DDStandard.setValue(FilterStandard.WSZYSTKIE);
		
		DDCena.valueProperty().addListener(new ChangeListener<FilterPrice>(){

			@Override
			public void changed(ObservableValue<? extends FilterPrice> observable, FilterPrice oldValue, FilterPrice newValue) {
				filter();
			}
		});

		DDIloscOsob.valueProperty().addListener(new ChangeListener<FilterPeople>(){

			@Override
			public void changed(ObservableValue<? extends FilterPeople> observable, FilterPeople oldValue, FilterPeople newValue) {
				filter();
			}
		});

		
		DDStandard.valueProperty().addListener(new ChangeListener<FilterStandard>(){

			@Override
			public void changed(ObservableValue<? extends FilterStandard> observable, FilterStandard oldValue, FilterStandard newValue) {
				filter();
			}
		});
	}
	
	@FXML
	private void filter(){
		FilterPrice price = DDCena.getValue();
		FilterPeople people = DDIloscOsob.getValue();
		FilterStandard standard = DDStandard.getValue();
		displayRooms(price, people, standard, CheckBoxTylkoWolne.isSelected());
	}
	
	private void fillDropdowns(){
		
		ObservableList<FilterPrice> cena = 
			    FXCollections.observableArrayList(
		    		FilterPrice.WSZYSTKIE,
			    	FilterPrice.PONIZEJ200,
			    	FilterPrice.OD200DO400,
			    	FilterPrice.POWYZEJ400
			    );
		DDCena.setItems(cena);
		
		ObservableList<FilterPeople> liczbaOsob = 
			    FXCollections.observableArrayList(
			    	FilterPeople.DOWOLNA,
		    		FilterPeople.JEDNOOSOBOWY,
			    	FilterPeople.DWULUBTRZYOS,
			    	FilterPeople.POWYZEJ3OS
			    );
		DDIloscOsob.setItems(liczbaOsob);

		ObservableList<FilterStandard> standard =
				FXCollections.observableArrayList(
						FilterStandard.WSZYSTKIE,
						FilterStandard.ZWYKLY,
						FilterStandard.PODWYZSZONY,
						FilterStandard.APARTAMENT
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
		String iloscOsob = "Ilość osób: " + String.valueOf(pokoj.getIloscOsob());
		String komfort = "Komfort: ";
		komfort += pokoj.getStandard() == 1 ?  "Zwykły" : pokoj.getStandard() == 2 ? "Podwyższony" : "Apartament" ;
		String cena = "Cena: " + String.valueOf(pokoj.getCena()) + ",-";
		
		Label lblNumerPokoju = new Label();
		lblNumerPokoju.setText(numerPokoju);
		lblNumerPokoju.setStyle("-fx-font-family: Arial;");
		
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
		roomDetailsWindowController.setPokoj(pokoj, userId);
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.showAndWait();
	}
	
	@FXML
	private void wyswietlHistoryWindow(ActionEvent event) throws IOException{
		FXMLLoader wyswietlHistoryWindow = new FXMLLoader();
		Pane root = wyswietlHistoryWindow.load(getClass().getClassLoader().getResource("application/HistoryClientWindow.fxml").openStream());
		HistoryWindowController historyWindowController = (HistoryWindowController)wyswietlHistoryWindow.getController();
		historyWindowController.LoadHistory(this.userId);
		Scene HistoryWindowScene = new Scene(root);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(HistoryWindowScene);
		stage.showAndWait();
	}
	
	@FXML
	private void wyswietlOknoLogowania(ActionEvent event) throws IOException{
		FXMLLoader mainWindow = new FXMLLoader();
		Pane root = mainWindow.load(getClass().getClassLoader().getResource("application/LoginWindow.fxml").openStream());
		
		Scene loginWindowScene = new Scene(root);
		Stage stage =  (Stage) ((Node)event.getSource()).getScene().getWindow();
		stage.setScene(loginWindowScene);
		stage.show();
	}
	
	private void SetPropertiesForMainPanel(){
		Insets insets = new Insets(10, 50, 0, 50);
		MainPanel.setPadding(insets);
	}
	
	private void ClearRooms(){
		MainPanel.getChildren().toArray();
		
		for(Object node : MainPanel.getChildren().toArray()){
			if(node.getClass() == GridPane.class){
				GridPane pane = (GridPane)node;
				pane.setVisible(false);
			}
		}
		//nagrac filmik na koniec prezentacja max 5 min
	}
}
