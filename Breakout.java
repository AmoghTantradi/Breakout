package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import Utilities.GDV5;
import Utilities.Mouse;
import Utilities.SoundDriver;


@SuppressWarnings("serial")
public class Breakout extends GDV5 {
	public static int Breakoutstate = 0;
	static int rows = 6;
	static int columns = 10;
	static Brick[] wall = new Brick[rows * columns];
	static Color[] choices = new Color[6];
	static int level = 1;
	public Paddle p = new Paddle(GDV5.KeysPressed);
	public String[] sounds = new String[5];
	public SoundDriver Dn=null;
	public Ball b = new Ball(380, 425, wall, p);
	public Boom boom = null;
	public Screen s = new Screen();
	public Powerup P = new Powerup(350, b, p, 1);// increases length
	public Powerup w = new Powerup(230, b, p, 0);
	public Powerup m = new Powerup(450, b, p, 0);

	public void colorinitialize() {
		choices[0] = Color.red;
		choices[1] = Color.orange;
		choices[2] = Color.LIGHT_GRAY;
		choices[3] = Color.yellow;
		choices[4] = Color.green;
		choices[5] = Color.blue;
	}

	public Breakout() {
		
		// initializes the Bricks
		super(60);
		this.colorinitialize();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				wall[i * columns + j] = new Brick((Brick.width + Brick.xBuffer) * j, (Brick.height + Brick.yBuffer) * i,
						1, choices[i]);
			}
		}

		sounds[0] = "sound.wav";
		sounds[1]= "scarySound.wav";
		sounds[2]="RainSound.wav";
		sounds[3]="ponghit.wav";
		sounds[4]="Endgame.wav";
		Dn = new SoundDriver(this.sounds, this);
	}

//main
	public static void main(String[] args) {

		Breakout b = new Breakout();
		Mouse m = new Mouse(b);
		b.addMouseListener(m);
		b.addMouseMotionListener(m);
		b.setTitle("Breakout");
		b.setBackground(Color.black);
		b.start();
	}

	@Override
	public void update() {

	
		
		// starts the game
		if (KeysPressed[KeyEvent.VK_ENTER] && Breakoutstate == 0) {
			Breakoutstate = 1;
			b.setVelocity(5, 6);
			Screen.states = 1;

		}
		// resets the values
		if (KeysPressed[KeyEvent.VK_B]) {
	
			this.b.reset();
		}
		if (KeysPressed[KeyEvent.VK_V]) {
			Screen.states = 3;
		}
		if(KeysPressed[KeyEvent.VK_1]) this.p.paddle_version=1;
		else if (KeysPressed[KeyEvent.VK_2]) this.p.paddle_version=2;

		if (boom != null) boom.update();
		if (Brick.boomTown) {
			boom = new Boom(b);
			Brick.boomTown = false;
		}
		P.update();
		w.update();
		p.update();
		b.update(Dn);
		s.update(Dn);
		m.update();

	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
	
			s.draw(win,this);

		}

	}