package model;

import javafx.util.Duration;
import javafx.animation.TranslateTransition;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.effect.Light;

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
	
	public void jouer(int col,int row, GridPane rectGrid, GridPane buttonGrid)
	{
		Lighting lighting = new Lighting();
		Light.Distant light = new Light.Distant();
		light.setAzimuth(45);
        lighting.setLight(light);
        lighting.setDiffuseConstant(1.3);
		Circle circ = new Circle(45,getColor());
		circ.setEffect(lighting);
		rectGrid.add(circ,col,0);
		Duration animTime = Duration.seconds(0.5*((row+5)*0.1));
	    TranslateTransition tt = new TranslateTransition(animTime,circ);
	    tt.setToY(100*row);
	    tt.setOnFinished(e -> 
	    {
	    	Circle circ2 = new Circle(45,getColor());
	    	circ2.setEffect(lighting);
	    	
	    	rectGrid.add(circ2, col,row);
	    	buttonGrid.setDisable(false);
	    });
	    tt.play();
	    buttonGrid.setDisable(true);
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
