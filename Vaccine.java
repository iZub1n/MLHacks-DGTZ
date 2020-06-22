import java.awt.*;

public class Vaccine{	
	int x;
	int y;
	
	public Vaccine(){
		x = 395;
		y = 395;
	}
	
	public int getX(){
		return x + 3;
	}
	
	public int getY(){
		return y - 51;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.drawRect(x, y, 7, 1);
		g.drawRect(x + 1, y - 5, 5, 5);
		g.drawRect(x - 1, y - 25, 9, 20);
		g.drawRect(x + 1, y - 31, 5, 6);
		g.drawRect(x + 3, y - 41, 1, 10);
		g.setColor(Color.GREEN);
		g.fillRect(x + 1, y - 15, 6, 10);
		g.setColor(Color.WHITE);
		g.drawRect(x - 1, y - 9, 3, 1);
		g.drawRect(x - 1, y - 13, 3, 1);
		g.drawRect(x - 1, y - 17, 3, 1);
		g.drawRect(x - 1, y - 21, 3, 1);	
	}
	
	public void move(int d){	
		if(d == 1 && x < 785){
			x += 5;
		}else if(d == -1 && x > 5){
			x -= 5;
	    }
	}
}