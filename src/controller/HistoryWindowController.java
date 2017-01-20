package controller;

import java.util.Date;

import application.Main;
import javafx.fxml.FXML;
import javafx.print.PrinterJob;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import model.HistoriaRezerwacji;
import services.HistoryService;

public class HistoryWindowController {

	HistoryService service = new HistoryService();
	
	@FXML
	TableView<HistoriaRezerwacji> table;
	
	@FXML
	Button ButtonSave;
	
	public void LoadHistory(int userId)
	{
		CreateTable();
		
		table.setItems(service.HistoryList(userId));
	}
	
	@FXML
	public void printHistory(){
		Main main = new Main();
		
		boolean success = false;
		PrinterJob printJob = PrinterJob.createPrinterJob();
		boolean CzyDrukowac = printJob.showPrintDialog(main.getMainWindow());
		
		if(CzyDrukowac){
			success = printJob.printPage(table);
		}
		
		if(success){
			Alert alert = new Alert(AlertType.CONFIRMATION, "Drukowanie się powiodło!", ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.show();
			printJob.endJob();
		}
		else{
			Alert alert = new Alert(AlertType.ERROR, "Drukowanie się nie powiodło!", ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.show();
		}
	}
	private void CreateTable()
	{
		table.setPlaceholder(new Label("Nie posiadasz zadnej historii rezerwacji"));
		
		TableColumn column1 = new TableColumn("Data od");
		column1.setMinWidth(150);
		column1.setCellValueFactory(new PropertyValueFactory<HistoriaRezerwacji, Date>("dataOd"));
		table.getColumns().add(column1);
		
		TableColumn column2 = new TableColumn("Data do");
		column2.setMinWidth(150);
		column2.setCellValueFactory(new PropertyValueFactory<HistoriaRezerwacji, Date>("dataDo"));
		table.getColumns().add(column2);
		
		TableColumn column3 = new TableColumn("Numer pokoju");
		column3.setMinWidth(150);
		column3.setCellValueFactory(new PropertyValueFactory<HistoriaRezerwacji, Integer>("pokoj_Id"));
		table.getColumns().add(column3);
	}
}