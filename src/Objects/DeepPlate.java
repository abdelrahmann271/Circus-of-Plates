package Objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import eg.edu.alexu.csd.oop.game.GameObject;

public class DeepPlate extends Plate {
	

	DeepPlate() throws IOException {
		super();
		this.type="platewithdeepbase";
		this.SetSpriteImages();
		// TODO Auto-generated constructor stub
	}
	public DeepPlate(int X,int Y) throws IOException
	{
		super();
		this.x=X;
		this.y=Y;
		this.type="platewithdeepbase";
		this.setColor((int) ((Math.random()*11)));
		this.SetSpriteImages();
		
	}

	
}
