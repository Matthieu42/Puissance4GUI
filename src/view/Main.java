package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
        Scene mainScene = new Scene(root, 900, 660);
        Scene inputScene = new Scene(input, 600, 400);
        
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("view/p4.png"));
        inputStage.getIcons().add(new Image("view/p4.png"));
        inputStage.setScene(inputScene); 
        primaryStage.show();
        inputStage.showAndWait();
    }
    

	
}