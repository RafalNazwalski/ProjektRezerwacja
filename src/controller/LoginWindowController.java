package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	public void BTNZalogujClick(){
		if(loginService.UserInDatabase(TBLogin.getText(), TBHaslo.getText())){
		
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
