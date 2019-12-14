package Objects;

import java.io.IOException;

public class PotPlate extends Plate  {

	PotPlate(int color) throws IOException {
		super();
		this.setColor(color);
		setType("pot");
		this.SetSpriteImages();
		// TODO Auto-generated constructor stub
	}
	public PotPlate(int X,int Y) throws IOException
	{
		super();
		this.x=X;
		this.y=Y;
		setType("pot");
		this.setColor((int) ((Math.random()*11)));
		this.SetSpriteImages();
	}

}
