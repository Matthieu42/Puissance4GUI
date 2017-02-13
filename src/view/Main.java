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
        
        
        Parent menu = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        
        Scene menuScene = new Scene(menu, 600, 400);
        
        //Scene mainScene = new Scene(grid, 900, 636);
        
        primaryStage.setTitle("Puissance 4");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("view/images/p4.png"));
        
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }
    

	
}