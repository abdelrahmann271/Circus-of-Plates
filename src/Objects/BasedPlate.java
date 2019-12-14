package Objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BasedPlate extends Plate {

	BasedPlate(int color) throws IOException {
		super();
		setType("platewithbase");
		this.setColor(color);
		this.SetSpriteImages();
		// TODO Auto-generated constructor stub
	}
	public BasedPlate(int X,int Y) throws IOException
	{
		super();
		this.x=X;
		this.y=Y;
		setType("platewithbase");
		this.setColor((int) ((Math.random()*11)));
		SetSpriteImages();
	}
}
