package Breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import Utilities.SoundDriver;

public class Screen {
	static int states=0;

	//states=0 is start screen, states =1 is gameplay, states=2 is endscreen

    int posx=250,posy=290;
	Rectangle outline=new Rectangle(posx,posy,315,100);
	int level=1;
	static int scoreboard=0;
    public static int Width=800,Height=600;
	public void update(SoundDriver foo) {
this.level=Breakout.level;
if(states==0 && Breakout.Breakoutstate==0) {

	if (!foo.isPlaying(1) && states==0) {
	foo.loop(1);
	}
	
}
else {
	foo.stop(1);
}
if(states==1 && Breakout.Breakoutstate==1) {
	if(!foo.isPlaying(2)) {
		foo.setVolume(2, (float)6.0206);
		foo.loop(2);
	}
}
else {
	foo.stop(2);
}
if(states==2 && Breakout.Breakoutstate==0) {
	if(!foo.isPlaying(4)) {
		foo.loop(4);
	}
}
else {
	foo.stop(4);
}

	} 
	public void draw(Graphics2D win, Breakout obj) {
		if(states==0) {  //home(menu) screen
	    win.drawImage(obj.addImage("Backgroundpic.png"), 0,0, 800,600, null);
		win.setColor(Color.white);
		Font f=new Font("TimesNewRoman",Font.BOLD,100);
		win.setFont(f);
		win.drawString("BREAKOUT",135,100);
		Font f1=new Font("TimesNewRoman",Font.BOLD,30);
		win.setFont(f1);
		win.setColor(Color.black);
		win.drawString("Press Enter to play", 265, 450);
		win.drawString("Press V for Directions",245,500);
      
		
		}
		if(states==1) { //game is being played in this state 
		//	win.drawImage(obj.addImage("Background2.png"), 0, 0,800, 600, null);
			if (Breakout.Breakoutstate == 1) {//when the game is playing 
				if (obj.boom != null)
					obj.boom.draw(win);
				obj.p.drawPaddle(win);
				obj.b.draw(win);

				for (Brick q : Breakout.wall) {
					q.draw(win);
				}
				obj.P.drawpowerup(win);
				obj.w.drawpowerup(win);
				obj.m.drawpowerup(win);
			win.setColor(Color.white);
			Font f=new Font("TimesNewRoman",Font.BOLD,30);
			win.setFont(f);
		win.drawString("Scoreboard :" + scoreboard ,0,550);  
		win.drawString("Level :"+ this.level, 650, 550);


	}
		}
		if(states==2) {   //game ended 
			win.drawImage(obj.addImage("EndImage.png"), 0, 0,800,600,null);
			Font f=new Font("TimesNewRoman",Font.BOLD,100);
			win.setFont(f);
			win.setColor(Color.BLACK);
			win.drawString("YOU WON !",100,100);
			Font f1=new Font("TimesNewRoman",Font.PLAIN,30);
			win.setFont(f1);
			win.setColor(Color.red);
			win.drawString("Press B to restart",100,500);
			
			
		}
		if(states==3) {//directions part
			Font f=new Font("TimesNewRoman",Font.BOLD,30);
			win.setColor(Color.white);
			win.setFont(f);
			win.setColor(Color.pink);
			win.drawString("Instructions", 335, 30);
			win.setColor(Color.white);
			win.drawString("Use A and D keys to move the paddle from left to right.",10,100);
			win.drawString(" You can also use your mouse to move the paddle, but",0,160);
			win.drawString("don't use the keyboard and the mouse simultaneously.",0,190);
			win.drawString("This game has powerups-the moving squares. Make", 0, 250);
			win.drawString("sure you use them!", 0, 280);
			win.drawString("Press B to go to the menu page!", 0, 320);
			win.setColor(Color.green);
			win.drawString("If you want a very responsive mouse control, press 1 !", 0, 400);
			win.drawString("Otherwise, If you want a mouse control that is similar", 0,450);
			win.drawString("to the key-driven paddle, press 2 !",0,480);
			
		}
	}
	
	
	
	
	
}