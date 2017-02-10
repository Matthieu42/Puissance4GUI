package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;


public class GridController implements MainController
{
    @FXML
    public GridPane buttonGrid;
    public GridPane rectGrid;
    public Label gameState;

    
    public int nbPlayer = 1;
    @FXML
    private void buttonHandler(ActionEvent event)
    {
    	Button button = (Button) event.getSource();
    	
    	int col;
    	int row = 5;
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
    	model.grid[row][col] = nbPlayer;
    	if(model.areFourConnected(nbPlayer))
    		gameState.setText(model.tabJoueur[nbPlayer].getPseudo() + " a gagné ! ");
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