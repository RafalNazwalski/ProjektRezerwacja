package controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import application.Main;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.HistoriaRezerwacji;
import services.HistoryService;

public class HistoryWindowController {

	HistoryService service = new HistoryService();
	
	@FXML
	TableView<HistoriaRezerwacji> table;
	
	@FXML
	Button ButtonSave;
	
	@FXML
	Button ButtonPDF;
	
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
		
		if(success)
		printJob.endJob();
	
	}
	private void CreateTable()
	{
		TableColumn column1 = new TableColumn("Data od");
		column1.setMinWidth(200);
		column1.setCellValueFactory(new PropertyValueFactory<HistoriaRezerwacji, Date>("dataOd"));
		table.getColumns().add(column1);
		
		TableColumn column2 = new TableColumn("Data do");
		column2.setMinWidth(200);
		column2.setCellValueFactory(new PropertyValueFactory<HistoriaRezerwacji, Date>("dataDo"));
		table.getColumns().add(column2);
		
		TableColumn column3 = new TableColumn("Numer pokoju");
		column3.setMinWidth(200);
		column3.setCellValueFactory(new PropertyValueFactory<HistoriaRezerwacji, Integer>("pokoj_Id"));
		table.getColumns().add(column3);
	}
}