package services;


import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.print.PrinterJob;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;


public class PrintService {
		
	public void printHistory(){
		boolean success = false;
		PrinterJob printJob = PrinterJob.createPrinterJob();
		boolean CzyDrukowac = printJob.showPrintDialog(Main.window);
		
		if(CzyDrukowac){
		success = printJob.printPage(ToPrint);
		}
		
		if(success)
		printJob.endJob();
	
	}
	
	
	public void SavePng(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        File file = fileChooser.showSaveDialog(Main.window);
        double x = ToPrint.getWidth();
        double y = ToPrint.getHeight();

        WritableImage writableImage = new WritableImage((int) x, (int) y);
        ToPrint.snapshot(null, writableImage);
        
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
	

