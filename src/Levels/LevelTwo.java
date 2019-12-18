package Levels;

import java.awt.Color;

public class LevelTwo extends Level{
	
	public Color lvlColor = Color.gray;
	
	public static Level L2=null;
	public LevelTwo()
	{
		setcurrentLevel(2);
		setPlatesSpeed(35);
		setSupportedColors(6);
		setLevelLimits();
	}
	
	@Override
	public Level getMylevel() {

		return getInstance();
	}

	@Override
	public Level UpgradeLevel() {

		return LevelThree.getInstance();
	}

	@Override
	public void setLevelLimits() {
		
		this.begin=50;
		this.end=100;
	}	
	public static  Level getInstance() {
		if(L2==null)
		{
			L2=new LevelTwo();
		}
		return L2;
	}
	@Override
	public Color getBackground()
	{
		return this.lvlColor;
	}
	@Override
	public int getPlatesSpeed()
	{
		return 15;
	}

}
