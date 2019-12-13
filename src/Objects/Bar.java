package Objects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
<<<<<<< Upstream, based on origin/ayman
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;

public class Bar extends JPanel implements GameObject  {
//    int x=100,y=500,width,height;
//    
//	public void draw(Graphics g) {
//		g.setColor(Color.blue);
//		g.fillRect(x, y, width, 10);
//		
//	}
//	public int getX() {
//		return x;
//		}
//	public int getY() {
//		return y;
//		}
//	public void setX(int X) {
//		x=X;
//		}
//	public void setY(int Y) {
//		y=Y;
//		}
//	public void setWidth(int w) {
//		width=w;
//		}
//	public void setHeight(int h) {
//		height=h;
//		}
//	public int getWidth() {
//		return width;
//		}
//	public int getHeight() {
//		return height;
//		}
//	@Override
//	public BufferedImage[] getSpriteImages() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	private static final int MAX_MSTATE = 1;
	// an array of sprite images that are drawn sequentially
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	private int x;
	private int y;
	private boolean visible;
	private int type;
	
	public Bar(int posX, int posY, String path){
		this(posX, posY, path, 0);
	}
	
	public Bar(int posX, int posY, String path, int type){
		this.x = posX;
		this.y = posY;
		this.type = type;
		this.visible = true;
		// create a bunch of buffered images and place into an array, to be displayed sequentially
		try {
			//spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
			File f = new File(path);
			spriteImages[0] = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int mX) {
		this.x = mX;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int mY) {
		this.y = mY;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;
	}

	@Override
	public int getWidth(){
		return spriteImages[0].getWidth();
	}

	@Override
	public int getHeight() {
		return spriteImages[0].getHeight();
	}

	@Override
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
=======

import javax.swing.JPanel;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;

public class Bar extends JPanel implements GameObject  {
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
>>>>>>> 1b9091a d
	}
}
