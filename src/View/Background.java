package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Background implements GameObject {
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 	private final double width = screenSize.getWidth();
 	private final double height = screenSize.getHeight();
 	
	public Background(int n) {
		this.Num=n;
	}
	
	int Num;
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		//return (int) width/2-1366/2;
		//return 1366/2;
		return 0;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		//return (int) height/2-668/2;
		return 0;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		//return getSpriteImages()[0].getWidth();
		return (int) width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		//return getSpriteImages()[0].getHeight();
		return (int) height;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
	public void setNum(int n) {
		this.Num=n;
	}
	public int getNum() {
		return Num;
	}

	@Override
	public BufferedImage[] getSpriteImages() {

		File file =new File("backgrounds\\background_"+Num+".png");
		BufferedImage img[]=new BufferedImage[1];
		try {
			img[0]=ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

}