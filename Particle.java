package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

@SuppressWarnings("serial")
public class Particle extends Rectangle {

	//instance variables 
	double  dx,dy;
	Color c=Color.ORANGE;
	int range = 5; //radius of the explosion
	//static variables
	static double gravity=1;
	static int size =5;
	//constructors 
	
	public Particle( Ball ball) {
		super(ball.x,ball.y,size, size);
		
	//random vectors 
		Random rand =new Random();
		
		dx= range *rand.nextGaussian();
		dy=range*rand.nextGaussian();
		
		
		
	}

	
	public void update () {
		
		dy+=gravity;
		this.translate((int)dx,(int) dy);
	}
	
	public void draw(Graphics2D win) {
		win.setColor(c);
		win.fill(this);
	}
	
	public void changeCol(Color x) {
		this.c=x;
	}
	
	
}