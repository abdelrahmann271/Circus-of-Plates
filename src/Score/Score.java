
package Score;

import java.util.Observable;

import Levels.LevelFactory;
import Objects.PlateFactory;


public class Score extends Observable {
	private static Score s=null;
	static int Value=0;
	public Score()
	{
		
	}
	public static Score getInstance()
	{
		if(s==null)
		{
			s=new Score();
			s.addObserver(LevelFactory.getInstance());
		}
		return s;
	}
	public void setScore(int Value)
	{
		this.Value=Value;
		setChanged();
		notifyObservers();
	}
	public int getScore()
	{
		return Value;
		
	}
	

}