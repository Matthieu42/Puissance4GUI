package model;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Joueur 
{
	private String pseudo;
	private int score;
	private Color color;
	private int winCount;
	
	public Joueur(String pseudo)
	{
		setPseudo(pseudo);
		setScore(0);
		setColor(color);
		setWinCount(0);
	}
	public Joueur()
	{
		setScore(0);
		setColor(color);
		setWinCount(0);
	}
	
	public String getPseudo() 
	{
		return this.pseudo;
	}

	public void setPseudo(String pseudo) 
	{
		this.pseudo = pseudo;
	}

	public int getScore() 
	{
		return this.score;
	}

	public void setScore(int score) 
	{
		this.score = score;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void jouer(int col,int row, GridPane rectGrid)
	{
		rectGrid.add(new Rectangle(110,110,getColor()), col,row);
	}

	public void win()
	{
		setWinCount(getWinCount()+1);
		setScore(getScore()+100);
	}
	public void lose()
	{
		if(getScore() > 0)
			setScore(getScore()-50);
	}
	public void resetScores()
	{
		setWinCount(0);
		setScore(0);
	}
	public int getWinCount() {
		return winCount;
	}
	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}

}
