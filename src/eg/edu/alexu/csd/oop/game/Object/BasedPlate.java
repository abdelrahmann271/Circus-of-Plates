package eg.edu.alexu.csd.oop.game.Object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BasedPlate extends Plate {

	BasedPlate() throws IOException {
		super();
		setType("platewithbase");
		this.SetSpriteImages();
		// TODO Auto-generated constructor stub
	}
	BasedPlate(int X,int Y) throws IOException
	{
		super();
		this.x=X;
		this.y=Y;
		setType("platewithbase");
		SetSpriteImages();
	}
}
