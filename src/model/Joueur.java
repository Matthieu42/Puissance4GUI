package model;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Joueur 
{
	private String pseudo;
	private int score;
	private Color color;
	private boolean lastPlayer;
	public Joueur(String pseudo, Color color)
	{
		setPseudo(pseudo);
		setScore(0);
		setColor(color);
		setLastPlayer(false);
	}
	public Joueur(Color color)
	{
		setScore(0);
		setColor(color);
		setLastPlayer(false);
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
	
	public boolean isLastPlayer() {
		return lastPlayer;
	}
	
	public void setLastPlayer(boolean lastPlayer) {
		this.lastPlayer = lastPlayer;
	}
	
	public void jouer(int col,int row, GridPane rectGrid)
	{
		rectGrid.add(new Rectangle(110,110,getColor()), col,row);
		setLastPlayer(false);
	}


}
