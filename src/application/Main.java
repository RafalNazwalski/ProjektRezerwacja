package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application 
{
	
	private Stage mainWindow;
	
	@Override
	public void start(Stage primaryStage) {
		try 
		{
			mainWindow = primaryStage;
			
			Parent layout = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
			Scene scene = new Scene(layout);
			mainWindow.setScene(scene);
			mainWindow.show();
			
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}
