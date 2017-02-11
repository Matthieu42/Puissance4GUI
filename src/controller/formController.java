package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.ColorPicker;

public class formController implements MainController,Initializable
{
	public AnchorPane pane;
    public TextField pseudo1;
    public TextField pseudo2;
    public Button sendForm;
    public ColorPicker player1Color = new ColorPicker(Color.YELLOW);
    public ColorPicker player2Color = new ColorPicker(Color.RED);
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		player1Color.setLayoutX(446);
		player1Color.setLayoutY(151);
		player2Color.setLayoutX(446);
		player2Color.setLayoutY(189);
		pane.getChildren().addAll(player1Color,player2Color);
		
	}
    @FXML
    public void formHandler()
    {
    	mainGrid.tabJoueur[0].setPseudo(pseudo1.getText());
    	mainGrid.tabJoueur[1].setPseudo(pseudo2.getText());
    	mainGrid.tabJoueur[0].setColor(player1Color.getValue());
    	mainGrid.tabJoueur[1].setColor(player2Color.getValue());
    	Stage stage = (Stage) sendForm.getScene().getWindow();
    	if(pseudo1.getText().trim().isEmpty() || pseudo2.getText().trim().isEmpty())
    	{
    		return;
    	}
    	stage.close();
    	connect.setFormEnd(true);
    }
    public void enterPressed(KeyEvent keyEvent)
    {
    	if(keyEvent.getCode() == KeyCode.ENTER)
    		formHandler();
    }
    
}
