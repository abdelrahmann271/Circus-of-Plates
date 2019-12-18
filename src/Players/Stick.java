package Players;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Logger.LoggerSingle;
import eg.edu.alexu.csd.oop.game.GameObject;

public class Stick extends JPanel implements GameObject {
	
	/**
	 * 
	 */
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int type; // 0 --> left , 1 --> right
	private int dx,dy;
	public Stick( int x , int y , int type  ){
		this.x=x-this.getWidth();
		this.y=y-this.getHeight();
		this.dx=this.x-(int)screenSize.getWidth()/2;
		this.dy=this.y-564*(int)screenSize.getHeight()/864;
		this.type= type ;
		setX(this.x);
		setY(this.y);
	}
	@Override

	public int getX() {

		return x;
	}

	@Override
	public void setX(int x) {

		this.x=x;
	}

	@Override
	public int getY() {

		return y;
	}

	@Override
	public void setY(int y) {

		this.y=y;
	}
	public int getdx() {
		return dx;
	}
	public int getdy() {
		return dy;
	}

	@Override
	public int getWidth() {

		return getSpriteImages()[0].getWidth();
	}

	@Override
	public int getHeight() {

		return getSpriteImages()[0].getHeight();
	}

	@Override
	public boolean isVisible() {

		return true;
	}

	@Override
	public BufferedImage[] getSpriteImages() {

		File file =new File("sticks\\"+type+"stick-resized.png");
		BufferedImage img[]=new BufferedImage[1];
		try {
			img[0]=ImageIO.read(file);
		} catch (IOException e) {
			Logger log = LoggerSingle.getInstance();
			log.setLevel(Level.ALL);
			log.severe(e.getMessage());

			e.printStackTrace();
		}
		return img;
		
		
	}

}
