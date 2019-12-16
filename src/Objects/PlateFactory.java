package Objects;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import Levels.Level;
import Levels.LevelFactory;

public class PlateFactory implements Observer {
	private static PlateFactory pf=null;
	static Map<Integer,Vector<Plate>> Garbage=new HashMap<Integer,Vector<Plate>>();
	public static int SupportedColors=3;
	public static PlateFactory getUniqueInstance()
	{
		if(pf==null)
		{
			pf=new PlateFactory();
		}
		return pf;
	}
	private PlateFactory() {
		// TODO Auto-generated constructor stub
	}
	public static void setSupportedColors(int n)
	{
		SupportedColors=n;
	}
	public static int getSupportedColors()
	{
		return SupportedColors;
	}
	/**
	 * 
	 * 
	 * @return random plate with random color;
	 * @throws IOException 
	 */
	public void addToGarbage(Plate garbage)
	{
		Vector<Plate>v=new Vector<Plate>();
		
		if(garbage.getType().compareTo("platewithbase")==0)
		{
			if(Garbage.get(0)!=null)
			v=Garbage.get(0);
			v.add(garbage);
			Garbage.put(0, v);
			return ;
		}

		if(garbage.getType().compareTo("platewithoutbase")==0)
		{
			if(Garbage.get(1)!=null)
			v=Garbage.get(1);
			v.add(garbage);
			Garbage.put(1, v);
			return;
		}

		if(garbage.getType().compareTo("platewithdeepbase")==0)
		{
			if(Garbage.get(2)!=null)
			v=Garbage.get(2);
			v.add(garbage);
			Garbage.put(2, v);
			return;
		}

		if(garbage.getType().compareTo("pot")==0)
		{
			if(Garbage.get(3)!=null)
			v=Garbage.get(3);
			v.add(garbage);
			Garbage.put(3, v);
			return;
		}
		
	}
	public Plate GenerateRandomPlate(String s) throws IOException
	{
		int plateType=(int) (Math.random()*4);
		//System.out.println(SupportedColors);
		int plateColor=(int)(Math.random()*SupportedColors);
		Plate a=null;
		if(Garbage.get(plateType)==null||Garbage.get(plateType).size()==0)
		{
			if(plateType==0)//BasedPlate
			{
				a=new BasedPlate(plateColor);
                
			}
			else if(plateType==1)//nonBasedPlate
			{
				a=new NonBasedPlate(plateColor);
			}
			else if(plateType==2)//deepPlate
			{
				a=new DeepPlate(plateColor);
			}
			else//potplate
			{
				a=new PotPlate(plateColor);
			}
			if(s=="left") {
				a.setX(-150);
				a.setY(75-a.getHeight());
				a.setType(s);
			}
			else {
				a.setX(1610);
				a.setY(75-a.getHeight());
				a.setType(s);
			}
			
			a.setColor(plateColor);
		}
		else
		{
			
			//System.out.println("ReUsed");
			Vector<Plate>v=new Vector<Plate>();
			v=Garbage.get(plateType);
			a=v.firstElement();
			v.remove(0);
			Garbage.put(plateType, v);
			if(s=="left") {
				a.setX(-150);
				a.setY(75-a.getHeight());
				a.setType(s);
			}
			else {
				a.setX(1610);
				a.setY(75-a.getHeight());
				a.setType(s);
			}
		}

		return a;
	}
	@Override
	public void update(Observable NewLevelFactory, Object arg) {

		PlateFactory b=PlateFactory.getUniqueInstance();
		Level f=LevelFactory.getInstance().getMyLevel();
		//b.setSupportedColors(f.getSupportedColors());
		PlateFactory.setSupportedColors(f.getSupportedColors());
		System.out.println("From update method in PlateFactory : level is" + LevelFactory.getInstance().getMyLevel());
		System.out.println("Supported Colours are .. " + f.getSupportedColors());
	}

}