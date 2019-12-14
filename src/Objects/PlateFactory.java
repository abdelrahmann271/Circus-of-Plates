package Objects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class PlateFactory {
	int supportedColors=11;
	static PlateFactory pf=new PlateFactory();
	static Map<Integer,Vector<Plate>> Garbage=new HashMap<Integer,Vector<Plate>>();
	public PlateFactory getInstance()
	{
		return pf;
	}
	/**
	 * number of supported plate colors 1-11
	 * @param n
	 */
	public void setSupportedColors(int n)
	{
		supportedColors=n;
	}
	public int getSupportedColors()
	{
		return supportedColors;
	}
	
	/**
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
	public Plate GenerateRandomPlate() throws IOException
	{
		int plateType=(int) (Math.random()*4);
		int plateColor=(int)(Math.random()*supportedColors);
		Plate a=null;
		if(Garbage.get(plateType)==null||Garbage.get(plateType).size()==0)
		{
			if(plateType==0)//BasedPlate
			{
				a=new BasedPlate();
			}
			else if(plateType==1)//nonBasedPlate
			{
				a=new NonBasedPlate();
			}
			else if(plateType==2)//deepPlate
			{
				a=new DeepPlate();
			}
			else//potplate
			{
				a=new PotPlate();
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
		}

		return a;
	}

}
