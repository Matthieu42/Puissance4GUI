package model;

import javafx.scene.layout.GridPane;

public class JoueurIa extends Joueur
{

	public JoueurIa() {
		super();
	}
	
	public void jouer(Grid mainGrid, GridPane rectGrid)
	{
		int col = 0;
		int row = mainGrid.getHeight();
		do{
			col = (int) (Math.random() * ( 7 - 1 ));
			while(mainGrid.getCell(row,col) != -1)
			{
				row--;
				if(row <= 0)
					break;
			}
		}while(mainGrid.isColFull(col));
		this.jouer(col,row,rectGrid);
		mainGrid.setCell(1,row,col);

	}
	
}