package Levels;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Level  {
	
	int currentLevel;
	int PlatesSpeed=50;
	int PlayerSpeed=1;
	int SupportedColors;
	String BackgroundURl;
	Image BackgroundImg;
	int begin,end;

	public Level()
	{
		
	}
	
	public void setPlatesSpeed(int newPlatesSpeed)
	{
		this.PlatesSpeed=newPlatesSpeed;
	}
	
	public int getPlatesSpeed()
	{
		return PlatesSpeed;
	}

	public void setPlayerSpeed(int newPlayerSpeed)
	{
		this.PlayerSpeed=newPlayerSpeed;
	}
	
	public int getPlayerSpeed()
	{
		return PlayerSpeed;
	}

	public void setBackgroundURl(String Backgroundpath) throws IOException
	{
		
		this.BackgroundURl=Backgroundpath;
		File file=new File(BackgroundURl);
		BackgroundImg=ImageIO.read(file);
	}
	
	public String getBackgroundURL()
	{
		return BackgroundURl;
	}
	
	public Image getBackgroundImg()
	{
		return BackgroundImg;
	}
	
	/**
	 * if you want to have a diff background in diff levels
	 * @param colorNumbers
	 */
	public  void setSupportedColors(int colorNumbers)
	{
		SupportedColors=colorNumbers;
	}
	
	public int getSupportedColors()
	{
		return SupportedColors;

	}
	public void setcurrentLevel(int currentLevel)
	{
		this.currentLevel=currentLevel;
	}
	public abstract Level getMylevel();
	public abstract Level UpgradeLevel();
	
	public int getcurrentLevel()
	{
		return this.currentLevel;
	}
	public abstract void setLevelLimits();
	public int getbegin()
	{
		return this.begin;
	}
	public int getend()
	{
		return this.end;
	}

}

