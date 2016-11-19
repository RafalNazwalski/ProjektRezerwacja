package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.LoginService;

public class LoginWindowController implements Initializable {
	
	@FXML
	Button BTNZaloguj;
	@FXML
	TextField TBLogin;
	@FXML
	TextField TBHaslo;
	@FXML
	Label LblBlad;
	
	LoginService loginService = new LoginService();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		LblBlad.setVisible(false);
	}
	
	
	@FXML
	public void BTNZalogujClick(ActionEvent event) throws IOException {
		if(loginService.UserInDatabase(TBLogin.getText(), TBHaslo.getText())){
			System.out.println("Udalo sie!");
			
			Parent mainWindow = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainWindow.fxml"));
			Scene mainWindowScene = new Scene(mainWindow);
			Stage stage =  (Stage) ((Node)event.getSource()).getScene().getWindow();
			stage.setScene(mainWindowScene);
			stage.show();
		}
		else{
			WyswietlBlad();
		}
	}
	
	@FXML
	public void ZmienNapis(){
		TBLogin.setText("Janusze najlepsze");
	}

	private void WyswietlBlad(){
		TBLogin.clear();
		TBHaslo.clear();
		LblBlad.setVisible(true);
	}

	
}
