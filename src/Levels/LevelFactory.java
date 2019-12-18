package Levels;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;

import Logger.LoggerSingle;
import Objects.PlateFactory;
import Score.Score;

public class LevelFactory extends Observable implements Observer  {
	private static LevelFactory lf=null;
	public static Level One =LevelOne.getInstance();
	private static Level Two =LevelTwo.getInstance();
	private static Level Three =LevelThree.getInstance();
	public static Level MyLevel=One;
	public static LevelFactory getInstance()
	{
		if(lf==null)
		{
			lf=new LevelFactory();
			lf.addObserver(PlateFactory.getUniqueInstance());
		}
		return lf;
	}
	public void setMyLevel(Level CurrentLevel)
	{
		this.MyLevel=CurrentLevel.getMylevel();
		setChanged();
		notifyObservers();
		
	}
	public Level getMyLevel()
	{
		return MyLevel;
	}
	public Level getCertainLevel(int LevelNumber)
	{
		if(LevelNumber==1)
		{
			return One;
		}
		else if(LevelNumber==2)
		{
			return Two;
		}
		return Three;
	}
	public Level UpgradeMyLevel(Level MyLevel)
	{
		if(MyLevel.getcurrentLevel()==3)
		{
			return Three;//stays at three
		}
		Level a= MyLevel.UpgradeLevel();
		this.MyLevel=a;
			Logger log = LoggerSingle.getInstance();
			log.setLevel(java.util.logging.Level.ALL);
			log.info("level is upgraded to level " + MyLevel.getcurrentLevel());
		setChanged();
		notifyObservers();
		
		return a;
		
	}

	public Level getLevelByScore(Score Score)
	{
		Level a = null;
		if(Score.getScore()>=One.begin&&Score.getScore()<=One.end)
		{
			a=One;
		}
		else if(Score.getScore()>=Two.begin&&Score.getScore()<=Two.end)
		{
			a=Two;;
		}
		else if(Score.getScore()>=Three.begin)
		{
			 a=Three;
		}
		return a;
	}
	@Override
	public void update(Observable Score, Object arg) {
		// TODO Auto-generated method stub
		this.MyLevel=LevelFactory.getInstance().getLevelByScore((Score) Score);
		setChanged();
		notifyObservers();
	}

}
