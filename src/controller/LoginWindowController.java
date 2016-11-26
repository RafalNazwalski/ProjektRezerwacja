package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
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
			wyswietlGlowneOkno(event);
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
	
	private void wyswietlGlowneOkno(ActionEvent event) throws IOException{
		FXMLLoader mainWindow = new FXMLLoader();
		Pane root = mainWindow.load(getClass().getClassLoader().getResource("application/MainWindow.fxml").openStream());
		MainWindowController mainWindowController = (MainWindowController)mainWindow.getController();
		mainWindowController.setUser(TBLogin.getText());
		Scene mainWindowScene = new Scene(root);
		Stage stage =  (Stage) ((Node)event.getSource()).getScene().getWindow();
		stage.setScene(mainWindowScene);
		stage.show();
	}

	
}
