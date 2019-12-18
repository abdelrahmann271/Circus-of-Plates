
package Score;

import java.util.Observable;
import java.util.Observer;
import Levels.LevelFactory;



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