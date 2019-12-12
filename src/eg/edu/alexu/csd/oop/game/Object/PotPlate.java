package eg.edu.alexu.csd.oop.game.Object;

import java.io.IOException;

public class PotPlate extends Plate  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PotPlate() throws IOException {
		super();
		setType("pot");
		this.SetSpriteImages();
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
