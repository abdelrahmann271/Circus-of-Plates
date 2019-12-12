package eg.edu.alexu.csd.oop.game.Object;

import java.io.IOException;

public class PotPlate extends Plate  {

	PotPlate() throws IOException {
		super();
		setType("pot");
		// TODO Auto-generated constructor stub
	}
	PotPlate(int X,int Y) throws IOException
	{
		super();
		this.x=X;
		this.y=Y;
		setType("pot");
		this.SetSpriteImages();
	}

}
