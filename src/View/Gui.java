package View;
 import java.awt.Color;
 import java.awt.Dimension;

 import java.awt.Toolkit;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
 import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
 import javax.swing.JMenuBar;
 import javax.swing.JMenuItem;

import Levels.LevelFactory;
import Logger.LoggerSingle;
import Score.*;
import SnapShot.Memento;
import SnapShot.Originator;
import Objects.*;
 import Players.*;
import eg.edu.alexu.csd.oop.game.GameEngine;
 import eg.edu.alexu.csd.oop.game.GameObject;
 import eg.edu.alexu.csd.oop.game.World;
 import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
 import View.Background;
 
 public class  Gui implements World {
	 	
	Score score = Score.getInstance();
	private static List<GameObject> constant = new LinkedList<GameObject>();
	private static List<GameObject> moving = new LinkedList<GameObject>();
	private static List<GameObject> control = new LinkedList<GameObject>();
	private  List<Memento> mementos = new LinkedList<Memento>();
	private static Logger log = LoggerSingle.getInstance();
	static JMenuBar  menuBar;
	private int create=0,iterator=0;
	private int movingObjectsSpeed=50;
	private boolean gameover=false;
	private boolean win=false;
	private int HighestScore;
 	private Iterator t=null;
	private PlateFactory pf= PlateFactory.getUniqueInstance();
	private LevelFactory lf = LevelFactory.getInstance();
	private Context context=new Context();
	private static  Color levelColor;
	static GameController gameController;

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 	private final double width = screenSize.getWidth();
 	private final double height = screenSize.getHeight();
 	
 	  public static void main(String[]agrs) throws IOException {
 		  

	  
 			menuBar = new JMenuBar();
 			JMenu menu = new JMenu("File");
 			JMenuItem newMenuItem = new JMenuItem("New");
 			JMenuItem pauseMenuItem = new JMenuItem("Pause");
 			JMenuItem resumeMenuItem = new JMenuItem("Resume");
 			menu.add(newMenuItem);
 			menu.addSeparator();
 			menu.add(pauseMenuItem);
 			menu.add(resumeMenuItem);
 			menuBar.add(menu);
 			gameController = GameEngine.start("Circus of plates", new View.Gui(), menuBar, levelColor);			
 			newMenuItem.addActionListener(new ActionListener() {
 			@Override public void actionPerformed(ActionEvent e) {
 					try {
						gameController.changeWorld(new View.Gui());
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
 	 				log.setLevel(Level.ALL);
 	 				log.info("game start");
 				}
 			});
 			pauseMenuItem.addActionListener(new ActionListener() {
 			@Override public void actionPerformed(ActionEvent e) {
 					gameController.pause();
 	 				log.setLevel(Level.ALL);
 	 				log.info("game paused");
 				}
 			});
 			resumeMenuItem.addActionListener(new ActionListener() {
 				@Override public void actionPerformed(ActionEvent e) {
 					gameController.resume();
 	 				log.setLevel(Level.ALL);
 	 				log.info("game resumed");
 				}
 			});	  
 	  }
 	  public  Gui() throws NumberFormatException, IOException  {
 		  
 		/* pf.DynamicLoad("C:\\Users\\OWNER\\eclipse-workspace\\circus14\\src\\Objects\\PotPlate.jar",0);

 		 pf.DynamicLoad("C:\\Users\\OWNER\\eclipse-workspace\\circus14\\src\\Objects\\NonBasedPlate.jar",1);
 		 
 		 pf.DynamicLoad("C:\\Users\\OWNER\\eclipse-workspace\\circus14\\src\\Objects\\DeepPlate.jar",2);*/
 		pf.index=1;
 		pf.DynamicLoad("Objects\\DeepPlate.jar");
 		pf.DynamicLoad("Objects\\NonBasedPlate.jar");
 		pf.DynamicLoad("Objects\\PotPlate.jar");
 		
 		 
// 		try {
//			JFileChooser filechooser = new JFileChooser();
//			filechooser.setDialogTitle("shapes");
//			
//			filechooser.setMultiSelectionEnabled(true);
//			java.io.File[] file = null;
//			
//			if(filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
//			{
//				file = filechooser.getSelectedFiles();
//			}
//		   for(int i=0;i<file.length;i++) {
//			   pf.DynamicLoad(file[i].getAbsolutePath());
//		   }
//			try {
//				//pf.DynamicLoad(spath);
//			} catch (Exception e2) {
//				
//			}
//				
//		} catch (Exception e2) {
//		
// 		/*JFrame fr=new JFrame("Plate Shape");
//		fr.setBackground(Color.pink);
//		fr.getContentPane().setLayout(null);
//		fr.setBounds(259, 115, 500, 500);
//		fr.getContentPane().setBackground(Color.pink);
//		fr.setVisible(true);*/
//      } 
		  	BufferedReader br = new BufferedReader(new FileReader(".\\highestscore.txt"));
           // while ( br.readLine() !=null)
           // {
            	//System.out.println(br.read);
            	this.HighestScore = Integer.parseInt(br.readLine());
           // }
            br.close();
 		  
 		  gameover=false;
 		  score.setScore(0);
 		  constant.clear();
 		  control.clear();
 		  moving.clear();
 		  mementos.clear();
 		  context=new Context();
 	  
 			try {
 								
 				 moving.add(pf.GenerateRandomPlate("left"));
 				 moving.add(pf.GenerateRandomPlate("right"));
 			} catch (IOException e) {
 				Logger log = LoggerSingle.getInstance();
 				log.setLevel(Level.ALL);
 				log.severe(e.getMessage());
 				e.printStackTrace();
 			}
 			try {
 				
 				Player clown =new Player("");
 				clown.setX((int)screenSize.getWidth()/2);
 				clown.setY(564*(int)screenSize.getHeight()/864);
 				clown.setSpriteImages();
 				control.add(clown);
 				
 			} catch (IOException e) {
 				Logger log = LoggerSingle.getInstance();
 				log.setLevel(Level.ALL);
 				log.severe(e.getMessage());
 				e.printStackTrace();
 			}
 		    
 			control.add(new Stick((int)screenSize.getWidth()*776/1536,(int)screenSize.getHeight()*614/864,0));
			control.add(new Stick((int)screenSize.getWidth()*906/1536,(int)screenSize.getHeight()*614/864,1));

 		  try {
 			
 	 		constant.add(new ConstantBar(0,75*(int)screenSize.getHeight()/864));
 	 		constant.add(new ConstantBar((int)screenSize.getWidth()-constant.get(0).getWidth(),75*(int)screenSize.getHeight()/864));
 			constant.add(new Background(1));  
			constant.add(new ConstantBar(0,75*(int)screenSize.getHeight()/864));
 			constant.add(new ConstantBar((int)screenSize.getWidth()-constant.get(0).getWidth(),75*(int)screenSize.getHeight()/864));
 			
 			
 			
 			
 			
 		} catch (IOException e) {
 			Logger log = LoggerSingle.getInstance();
			log.setLevel(Level.ALL);
			log.severe(e.getMessage());
 			e.printStackTrace();
 		}
 			  
 	  }
 	
 	@Override
 	public List<GameObject> getConstantObjects() {

 		return constant;
 	}
 
 	@Override
 	public List<GameObject> getMovableObjects() {

 		return moving;
 	}
 
 	@Override
 	public List<GameObject> getControlableObjects() {

 		return control;
 	}
 
 	@Override
 	public int getWidth() {


 		//return (int) this.width;
 		return 1366;
 		
 	}
 
 	@Override
 	public int getHeight() {
//
// 		System.out.println((int) this.height-100);
// 		return (int) this.height-100;
 		return 668;
 	}

 	@Override
 	public  boolean refresh() {
 		
 		if(score.getScore() > this.HighestScore)
 		{
 			this.HighestScore = score.getScore();
 	        BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(".\\highestscore.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	        try {
 	        	
				bw.write( new Integer(score.getScore()).toString() );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	        try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}
 		if(!gameover) 
 		{

 			Originator originator = new Originator(moving,control);
 			mementos.add(originator.createMemento()); 			
 		} 		
       if(gameover)
       {       
    	   if(t==null) {
    		   t=mementos.iterator();
    	   }
        	control.clear();       	
        	if(!t.hasNext())
        	{
        		return true;

        	}
//        	moving= mementos.get(iterator++).getAll();
           moving = ((Memento) t.next()).getAll();       
        	return true;
        }		
        if(win) {
        	
        	context.setWin(false);
        	((Background)constant.get(2)).setNum(lf.getMyLevel().getcurrentLevel());
        	win=false;
        }
       

		  create++;
 		  if(create%(17-2*lf.getMyLevel().getcurrentLevel())==0) 
 		  {
 			  try 
 			  {
 				 moving.add(pf.GenerateRandomPlate("left"));
 				 moving.add(pf.GenerateRandomPlate("right"));  
 			  } 
 			  catch (IOException e) 
 			  {
 				Logger log = LoggerSingle.getInstance();
 				log.setLevel(Level.ALL);
 				log.severe(e.getMessage());
 				e.printStackTrace();
 			  }
 			  create=0;
 		  }
 		  context.SetLists(constant, moving, control); 		  
 		  moving=context.getmoving();	  
 		  control=context.getcontrol();
 		  win=context.isWin();
 		  gameover=context.gameOver();
 		return true;
 	}
 	@Override
 	public String getStatus() {

 		return "Score "+ score.getScore() +"   |    "+ LevelFactory.getInstance().getMyLevel().toString() + "  |   "+"Highest Score " + this.HighestScore;
 	}
 
 	@Override
 	public int getSpeed() {
	
	return movingObjectsSpeed;
	
 	}
 
 	@Override
 	public int getControlSpeed() {
		return 40;
 	}
 	
 }