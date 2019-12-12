package eg.edu.alexu.csd.oop.game.Object;

import java.io.IOException;

public class NonBasedPlate  extends Plate {

	NonBasedPlate() throws IOException {
		super();
		setType("platewithoutbase");
		SetSpriteImages();
		// TODO Auto-generated constructor stub
	}
	NonBasedPlate(int X,int Y) throws IOException
	{
		super();
		this.x=X;
		this.y=Y;
		setType("platewithoutbase");
		SetSpriteImages();
	}

}
