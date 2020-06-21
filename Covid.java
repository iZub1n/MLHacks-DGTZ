import java.awt.*;

public class Covid{
	int x;
	int y;
	int direction = 0;
	
	public Covid(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x - 10;
	}
	
	public int getY() {
		return y + 35;
	}
	
	public void draw(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(7));
		g2.setColor(Color.BLACK);
		g2.fillOval(x, y, 30, 30);
		g2.fillOval(x - 10, y - 10, 10, 10);
		g2.drawLine(x + 15, y + 15, x - 5, y - 5);
		g2.fillOval(x + 30, y - 10, 10, 10);
		g2.drawLine(x + 15, y + 15, x + 35, y - 5);
		g2.fillOval(x - 10, y + 30, 10, 10);
		g2.drawLine(x + 15, y + 15, x - 5, y + 35);
		g2.fillOval(x + 30, y + 30, 10, 10);
		g2.drawLine(x + 15, y + 15, x + 35, y + 35);
		g2.drawOval(x + 13, y - 7, 4, 4);
		g2.drawLine(x + 15, y - 5, x + 15, y + 15);
		g2.drawOval(x + 13, y + 33, 4, 4);
		g2.drawLine(x + 15, y + 35, x + 15, y + 15);
		g2.drawOval(x - 7, y + 13, 4, 4);
		g2.drawLine(x - 5, y + 15, x + 15, y + 15);
		g2.drawOval(x + 33, y + 13, 4, 4);
		g2.drawLine(x + 35, y + 15, x + 15, y + 15);
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.MAGENTA);
		g2.fillOval(x + 2, y + 2, 26, 26);
		g2.fillOval(x - 8, y - 8, 6, 6);
		g2.drawLine(x + 15, y + 15, x - 5, y - 5);
		g2.fillOval(x + 32, y - 8, 6, 6);
		g2.drawLine(x + 15, y + 15, x + 35, y - 5);
		g2.fillOval(x - 8, y + 32, 6, 6);
		g2.drawLine(x + 15, y + 15, x - 5, y + 35);
		g2.fillOval(x + 32, y + 32, 6, 6);
		g2.drawLine(x + 15, y + 15, x + 35, y +35);
		g2.drawOval(x + 13, y - 7, 4, 4);
		g2.drawLine(x + 15, y - 5, x + 15, y + 15);
		g2.drawOval(x + 13, y + 33, 4, 4);
		g2.drawLine(x + 15, y + 35, x + 15, y + 15);
		g2.drawOval(x - 7, y + 13, 4, 4);
		g2.drawLine(x - 5, y + 15, x + 15, y + 15);
		g2.drawOval(x + 33, y + 13, 4, 4);
		g2.drawLine(x + 35, y + 15, x + 15, y + 15);
	}
	
	public void move(int level){
		if(x <= 0){
			y += 45;
			x += level;
			direction = 0;
		}else if(x >= 770){
			y += 45;
			x -= level;
			direction = 1;
		}else if(direction == 0){
			x += level;
		}else if(direction == 1){
			x -= level;
		}
	}
}