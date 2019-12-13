package Objects;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
public class ConstantBar extends Plate implements GameObject {
   int x,y,length,width;
   	
	public ConstantBar(int x,int y) throws IOException {
		this.x=x;
		this.y=y;
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
		return getSpriteImages()[0].getWidth() ;
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

}
