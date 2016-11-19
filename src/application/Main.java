package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application 
{
	
	private Stage mainWindow;
	@Override
	public void start(Stage primaryStage) {
		try 
		{
			showLoginWindow(primaryStage);
			
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private void showLoginWindow(Stage primaryStage) throws IOException{
		
		mainWindow = primaryStage;
		
		Parent layout = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
		Scene scene = new Scene(layout);
		mainWindow.setScene(scene);
		mainWindow.show();
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}
