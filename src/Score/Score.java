package Score;

import java.util.Observable;


public class Score extends Observable {
	int Value=0;
	public Score()
	{
		
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
		//a7a
	}
	

}
