package Objects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
public class ControlBar extends Plate  implements GameObject  {
    int x,y,width,height;
    
	 public ControlBar(int x,int y)throws IOException{
		 this.x=x;
		 this.y=y;
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
		width=this.getSpriteImages()[0].getWidth();
		}
	public void setHeight(int h) {
		height=this.getSpriteImages()[0].getHeight();
		}
	public int getWidth() {
		return this.getSpriteImages()[0].getWidth();
		}
	public int getHeight() {
		return this.getSpriteImages()[0].getHeight();
		}
	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		File file=new File("plates\\bar.png");
		BufferedImage img[]=new BufferedImage[1];
		try {
			img[0]=ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
}
