package Utilities;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import Breakout.Breakout;
import Breakout.Screen;

public class Mouse implements MouseListener,MouseMotionListener {
	Breakout foo;
//If you only want this to affect individual paddles,just pass in a paddle object
public Mouse(Breakout bar) {
	foo=bar;
}







public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub


}




@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	

	
}





@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}





@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub

	//System.out.print(e.getXOnScreen()+"\n");
}





@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	//System.out.print(e.getXOnScreen()+"\n");
	
}







@Override
public void mouseDragged(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}







@Override
public void mouseMoved(MouseEvent arg0) {

	// TODO Auto-generated method stub
	System.out.print(arg0.getXOnScreen()-285+"\n");
    if(Breakout.Breakoutstate==1 && 	Breakout.Breakoutstate!=0) {
	this.foo.p.state=2;
	if(this.foo.p.state==2 && (arg0.getXOnScreen()-285>0 && arg0.getXOnScreen()-285<Screen.Width)) {
	this.foo.p.moveto(arg0.getXOnScreen()-285);
	this.foo.p.posx=arg0.getXOnScreen()-285;
	}
	
	}
}





}
