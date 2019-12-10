package habd;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
public class bar extends JPanel  {
    int x=400;
    


	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, 500, 50, 10);
		
	}
	public int getX() {return x;}
	public void setX(int X) {x=X;}
}