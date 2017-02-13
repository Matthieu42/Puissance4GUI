package model;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class JoueurIa extends Joueur
{

	public JoueurIa() {
		super();
		super.setPseudo("IA");
		super.setColor(Color.RED);
	}
	
	public void jouer(Grid mainGrid, GridPane rectGrid, GridPane buttonGrid)
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
		this.jouer(col,row,rectGrid,buttonGrid);
		mainGrid.setCell(1,row,col);

	}
	
}