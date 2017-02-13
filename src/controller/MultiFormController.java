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

public class MultiFormController implements MainController,Initializable
{
	
	public AnchorPane pane;
	public JFXTextField pseudo1;
	public JFXTextField pseudo2;
	public JFXButton sendForm;
	public JFXButton backButton;
	public JFXColorPicker player1Color = new JFXColorPicker(Color.YELLOW);
	public JFXColorPicker player2Color = new JFXColorPicker(Color.RED);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		player1Color.setLayoutX(400);
		player1Color.setLayoutY(153);
		player2Color.setLayoutX(400);
		player2Color.setLayoutY(222);
		pane.getChildren().addAll(player1Color,player2Color); 
		
	}
	
	@FXML
	void enterPressed(KeyEvent event) throws IOException 
	{
		if(event.getCode() == KeyCode.ENTER)
    		formHandler();
	}

	@FXML
	void formHandler() throws IOException 
	{
    	if(pseudo1.getText().trim().isEmpty() || pseudo2.getText().trim().isEmpty())
    	{
    		return;
    	}
		mainGrid.tabJoueur[0] = new Joueur();
    	mainGrid.tabJoueur[1] = new Joueur();
    	mainGrid.setIaGame(false);
    	mainGrid.tabJoueur[0].setPseudo(pseudo1.getText());
    	mainGrid.tabJoueur[1].setPseudo(pseudo2.getText());
    	mainGrid.tabJoueur[0].setColor(player1Color.getValue());
    	mainGrid.tabJoueur[1].setColor(player2Color.getValue());

        Stage stage = (Stage) sendForm.getScene().getWindow();
        Parent grid = FXMLLoader.load(getClass().getResource("/view/MainGrid.fxml"));
    	Scene gridScene = new Scene(grid, 900, 636);
    	stage.setScene(gridScene);
    	stage.show();
    	connect.setFormEnd(true);
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
