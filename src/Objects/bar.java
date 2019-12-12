package Objects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
public class bar extends JPanel implements GameObject  {
    int x=400,y=500,width,height;
    
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, 10);
		
	}
	public int getX() {
		return x;
		}
	public int getY() {
		return y;
		}
	public void setX(int X) {
		x=X;
		}
	public void setY(int Y) {
		y=Y;
		}
	public void setWidth(int w) {
		width=w;
		}
	public void setHeight(int h) {
		height=h;
		}
	public int getWidth() {
		return width;
		}
	public int getHeight() {
		return height;
		}
	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		return null;
	}
}
