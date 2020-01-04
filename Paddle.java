package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Paddle extends Rectangle  {
	 Color col=Color.white;
    public int dx=0;
	public int speed= 8;
    boolean [] keys;
    public int  state=0; //switch to allow for mouse-driven paddle
    public boolean move=false;
    public int posx;
    public int paddle_version=1;//1 is very responsive, 2 is similar to key-driven object
    public static int default_len=250;
     //static int width=250;
  
	 public void drawPaddle(Graphics2D win) {
		 win.setColor(col);
	
		 win.draw(this);
		 
	 }


public Paddle(boolean [] keys) {
	super(300,500,250,1);
	this.keys =keys;
}

public void update() {
    if(this.state==0) dx=0;
 
	if(keys[KeyEvent.VK_A]  && Breakout.Breakoutstate==1 && this.state==0 ) {
		dx=-speed;
	}
	if(keys[KeyEvent.VK_D]  && Breakout.Breakoutstate==1 && this.state==0) {
		dx=Math.abs(speed);
	
	}
	
	//stops the mouse-controlled paddle from moving
	if(this.state==2 && (this.x<posx && this.x+this.width>posx))this.state=0;
	
	if((dx >0 && this.x+this.dx+this.width<=800)  )this.translate(dx,0);
	else if(this.dx<0 && this.x+this.dx>=0) this.translate(dx, 0);
}

public void recenter() {
int x=this.x+(this.width)/2;
	this.translate( (400-x), 0);
}

//changes the width
public void setWidth(int width) {
	this.width=width;
}

//changes the speed
public void changespeed(int vx) {
	this.speed=vx;
}

public void moveto(int posx) {
	
	//this version of mouse control is more responsive/ but it is much more responsive
	 if(this.paddle_version==1) {//added the patch
	 if(posx>=(this.width/2) && posx<=Screen.Width-(this.width/2)) this.translate((int)(posx-this.getCenterX()),0);
	 else if(posx<(this.width/2)) this.translate((int)((this.width/2)-this.getCenterX()),0);
	 else if(posx>800-(this.width/2)) this.translate((int)((800-(this.width/2))-this.getCenterX()), 0);
		}
	
	//this version of mouse control has the same dx/speed as that of the key-driven paddle
	 else 	if(this.paddle_version==2) {
   if(this.x+this.width<posx ) this.dx=Math.abs(speed);
   if(this.x>posx ) this.dx=-speed;
	}
	


}
}