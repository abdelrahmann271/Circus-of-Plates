package eg.edu.alexu.csd.oop.game.Object;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
public class bar extends JPanel implements GameObject  {
    int x=400,y=500;
    
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 50, 10);
		
	}
	public int getX() {return x;}
	public void setX(int X) {x=X;}
	public void setY(int Y) {y=Y;}
	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		return null;
	}
}
