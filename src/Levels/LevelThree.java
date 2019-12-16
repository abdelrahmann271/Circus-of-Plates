package Levels;

public class LevelThree extends Level {
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
		// TODO Auto-generated method stub
		return getInstance();
	}

	@Override
	public Level UpgradeLevel() {
		// TODO Auto-generated method stub
		System.out.println("YOU Completed The Game");
		return null;
	}

	@Override
	public void setLevelLimits() {
		// TODO Auto-generated method stub
		this.begin=101;
		this.end=Integer.MAX_VALUE;
	}
	

}
