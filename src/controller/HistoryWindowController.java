package controller;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class HistoryWindowController {

	@FXML
	TableView toPrint;
	
	
	public void printHistory(){
		boolean success = false;
		PrinterJob printJob = PrinterJob.createPrinterJob();
		boolean CzyDrukowac = printJob.showPrintDialog(Main.window);
		
		if(CzyDrukowac){
		success = printJob.printPage(toPrint);
		}
		
		if(success)
		printJob.endJob();
	
	}
	
	
	private void wyswietlHistoryWindow(ActionEvent event) throws IOException{
		FXMLLoader wyswietlHistoryWindow = new FXMLLoader();
		Pane root = wyswietlHistoryWindow.load(getClass().getClassLoader().getResource("application/HistoryClientWindow.fxml").openStream());
		MainWindowController mainWindowController = (MainWindowController)wyswietlHistoryWindow.getController();
		Scene HistoryWindowScene = new Scene(root);
		Stage stage =  (Stage) ((Node)event.getSource()).getScene().getWindow();
		stage.setScene(HistoryWindowScene);
		stage.show();
	}
	
	public void SavePng(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        File file = fileChooser.showSaveDialog(Main.MainWindow);
        double x = toPrint.getWidth();
        double y = toPrint.getHeight();

        WritableImage writableImage = new WritableImage((int) x, (int) y);
        toPrint.snapshot(null, writableImage);
        
        if (file != null) {
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(writableImage,
                    null), "png", file);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
	}
}
