package model;

import javafx.scene.paint.Color;

public class Model
{
	private final int NB_LIGNE = 5;
	private final int NB_COLONNE = 6;
	private final int TOTAL_NB_JOUEUR = 2;
	public Joueur[] tabJoueur = new Joueur[2];
	public int[][] grid = new int[NB_LIGNE+1][NB_COLONNE+1];


	public Model()
	{
		Color[] tabColor = {Color.YELLOW,Color.RED};
        for(int i = 0; i<getTotalNbJoueur(); i++)
        {
        	tabJoueur[i] = new Joueur(tabColor[i]);
        }
        this.initGrid();
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
	public void initGrid()
	{
		for(int c = 0; c<= this.getWidth(); c++)
		{
			for(int l = 0; l<= this.getHeight(); l++)
			{
				setCell(-1,l,c);
			}
		}

	}
	public int getCell(int row, int col)
	{
		return this.grid[row][col];
	}
	public void setCell(int setter, int row, int col)
	{
		this.grid[row][col] = setter;
	}
	public int[][] getGrid() {
		return this.grid;
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
