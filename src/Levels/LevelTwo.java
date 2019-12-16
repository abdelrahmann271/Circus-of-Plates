package Levels;

public class LevelTwo extends Level{
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
		// TODO Auto-generated method stub
		return getInstance();
	}

	@Override
	public Level UpgradeLevel() {
		// TODO Auto-generated method stub
		return LevelThree.getInstance();
	}

	@Override
	public void setLevelLimits() {
		// TODO Auto-generated method stub
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


	

}
