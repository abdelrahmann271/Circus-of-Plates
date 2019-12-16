package Objects;

import java.io.IOException;

public class NonBasedPlate  extends Plate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	NonBasedPlate(int color) throws IOException {
		super();
		setType("platewithoutbase");
		this.setColor(color);
		SetSpriteImages();
		// TODO Auto-generated constructor stub
	}
	NonBasedPlate() throws IOException {
		super();
		setType("platewithoutbase");
		SetSpriteImages();
		// TODO Auto-generated constructor stub
	}
	public NonBasedPlate(int X,int Y) throws IOException
	{
		super();
		this.x=X;
		this.y=Y;
		//this.setColor((int) ((Math.random()*11)));
		setType("platewithoutbase");
		SetSpriteImages();
	}

}
