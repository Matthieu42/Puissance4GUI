package controller;


import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class GridController implements MainController
{
    @FXML
    public GridPane buttonGrid;
    public GridPane rectGrid;
    public Label gameState;
    public MenuItem newGameButton;
    public int nbPlayer = 1;
    @FXML
    private void buttonHandler(ActionEvent event)
    {
    	Button button = (Button) event.getSource();
    	
    	int col;
    	int row = model.getHeight();
    	col = button.getText().charAt(0) - '0' -1 ;
		while(GridController.getNodeFromGridPane(col,row,rectGrid) != null)
		{
    		if(row <= 0)
    			return;
    		row--;
		}
		
		
    	model.tabJoueur[nbPlayer].jouer(col,row,rectGrid);
    	if(nbPlayer == 0)
    	{
    		model.tabJoueur[1].setLastPlayer(false);
    		nbPlayer++;
    	}
		else if(nbPlayer == 1)
		{
			model.tabJoueur[0].setLastPlayer(false);
			nbPlayer--;
		}
    	gameState.setText("C'est à " + model.tabJoueur[nbPlayer].getPseudo() + " de jouer !" );
    	model.setCell(nbPlayer,row,col);
    	if(model.areFourConnected(nbPlayer))
    	{
    		gameState.setText(model.tabJoueur[nbPlayer].getPseudo() + " a gagné ! ");
    		winDialog();
    	}
    	
    }
    
    public void newGame()
    {
    	rectGrid.getChildren().clear();
    	model.initGrid();
    }
    public void winDialog()
    {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle(model.tabJoueur[nbPlayer].getPseudo() + " a gagné ! ");
    	alert.setHeaderText("Voulez-vous faire une nouvelle partie ?");
    	alert.setContentText("C'est a vous de choisir !");
    	ButtonType buttonNewGame = new ButtonType("Nouvelle partie");
    	ButtonType buttonExitGame = new ButtonType("Quitter le jeu");
    	ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
    	alert.getButtonTypes().setAll(buttonNewGame,buttonExitGame,buttonTypeCancel);
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == buttonNewGame)
    	{
    		rectGrid.getChildren().clear();
        	model.initGrid();
    	} 
    	else if (result.get() == buttonExitGame) 
    	{
    		Stage stage = (Stage) rectGrid.getScene().getWindow();
        	stage.close();
    	}
    	else 
    	{
    	    // ... user chose CANCEL or closed the dialog
    	}
    }
    public static Rectangle getNodeFromGridPane(int col, int row, GridPane rectGrid) 
    {
        for (Node rectangle : rectGrid.getChildren()) 
        {
			if (GridPane.getColumnIndex(rectangle) == col && GridPane.getRowIndex(rectangle) == row) 
                return (Rectangle) rectangle;
        }
        return null;
    }
    
}