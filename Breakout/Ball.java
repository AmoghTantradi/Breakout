package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import Utilities.SoundDriver;

//special feature ?
@SuppressWarnings("serial")
public class Ball extends Rectangle{
	//instance fields 
Brick [] wall;
Paddle p;
int len=0;
public int xv=0,yv=0;
public SoundDriver bar;

//constuctor
	public  Ball(int x, int y, Brick [] wall, Paddle foo) {
		super(x,y,15, 15);
		this.wall=wall;
		p=foo;
		len=wall.length;
		
	}
	//sets the speed of the ball
	public void setVelocity(int vx, int vy) {
this.xv=vx;
this.yv=vy;
	}
	//update function
	public void update(SoundDriver bar) {
		//setting the initial boundaries for the ball
		if(this.x<=0) {
			this.setVelocity(Math.abs(xv),yv);   //how to do animation ??
		}
		if(this.x+this.width>=Screen.Width) {
			this.setVelocity(-xv, yv);
		}
		if(this.y<=0) {
			this.setVelocity(xv, Math.abs(yv));
		}
		if(this.y+this.height>=Screen.Height && Screen.states!=2 ) { //resets the ball, paddle,and wall once it travels out of the screen
             this.reset();
         
		}
		if((len==0 || Screen.scoreboard==60) && Breakout.level==1 ) {
			
			Breakout.level=2;
			this.restart();
			p.setWidth(250);
			p.recenter();
			len=wall.length;
			Screen.scoreboard=60;
			this.x=380;
			this.y=425;
			this.setVelocity(xv++, yv++);
		
			
		}else if((len==0 || Screen.scoreboard==120)&& Breakout.level==2) {
	
			Breakout.level=3;
			p.setWidth(170);
			p.recenter();
			len=wall.length;
			Screen.scoreboard=120;
			this.x=380;
			this.y=425;
			this.restart();

		}
		else if((len==0 || Screen.scoreboard==180) && Breakout.level==3) {
			Screen.states=2;
			Breakout.Breakoutstate=0;
		
			
		}
		
//collision detection with the bricks
	
	    this.collision_detection(bar);

		
		
		//collision detection with the paddle
		if(this.intersects(p)) {
		this.rebound();
		bar.play(3);
		}
	
		

		this.y+=yv;
		this.x+=xv;
	
	}
	
	public void draw(Graphics2D win) { //draws the ball
		win.setColor(Color.MAGENTA);
		win.fill(this);

		
		
	}
	public void rebound() {// collision logic with the paddle 
if(Breakout.collisionDirection(p,this,this.xv,this.yv)==1) {
	this.setVelocity(this.xv,-this.yv);
}
if(Breakout.collisionDirection(p,this,this.xv,this.yv)==2) {
	this.setVelocity(this.xv, this.yv);
}
if(Breakout.collisionDirection(p,this,this.xv,this.yv)==0) {
	this.setVelocity(this.xv, this.yv);
}
	}

	public void restart() { // restarts the wall after the ball travels outside of the screen or if B is pressed
	for(int i=0;i<Breakout.rows;i++){
		for(int j=0;j<Breakout.columns;j++) {
	wall[i*Breakout.columns +j].moveto((Brick.width+Brick.xBuffer)*j,(Brick.height+Brick.yBuffer)*i);
		}
		}	

	}
	public void reset() {
        this.x=380;
        this.y=425;
        this.setVelocity(0, 0);
        this.restart();
    	this.p.setWidth(Paddle.default_len);
        this.p.paddle_version=1;
        Breakout.Breakoutstate=0;
        Screen.states=0;
        len=wall.length;
        Screen.scoreboard=0;
        Breakout.level=1;
	}
	public void collision_detection(SoundDriver bar) {
		for(int i=0;i<Breakout.rows;i++) {
			for(int j=0;j<Breakout.columns;j++) {
				if(this.intersects(wall[i*Breakout.columns +j])) {
					this.setVelocity(xv, Math.abs(yv));
					wall[i*Breakout.columns +j].translate((int) 1000, 0);
			      	len--;
			      	Screen.scoreboard++;
			      	Boom.initial=wall[i*Breakout.columns +j].currentcolor;
			        Brick.boomTown=true;
			        bar.play(0);
					//increases the speed of the ball
			      	if(len==wall.length-10) {
						this.setVelocity(xv-1, Math.abs(yv)+3);
					}
			      	
			      	
				}
			}	
		}
	}
	
	}
