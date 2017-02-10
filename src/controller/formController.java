package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class formController implements MainController
{
	
    public TextField pseudo1;
    public TextField pseudo2;
    public Button sendForm;

    
    @FXML
    public void formHandler()
    {
    	model.tabJoueur[0].setPseudo(pseudo1.getText());
    	model.tabJoueur[1].setPseudo(pseudo2.getText());
    	Stage stage = (Stage) sendForm.getScene().getWindow();
    	stage.close();
    }
    
}
