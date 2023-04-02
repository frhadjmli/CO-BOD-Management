package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;




public class Main extends Application {
	
	
// initialize main window 
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/TechFX.fxml"));
			
			Scene scene = new Scene(root);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			
			Image image = new Image("/application/Image/icon.png");
			
			primaryStage.getIcons().add(image);
			
			primaryStage.setTitle("Zanjan Tech Park");
			
			primaryStage.setResizable(false);
			
			primaryStage.show();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Database db = new Database();
	
		
		db.closeConnection();
		
	
		launch(args);
		
	}
}
