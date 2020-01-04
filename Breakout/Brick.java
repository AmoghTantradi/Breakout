package Breakout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Brick extends Rectangle {
	double dx;
	double dy;
	//constructor 
	public Brick(int x, int y,int l, Color c) {
		super(x,y,width,height);//initializes the values
		currentcolor=c;
	}
	public Brick(int x, int y, double a, double b) {
		super(x,y,(int)a,(int) b);
	}
//instance fields 

 Color currentcolor=Color.red;
 int lives =3;
 
 
 //static fields 
static int xBuffer=5;
static int yBuffer=5;
static int width=75, height=30;
static boolean boomTown=false;
	
	public void draw (Graphics2D win) {
		if(this.lives>0) {
		win.setColor(this.currentcolor);
		win.fill(this);
		}


}
	

	
		
	
	
	public void moveto(int x, int y ) {
		this.translate(x-(this.x), y-(this.y));
	}


	
}
