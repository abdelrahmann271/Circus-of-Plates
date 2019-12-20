package Objects;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
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
	 private Class[]arr1 = new Class[4];
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int index=1;
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
    public void DynamicLoad(String jarPath)
    {
        URLClassLoader child = null;
        try {
            child = new URLClassLoader(
                    new URL[]{Paths.get(jarPath).toUri().toURL()},
                    this.getClass().getClassLoader()
            );
            if(jarPath.contains("PotPlate")) {
            Class<? extends Plate> classToLoad = (Class<? extends Plate>) Class.forName("Objects.PotPlate", true, child);
            System.out.println(classToLoad.getName());
                   arr1[index++]=classToLoad;
                   
            }
            else if(jarPath.contains("NonBasedPlate")) {
                Class<? extends Plate> classToLoad = (Class<? extends Plate>) Class.forName("Objects.NonBasedPlate", true, child);
                System.out.println(classToLoad.getName());
                System.out.println("d5l hna");
                arr1[index++]=classToLoad;
                }
            else if(jarPath.contains("DeepPlate")) {
                Class<? extends Plate> classToLoad = (Class<? extends Plate>) Class.forName("Objects.DeepPlate", true, child);
                System.out.println(classToLoad.getName());
                           arr1[index++]=classToLoad;
                }
        } catch (MalformedURLException | ClassNotFoundException e) {
            ((Throwable) e).printStackTrace();
        }
        
    }

//// pf.DynamicLoad("D:\\projects\\Circus5\\src\\Objects\\DeepPlate.jar",1);
 
//// pf.DynamicLoad("D:\\projects\\Circus5\\src\\Objects\\NonBasedPlate.jar",2);

	public Plate GenerateRandomPlate(String s) throws IOException
	{
		int plateType=(int) (Math.random()*index);
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

				try {
					a=(Plate) arr1[1].newInstance();
					a.setColor(plateColor);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				a=new NonBasedPlate(plateColor);
			}
			else if(plateType==2)//deepPlate
			{

				try {
					a=(Plate) arr1[2].newInstance();
					a.setColor(plateColor);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
							//				a=new DeepPlate(plateColor);
			}
			else//potplate
			{

				try {
					a=(Plate) arr1[3].newInstance();
					a.setColor(plateColor);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				a=new PotPlate(plateColor);
			}
			if(s=="left") {
				a.setX(-150*(int)screenSize.getWidth()/1536);
				a.setY(75*(int)screenSize.getHeight()/864-a.getHeight());
				a.Setdirection(s);
			}
			else {
				a.setX(1610*(int)screenSize.getWidth()/1536);
				a.setY(75*(int)screenSize.getHeight()/864-a.getHeight());
				a.Setdirection(s);
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
				a.setX(-150*(int)screenSize.getWidth()/1536);
				a.setY(75*(int)screenSize.getHeight()/864-a.getHeight());
				a.Setdirection(s);
			}
			else {
				a.setX(1610*(int)screenSize.getWidth()/1536);
				a.setY(75*(int)screenSize.getHeight()/864-a.getHeight());
				a.Setdirection(s);
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
		//System.out.println("From update method in PlateFactory : level is" + LevelFactory.getInstance().getMyLevel());
		//System.out.println("Supported Colours are .. " + f.getSupportedColors());
	}

}