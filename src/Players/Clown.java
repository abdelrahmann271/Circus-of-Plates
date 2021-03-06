package Players;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import Logger.LoggerSingle;
import eg.edu.alexu.csd.oop.game.GameObject;

public class Clown implements GameObject {
	
	private static final int MAX_MSTATE = 1;
	// an array of sprite images that are drawn sequentially
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	private int x;
	private int y;
	private boolean visible;
	private int type;
	
	public Clown(int posX, int posY, String path){
		this(posX, posY, path, 0);
	}
	
	public Clown(int posX, int posY, String path, int type){
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
			Logger log = LoggerSingle.getInstance();
			log.setLevel(Level.ALL);
			log.severe(e.getMessage());
			e.printStackTrace();
		}
	}

//	public Clown() {
//
//	}
	
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
	}
	
}

