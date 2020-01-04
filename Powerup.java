package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Powerup extends Rectangle {
    Paddle m=new Paddle(Breakout.KeysPressed);
	Ball foo;
	public  int type=0;
	int start=0;
	int dx=1;
	int dy=0;
	//speed up paddle , ball slow down, increased paddle length 
	//just make the base variables, then make several inherited classes
	
	public Powerup( int y, Ball b, Paddle p, int t) {
		super(0,y,20,20);
		foo=b;
		m=p;                                               //lets make a powerup that increases the length of the paddle -done 
		type=t;
	}

	
	
	public void update() {
		
		if(Breakout.level==2 || Breakout.level==3) this.dx=5;
      
		if(this.intersects(foo) ) {
		
	//This powerup works 
			if(this.type==0) {
			if(m.speed<15) {
		m.changespeed(m.speed+1);
			}
		}
			//so does this 
			else {
			if(Breakout.level==1) {
				m.setWidth(400);
			}
			else if(Breakout.level==2) {
				m.setWidth(300);
			
			}
			else if (Breakout.level==3) {
				m.setWidth(220);
			
			}
			}
			
		 //this.foo.bar.play(4);
		 this.translate(1000,0);
		}
		
		if(Breakout.Breakoutstate==0) {
			this.reset();
		}
		
		if(this.x+this.width>Screen.Width) {
			this.x=start;
		}
		
		this.x+=dx;
		if(this.type==1) this.y=(int)(-90*Math.sin((double)Math.PI*this.x/100))+340;
		
	
	
		
	}
	
	
	
	

	
	public void drawpowerup(Graphics2D win) {
		if(type==0) win.setColor(Color.yellow);
		else	win.setColor(Color.PINK);
		win.fill(this);
	}
	
	public void reset() {
		m.setWidth(300);
		m.recenter();
		this.translate(start-this.x,0);
		this.dx=1;
		m.changespeed(6);
		
	}
	
	
	
	
}