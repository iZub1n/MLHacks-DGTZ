import java.awt.*;
import java.util.*;

public class Serum{
	int x;
	int y;
	
	public Serum(Vaccine v){
		x = v.getX();
		y = v.getY();
	}
	
	public int getY() {
		return y;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 4, 7);
	}
	
	public void move(){
		y -= 20;
	}
	
	public boolean collision(Covid c){
		if(y <= c.getY() && x >= c.getX() && x <= c.getX() + 45){
			return true;
		}
		return false;
	}
}
