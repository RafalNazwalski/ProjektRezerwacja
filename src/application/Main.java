package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application 
{
	
	private Stage MainWindow, LoginWindow, HistoryWindow, RoomWindow;

	@Override
	public void start(Stage primaryStage) {
		
//		Database database = new Database();
//		
//		database.polacz();
		
		try 
		{
			/**
			 * G³ówne okno
			 */
			MainWindow = primaryStage;
			Parent MainLayout = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
			Scene MainScene = new Scene(MainLayout);
			MainWindow.setScene(MainScene);
			MainWindow.setTitle("Rezerwacja pokoi hotelowych");
			MainWindow.show();
			
			/**
			 * Okno historii pobytu
			 */
			HistoryWindow = new Stage();
			Parent HistoryLayout = FXMLLoader.load(getClass().getResource("HistoryClientWindow.fxml"));
			Scene HistoryScene = new Scene(HistoryLayout);
			HistoryWindow.setScene(HistoryScene);
			HistoryWindow.setTitle("Historia Pobytu");
			HistoryWindow.initModality(Modality.APPLICATION_MODAL);
			HistoryWindow.show();
			
			/**
			 * Okno ze szczegó³ami pokoi
			 */
			RoomWindow = new Stage();
			Parent RoomLayout = FXMLLoader.load(getClass().getResource("RoomDetailsWindow.fxml"));
			Scene RoomScene = new Scene(RoomLayout);
			RoomWindow.setScene(RoomScene);
			RoomWindow.setTitle("Szczegó³y pokoi");
			RoomWindow.initModality(Modality.APPLICATION_MODAL);
			RoomWindow.show();
			
			/**
			 * Okno logowania
			 */
			LoginWindow = new Stage();
			Parent LoginLayout = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
			LoginLayout.setId("pane");
			Scene LoginScene = new Scene(LoginLayout);
			LoginScene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
			LoginWindow.setScene(LoginScene);
			LoginWindow.setTitle("Rezerwacja pokoi hotelowych - Logowanie");
			LoginWindow.show();
			
			
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void HistoryDisplay()
	{
		System.out.println(HistoryWindow == null);
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}
