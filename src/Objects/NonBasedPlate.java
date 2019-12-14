package Objects;

import java.io.IOException;

public class NonBasedPlate  extends Plate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	NonBasedPlate() throws IOException {
		super();
		setType("platewithoutbase");
		SetSpriteImages();
	}
	public NonBasedPlate(int X,int Y) throws IOException
	{
		super();
		this.x=X;
		this.y=Y;
		this.setColor((int) ((Math.random()*11)));
		setType("platewithoutbase");
		SetSpriteImages();
	}

}
