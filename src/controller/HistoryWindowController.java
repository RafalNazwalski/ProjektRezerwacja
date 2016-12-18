package controller;

import java.io.File;
import java.io.IOException;

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
import javafx.scene.control.TableView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class HistoryWindowController {

	@FXML
	TableView<Node> toPrint;
	
	@FXML
	Button ButtonSave;
	
	@FXML
	Button ButtonPDF;
	
	@FXML
	public void printHistory(){
		
		Main main = new Main();
		
		boolean success = false;
		PrinterJob printJob = PrinterJob.createPrinterJob();
		boolean CzyDrukowac = printJob.showPrintDialog(main.getMainWindow());
		
		if(CzyDrukowac){
			success = printJob.printPage(toPrint);
		}
		
		if(success)
		printJob.endJob();
	
	}
	
	
//	public void SavePng(){
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Save Image");
//        File file = fileChooser.showSaveDialog(Main.MainWindow);
//        double x = toPrint.getWidth();
//        double y = toPrint.getHeight();
//
//        WritableImage writableImage = new WritableImage((int) x, (int) y);
//        toPrint.snapshot(null, writableImage);
//        
//        if (file != null) {
//            try {
//                ImageIO.write(SwingFXUtils.fromFXImage(writableImage,
//                    null), "png", file);
//            } catch (IOException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//	}
}
