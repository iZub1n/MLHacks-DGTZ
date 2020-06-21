import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class game extends Applet implements Runnable, KeyListener {
  
  final int LENGTH = 700;
  final int WIDTH = 400;
  Thread thread;
  Vaccine v;
  Covid c;
  boolean gameStarted;

  public void init(){
    this.resize(LENGTH,WIDTH);
    thread = new Thread(this);
    this.addKeyListener(this);
    thread.start();
    v = new Vaccine();
    c = new Covid();
    gameStarted = true;
  }

  public void paint(Graphics g) {
    g.setColor(Color.black);
    g.fillRect(0, 0, LENGTH, WIDTH);

    v.draw(g);
    c.draw(g);

  }

  public void repaint(Graphics g) {
    paint(g);
  }

  public void run() {
		while (true){
			if (gameStarted){
				c.move();
			}
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      v.direction(1);
    }
    else if (e.getKeyCode() == KeyEvent.VK_LEFT){
      v.direction(-1);
    }
  }

  public void keyTyped(KeyEvent e){

  }

public void keyReleased(KeyEvent arg0) {

	
}

}