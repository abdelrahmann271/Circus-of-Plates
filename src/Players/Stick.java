package Players;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Stick extends JPanel implements GameObject {
	int x=150-this.getWidth(),y=600-this.getHeight();
	public Stick(){
		int x=150-this.getWidth(),y=600-this.getHeight();
		setX(x);
		setY(y);
	}
	@Override

	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x=x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y=y;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return getSpriteImages()[0].getWidth();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return getSpriteImages()[0].getHeight();
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		File file =new File("sticks\\leftstick_1.png");
		BufferedImage img[]=new BufferedImage[1];
		try {
			img[0]=ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
		
		
	}

}
