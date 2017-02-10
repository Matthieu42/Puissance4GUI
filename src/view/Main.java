package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("mainGrid.fxml"));
        Parent input = FXMLLoader.load(getClass().getResource("setupForm.fxml"));
        
        Stage inputStage = new Stage();
        
        primaryStage.setTitle("Puissance 4");
        inputStage.setTitle("Configuration de la partie");
        Scene mainScene = new Scene(root, 900, 672);
        Scene inputScene = new Scene(input, 600, 400);
        
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
        
        
        inputStage.setScene(inputScene); 
        primaryStage.show();
        inputStage.show();
    }
    

	
}