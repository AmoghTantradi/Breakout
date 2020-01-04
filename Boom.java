package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;

public class Boom {
 Particle [] shower=new Particle[100];
 static Color initial=Color.orange;
 public Boom(Ball ball) {
	 for (int i=0;i<shower.length;i++) {
		shower[i]=new Particle(ball);
	 }
 }
 
 public void update() {
	 for(Particle p:shower) {
		 p.update();
		 p.changeCol(initial);
	 }
 }
 
 public void draw(Graphics2D win) {
	 for(Particle p:shower) {
		 p.draw(win);
	 }
 }

}