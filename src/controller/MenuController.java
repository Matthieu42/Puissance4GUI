package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class MenuController implements MainController,Initializable
{

	    @FXML
	    private JFXButton multiButton;

	    @FXML
	    private JFXButton soloButton;
	    
	    @Override
		public void initialize(URL location, ResourceBundle resources)
	    {
			// TODO Auto-generated method stub
			
		}
	    
	    @FXML
	    void handleMulti(ActionEvent event) throws IOException 
	    {
	    	Stage stage = (Stage) soloButton.getScene().getWindow();
	    	Parent multi = FXMLLoader.load(getClass().getResource("/view/MultiForm.fxml"));
	    	Scene multiScene = new Scene(multi, 600, 400);
	    	
	    	stage.setScene(multiScene);
	    	stage.show();
	    }

	    @FXML
	    void handleSolo(ActionEvent event) throws IOException 
	    {
	    	Stage stage = (Stage) soloButton.getScene().getWindow();
	    	Parent solo = FXMLLoader.load(getClass().getResource("/view/SoloForm.fxml"));
	    	Scene soloScene = new Scene(solo, 600, 400);
	    	
	    	stage.setScene(soloScene);
	    	stage.show();
	    }

		


}
