package model;

import javafx.scene.paint.Color;

public class Model
{

	public Joueur[] tabJoueur = new Joueur[2];
	public int[][] grid = {
			{-1,-1,-1,-1,-1,-1,-1},
			{-1,-1,-1,-1,-1,-1,-1},
			{-1,-1,-1,-1,-1,-1,-1},
			{-1,-1,-1,-1,-1,-1,-1},
			{-1,-1,-1,-1,-1,-1,-1},
			{-1,-1,-1,-1,-1,-1,-1}
			};
	private final int NB_LIGNE = 5;
	private final int NB_COLONNE = 6;
	private final int TOTAL_NB_JOUEUR = 2;

	
	public Model()
	{
		Color[] tabColor = {Color.YELLOW,Color.RED};
        for(int i = 0; i<getTotalNbJoueur(); i++)
        {
        	tabJoueur[i] = new Joueur(tabColor[i]);
        }
	}
	
	public boolean areFourConnected(int player){

	    // horizontalCheck 
	    for (int j = 0; j<7-3 ; j++ ){
	        for (int i = 0; i<getWidth(); i++){
	            if (this.grid[i][j] == player && this.grid[i][j+1] == player && this.grid[i][j+2] == player && this.grid[i][j+3] == player){
	                return true;
	            }           
	        }
	    }
	    // verticalCheck
	    for (int i = 0; i<getWidth()-3 ; i++ ){
	        for (int j = 0; j<this.getHeight(); j++){
	            if (this.grid[i][j] == player && this.grid[i+1][j] == player && this.grid[i+2][j] == player && this.grid[i+3][j] == player){
	                return true;
	            }           
	        }
	    }
	    // ascendingDiagonalCheck 
	    for (int i=3; i<getWidth(); i++){
	        for (int j=0; j<getHeight()-3; j++){
	            if (this.grid[i][j] == player && this.grid[i-1][j+1] == player && this.grid[i-2][j+2] == player && this.grid[i-3][j+3] == player)
	                return true;
	        }
	    }
	    // descendingDiagonalCheck
	    for (int i=3; i<getWidth(); i++){
	        for (int j=3; j<getHeight(); j++){
	            if (this.grid[i][j] == player && this.grid[i-1][j-1] == player && this.grid[i-2][j-2] == player && this.grid[i-3][j-3] == player)
	                return true;
	        }
	    }
	    return false;
	}
	
	public int getCell(int row, int col)
	{
		return this.grid[row][col];
	}
	public int getWidth()
	{
		return this.NB_COLONNE;
	}
	public int getHeight()
	{
		return this.NB_LIGNE;
	}

	public int getTotalNbJoueur() {
		return TOTAL_NB_JOUEUR;
	}
}
