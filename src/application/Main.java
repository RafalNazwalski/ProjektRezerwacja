package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import repository.RolaRepository;


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
			
			RolaRepository rola = new RolaRepository();
			
			rola.getAll();
			
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
