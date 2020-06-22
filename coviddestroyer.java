import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.util.*;

public class CovidDestroyer extends Applet implements Runnable, KeyListener{ 
	final int LENGTH =800;
	final int WIDTH = 400;
	Random random;
	Thread thread;
	Vaccine v;
	ArrayList<Covid> c;
	ArrayList<Serum> s;
	ArrayList<Virus> d;
	Image img;
	Graphics gfx;
	boolean gameStarted;
	boolean gameOver;
	int score;
	int level;
	int reload = 0;
	int time = 0;
	
	public void init(){
		this.resize(LENGTH,WIDTH);
		thread = new Thread(this);
		this.addKeyListener(this);
		thread.start();
		random = new Random();
		v = new Vaccine();
		c = new ArrayList<Covid>();
		c.add(new Covid(random.nextInt(770), 0));
		s = new ArrayList<Serum>();
		d = new ArrayList<Virus>();
		gameStarted = false;
		gameOver = false;
		img = createImage(LENGTH, WIDTH);
		gfx = img.getGraphics();
		score = 0;
		level = 1;
	}
	
	public void paint(Graphics g){
		gfx.setColor(Color.BLACK);
		gfx.fillRect(0, 0, LENGTH, WIDTH);
		
		if(gameOver != true){
			for(int i = 0; i < c.size(); i ++){
				if(c.get(i).getY() >= 400){
					gameOver = true;
				}
			}
			
			for(int i = 0; i < d.size(); i ++){
				if(d.get(i).collision(v)){
					gameOver = true;
				}
			}
			if(!gameStarted && gameOver == false){
				gfx.setColor(Color.WHITE);
				gfx.setFont(new Font("Courier", Font.PLAIN, 64));
				gfx.drawString("COVID DESTROYER", 150, 200); 
				gfx.setFont(new Font("Courier", Font.PLAIN, 16));
				gfx.drawString("Press ENTER to Begin...", 300, 250);
			}else if(gameOver == false){
				gfx.setColor(Color.WHITE);
				gfx.setFont(new Font("Coourier", Font.PLAIN, 12));
				gfx.drawString("Score: " + score, 725, 15);
				//gfx.drawString("Ammo: " + time / 10, 725, 390);
				v.draw(gfx);
				for(int j = 0; j < c.size(); j ++){
					c.get(j).draw(gfx);
				}
				for(int j = 0; j < s.size(); j ++){
					s.get(j).draw(gfx);
				}
				for(int j = 0; j < d.size(); j ++){
					d.get(j).draw(gfx);
				}
			}
		}else {
			gfx.setColor(Color.WHITE);
			gfx.setFont(new Font("Courier", Font.PLAIN, 64));
			gfx.drawString("GAME OVER", 225, 100);
			gfx.drawString("FINAL SCORE: " + score, 125, 200);
		}
		g.drawImage(img, 0, 0, this);
	}
	
	public void repaint(Graphics g){
		paint(g);
	}
	
	public void run(){
		while(true){
			if(gameOver) {
				repaint();
				break;
			}
			if(gameStarted){
				if(c.size() == 0){ 
					level = score / 50 + 1;
					for(int i = 0; i < level; i ++){
						c.add(new Covid(random.nextInt(770), 0));
					}
				}
				
				for(int i = 0; i < s.size(); i ++){
					for(int j = 0; j < c.size(); j ++){
						if(s.get(i).collision(c.get(j))){
							score += 10;
							c.remove(j);
						}
						if(s.get(0).getY() <= 0) {
							s.remove(0);
						}
					}
				}
				
				if(d.size() != 0 && d.get(0).getY() > 390) {
					d.remove(0);
				}
					
				for(int i = 0; i < c.size(); i ++) {
					c.get(i).move(level);
				}
				
				for(int i = 0; i < s.size(); i ++) {
					s.get(i).move();
				}
				
				for(int i = 0; i < d.size(); i ++) {
					d.get(i).move();
				}
				
				if(reload > 10){
					s.add(new Serum(v));
					reload -= 10;
				}
				
				if(time > 30){
					for(int j = 0; j < c.size(); j ++){
						d.add(new Virus(c.get(j)));
					}
					time -= 30;
				}
			}
			
			repaint();
			
			try{
				Thread.sleep(100);
				reload ++;
				time ++;
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			gameStarted = true;
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			v.move(1);
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			v.move(-1);
		}
	}
	
	public void keyTyped(KeyEvent e){
	}
	
	public void keyReleased(KeyEvent e){
	}
}