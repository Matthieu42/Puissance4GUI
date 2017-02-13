package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Joueur;

public class SoloFormController implements MainController,Initializable
{
	public AnchorPane pane;
    public JFXTextField pseudo;
    public JFXButton sendForm;
    public JFXButton backButton;
    public JFXColorPicker player1Color = new JFXColorPicker(Color.YELLOW);
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		player1Color.setLayoutX(400);
		player1Color.setLayoutY(190);
		pane.getChildren().add(player1Color); 
	}
    @FXML
    public void formHandler() throws IOException
    {
    	if(pseudo.getText().trim().isEmpty())
    	{
    		return;
    	}
    	mainGrid.tabJoueur[0] = new Joueur();
    	mainGrid.tabJoueur[1] = mainGrid.ia;
    	mainGrid.setIaGame(true);
    	mainGrid.tabJoueur[0].setPseudo(pseudo.getText());
    	mainGrid.tabJoueur[0].setColor(player1Color.getValue());

        Stage stage = (Stage) sendForm.getScene().getWindow();
        Parent grid = FXMLLoader.load(getClass().getResource("/view/MainGrid.fxml"));
    	Scene gridScene = new Scene(grid, 900, 636);
    	stage.setScene(gridScene);
    	stage.show();
    	connect.setFormEnd(true);
    }
    public void enterPressed(KeyEvent keyEvent) throws IOException
    {
    	if(keyEvent.getCode() == KeyCode.ENTER)
    		formHandler();
    }

	@FXML
	void back() throws IOException
	{
		Stage stage = (Stage) sendForm.getScene().getWindow();
        Parent menu = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
    	Scene menuScene = new Scene(menu, 600, 400);
    	stage.setScene(menuScene);
    	stage.show();
	}
}
