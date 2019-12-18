package Levels;

import java.awt.Color;

public class LevelThree extends Level {
	
	public Color lvlColor = Color.darkGray;
	
	public static Level L3=null;
	public static  Level getInstance() {
		if(L3==null)
		{
			L3=new LevelThree();
		}
		return L3;
	}
	public LevelThree()
	{
		setcurrentLevel(3);
		setPlatesSpeed(20);
		setSupportedColors(11);
		setLevelLimits();
	}

	@Override
	public Level getMylevel() {

		return getInstance();
	}

	@Override
	public Level UpgradeLevel() {

		System.out.println("YOU Completed The Game");
		return null;
	}

	@Override
	public void setLevelLimits() {

		this.begin=101;
		this.end=Integer.MAX_VALUE;
	}
	@Override
	public Color getBackground()
	{
		return this.lvlColor;
	}
	@Override
	public int getPlatesSpeed()
	{
		return 20;
	}
	
}
