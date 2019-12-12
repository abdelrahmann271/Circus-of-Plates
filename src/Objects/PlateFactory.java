package Objects;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PlateFactory {
	static PlateFactory pf=new PlateFactory();
	static Map<Integer,Plate> mp=new HashMap<Integer,Plate>();
	public PlateFactory getInstance()
	{
		return pf;
	}
	/**
	 * 
	 * @return random plate with random color;
	 * @throws IOException 
	 */
	public void addToGarbage(Plate garbage)
	{
		if(garbage.getType().compareTo("platewithbase")==0)
		{
			mp.put(0, garbage);
		}

		if(garbage.getType().compareTo("platewithoutbase")==0)
		{
			mp.put(1, garbage);
		}

		if(garbage.getType().compareTo("platewithdeepbase")==0)
		{
			mp.put(2, garbage);
		}

		if(garbage.getType().compareTo("pot")==0)
		{
			mp.put(3, garbage);
		}
	}
	public Plate GenerateRandomPlate() throws IOException
	{
		int plateType=(int) (Math.random()*4);
		int plateColor=(int)(Math.random()*11);
		Plate a=null;
		if(mp.get(plateType)==null)
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
		}
		a.setColor(plateColor);
		return a;
	}

}
