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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.FlowPane;
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
    public MenuItem aboutButton;
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
    	if(model.checkWin() == 0)
    	{
    		gameState.setText(model.tabJoueur[0].getPseudo() + " a gagné ! ");
    		winDialog();
    	}
    	else if(model.checkWin() == 1)
    	{
    		gameState.setText(model.tabJoueur[1].getPseudo() + " a gagné ! ");
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
    	Alert win = new Alert(AlertType.CONFIRMATION);
    	win.setTitle(model.tabJoueur[nbPlayer].getPseudo() + " a gagné ! ");
    	win.setHeaderText("Voulez-vous faire une nouvelle partie ?");
    	win.setContentText("C'est a vous de choisir !");
    	ButtonType buttonNewGame = new ButtonType("Nouvelle partie");
    	ButtonType buttonExitGame = new ButtonType("Quitter le jeu");
    	ButtonType buttonTypeCancel = new ButtonType("Fermer", ButtonData.CANCEL_CLOSE);
 
    	win.getButtonTypes().setAll(buttonNewGame,buttonExitGame,buttonTypeCancel);
    	Optional<ButtonType> result = win.showAndWait();
    	if (result.get() == buttonNewGame)
    	{
    		rectGrid.getChildren().clear();
        	model.initGrid();
    	} 
    	else if (result.get() == buttonExitGame) 
    	{
    		Stage stage2 = (Stage) rectGrid.getScene().getWindow();
        	stage2.close();
    	}
    	else 
    	{
    	    // ... user chose CANCEL or closed the dialog
    	}
    }
    
    public void aboutDialog()
    {
    	Alert about = new Alert(AlertType.INFORMATION);
    	about.setTitle("À propos");
    	about.setHeaderText("À propos");
    	Label lb = new Label("Jeu de puissance 4 développé en java, les sources sont disponible à l'adresse suivante,");
    	FlowPane fp = new FlowPane();
    	Hyperlink link = new Hyperlink("https://github.com/Matthieu42/Puissance4GUI");
    	fp.getChildren().addAll(lb,link);
    	about.getDialogPane().contentProperty().set(fp);
    	about.showAndWait();
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