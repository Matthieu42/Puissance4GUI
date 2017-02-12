package model;



public class Grid
{
	private final int NB_LIGNE = 5;
	private final int NB_COLONNE = 6;
	private final int TOTAL_NB_JOUEUR = 2;
	public Joueur[] tabJoueur = new Joueur[2];
	public JoueurIa ia = new JoueurIa();
	public int[][] grid = new int[NB_LIGNE+1][NB_COLONNE+1];
	public boolean iaGame;

	public Grid()
	{
        this.initGrid();
        setIaGame(false);
	}
	
	public int checkWin() {
	    final int HEIGHT = grid.length;
	    final int WIDTH = grid[0].length;
	    final int EMPTY_SLOT = -1;
	    for (int r = 0; r < HEIGHT; r++) { // iterate rows, bottom to top
	        for (int c = 0; c < WIDTH; c++) { // iterate columns, left to right
	            int player = grid[r][c];
	            if (player == EMPTY_SLOT)
	                continue; // don't check empty slots

	            if (c + 3 < WIDTH &&
	                player == grid[r][c+1] && // look right
	                player == grid[r][c+2] &&
	                player == grid[r][c+3])
	                return player;
	            if (r + 3 < HEIGHT) {
	                if (player == grid[r+1][c] && // look up
	                    player == grid[r+2][c] &&
	                    player == grid[r+3][c])
	                    return player;
	                if (c + 3 < WIDTH &&
	                    player == grid[r+1][c+1] && // look up & right
	                    player == grid[r+2][c+2] &&
	                    player == grid[r+3][c+3])
	                    return player;
	                if (c - 3 >= 0 &&
	                    player == grid[r+1][c-1] && // look up & left
	                    player == grid[r+2][c-2] &&
	                    player == grid[r+3][c-3])
	                    return player;
	            }
	        }
	    }
	    return EMPTY_SLOT; // no winner found
	}
	public boolean isFull()
	{
		for(int c = 0; c<grid.length; c++)
		{
			for(int l = 0; l<grid[0].length; l++)
			{
				if(getCell(c,l) == -1)
					return false;
					
			}
		}
		return true;
		
	}
	public void initGrid()
	{
		for(int c = 0; c<=this.getWidth(); c++)
		{
			for(int l = 0; l<=this.getHeight(); l++)
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
	public void display()
	{
		for(int[] i : this.grid)
		{
			for(int i2 : i )
			{
				System.out.print(i2);
			}
			System.out.println();
		}
	}
	public boolean isColFull(int col)
	{
		for(int l = 0; l<grid[0].length; l++)
		{
			if(getCell(col,l) == -1)
				return false;
				
		}
		return true;
	}

	public boolean isIaGame() {
		return iaGame;
	}

	public void setIaGame(boolean iaGame) {
		this.iaGame = iaGame;
	}
	
}
