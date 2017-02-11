package controller;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class GridController implements MainController,Initializable
{
    @FXML
    public GridPane buttonGrid;
    public GridPane rectGrid;
    public Label gameState;
    public Label player1Score;
    public Label player2Score;
    public Label player1Pseudo;
    public Label player2Pseudo;
    public Circle colorPlayer1;
    public Circle colorPlayer2;
    public MenuItem newGameButton;
    public MenuItem aboutButton;
    public MenuItem rulesButton;
    public MenuItem scoreResetButton;
    public int nbPlayer = 0;
    public boolean win = false;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		gameState.setText("C'est à " + mainGrid.tabJoueur[nbPlayer].getPseudo() + " de jouer !" );
		colorPlayer1.setFill(mainGrid.tabJoueur[0].getColor());
		colorPlayer2.setFill(mainGrid.tabJoueur[1].getColor());
		updateScorelabel();
	}
    @FXML
    private void buttonHandler(ActionEvent event)
    {
    	
    	Button button = (Button) event.getSource();
    	int col;
    	int row = mainGrid.getHeight();
    	col = button.getText().charAt(0) - '0' -1 ;
		while(GridController.getNodeFromGridPane(col,row,rectGrid) != null)
		{
    		if(row <= 0)
    			return;
    		row--;
		}
    	mainGrid.tabJoueur[nbPlayer].jouer(col,row,rectGrid);

    	
    	mainGrid.setCell(nbPlayer,row,col);
    	int winPlayer = mainGrid.checkWin();
    	int losePlayer;
    	if(winPlayer == 0 || winPlayer == 1)
    	{
    		
    		if(winPlayer == 0)
    			losePlayer = 1;
    		else
    			losePlayer = 0;
    		gameState.setText(mainGrid.tabJoueur[winPlayer].getPseudo() + " a gagné ! ");
    		mainGrid.tabJoueur[winPlayer].win();
    		mainGrid.tabJoueur[losePlayer].lose();
    		updateScorelabel();
    		winDialog();
    		win = true;
    	}
    	if(mainGrid.isFull())
    	{
    		Alert draw = new Alert(AlertType.CONFIRMATION);
        	draw.setTitle("Egalité");
        	draw.setHeaderText("Voulez-vous faire une nouvelle partie ?");
        	ButtonType buttonNewGame = new ButtonType("Nouvelle partie");
        	ButtonType buttonExitGame = new ButtonType("Quitter le jeu");
        	ButtonType buttonTypeCancel = new ButtonType("Fermer", ButtonData.CANCEL_CLOSE);
        	draw.getButtonTypes().setAll(buttonNewGame,buttonExitGame,buttonTypeCancel);
        	Optional<ButtonType> result = draw.showAndWait();
        	if (result.get() == buttonNewGame)
        	{
        		rectGrid.getChildren().clear();
            	mainGrid.initGrid();
        	} 
        	else if (result.get() == buttonExitGame) 
        	{
        		Stage stage2 = (Stage) rectGrid.getScene().getWindow();
            	stage2.close();
        	}
        	
    	}
    	
    	if(nbPlayer == 0)
    			nbPlayer++;
    		else
    			nbPlayer--;
    	if(win)
    	{
    		nbPlayer = 0;
    		win = false;
    	}
    	gameState.setText("C'est à " + mainGrid.tabJoueur[nbPlayer].getPseudo() + " de jouer !" );
    }
    
    public void newGame()
    {
    	rectGrid.getChildren().clear();
    	mainGrid.initGrid();
    }
    public void winDialog()
    {
    	Alert win = new Alert(AlertType.CONFIRMATION);
    	win.setTitle(mainGrid.tabJoueur[nbPlayer].getPseudo() + " a gagné ! ");
    	win.setHeaderText("Voulez-vous faire une nouvelle partie ?");
    	ButtonType buttonNewGame = new ButtonType("Nouvelle partie");
    	ButtonType buttonExitGame = new ButtonType("Quitter le jeu");
    	ButtonType buttonTypeCancel = new ButtonType("Fermer", ButtonData.CANCEL_CLOSE);
 
    	win.getButtonTypes().setAll(buttonNewGame,buttonExitGame,buttonTypeCancel);
    	Optional<ButtonType> result = win.showAndWait();
    	if (result.get() == buttonNewGame)
    	{
    		rectGrid.getChildren().clear();
        	mainGrid.initGrid();
    	} 
    	else if (result.get() == buttonExitGame) 
    	{
    		Stage stage2 = (Stage) rectGrid.getScene().getWindow();
        	stage2.close();
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
    public void rulesDialog()
    {
    	Alert about = new Alert(AlertType.INFORMATION);
    	about.setTitle("Règles du jeu");
    	about.setHeaderText("Règles du jeu");
    	about.setContentText("Le but du jeu est d'aligner 4 pions de sa couleur soit horizontalement , verticalement ou diagonalement.\n"
    			+ "Chaque victoire rapporte 100 point, une défaite en fait perdre 50 "
    			+ "et une égalité ne change pas les scores.");
    	about.showAndWait();
    }
    public void scoreReset()
    {
    	 for(int i = 0; i < mainGrid.getTotalNbJoueur(); i++)
         {
         	mainGrid.tabJoueur[i].resetScores();
         	updateScorelabel();
         }
    }
    
    public void updateScorelabel()
    {
    		player1Pseudo.setText(mainGrid.tabJoueur[0].getPseudo());
    		player1Pseudo.setFont(Font.font("System", FontWeight.BOLD, 15));
    		player2Pseudo.setText(mainGrid.tabJoueur[1].getPseudo());
    		player2Pseudo.setFont(Font.font("System", FontWeight.BOLD, 15));
    		
    		player1Score.setText("Score = " + mainGrid.tabJoueur[0].getScore() + "\n" + "Parties gagné(s) = "
    		+ mainGrid.tabJoueur[0].getWinCount() + "\n");
    		player2Score.setText("Score = " + mainGrid.tabJoueur[1].getScore() + "\n" + "Parties gagné(s) = "
    	    + mainGrid.tabJoueur[1].getWinCount() + "\n");
    	
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