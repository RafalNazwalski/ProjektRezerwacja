package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class MainWindowController implements Initializable {
	
	@FXML
	Label LblUzytkownik;
	
	public void setUser(String user){
		LblUzytkownik.setText(user);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}
}
