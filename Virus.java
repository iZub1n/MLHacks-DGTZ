import java.awt.*;
import java.util.*;

public class Virus{
	int x;
	int y;
	
	public Virus(Covid c){
		x = c.getX() + 25;
		y = c.getY();
	}
	
	public int getY() {
		return y;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, 4, 7);
	}
	
	public void move(){
		y += 10;
	}
	
	public boolean collision(Vaccine v){
		if(y >= v.getY() && x >= v.getX() - 5 && x <= v.getX() + 5){
			return true;
		}
		return false;
	}
}
