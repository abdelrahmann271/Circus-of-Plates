<<<<<<< Upstream, based on origin/ayman
package View;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import java.awt.Toolkit;

import Objects.*;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import Players.*;

public class Gui implements World {
	
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private final double width = screenSize.getWidth();
	private final double height = screenSize.getHeight();
	
	static List<GameObject> constant = new LinkedList<GameObject>();
	static List<GameObject> moving = new LinkedList<GameObject>();
	static List<GameObject> control = new LinkedList<GameObject>();
	static List<GameObject> temp = new LinkedList<GameObject>();
	
	public int create=0;
	int x=400; 
	int y=500;
	int ads;

	boolean caught=false;
	
	  public static void main(String[]agrs) throws IOException {
			JMenuBar  menuBar = new JMenuBar();
			JMenu menu = new JMenu("File");
			JMenuItem newMenuItem = new JMenuItem("New");
			JMenuItem pauseMenuItem = new JMenuItem("Pause");
			JMenuItem resumeMenuItem = new JMenuItem("Resume");
			menu.add(newMenuItem);
			menu.addSeparator();
			menu.add(pauseMenuItem);
			menu.add(resumeMenuItem);
			menuBar.add(menu);
			final GameController gameController = GameEngine.start("Circus of plates", new View.Gui(), menuBar, Color.lightGray);
			newMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
					try {
						gameController.changeWorld(new View.Gui());
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
			});
			pauseMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
					gameController.pause();
				}
			});
			resumeMenuItem.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent e) {
					gameController.resume();
				}
			});
		
		
		  
		  
	  }
	  public Gui() throws IOException  {
		         
		         
		  
	        	//GameObject obj=new ImageObject(400,75,"plates\\blackplatewithoutbase.png");
	        	
	        		
			try {
				moving.add(new NonBasedPlate(-150,75));
			} catch (IOException e) {

				e.printStackTrace();
			}
				
	        
		  
			control.add(new ControlBar(150,500));
			//control.add(new Clown(500, 400,"E:\\JavaProjectsEclipse\\CircusOfPlates\\clowns\\output-onlinepngtools.png"));
		
		 
		  try {
			constant.add(new ConstantBar(0,75+moving.get(0).getHeight()));
		} catch (IOException e) {

			e.printStackTrace();
		}
			  
		 
		  //control.add(new ImageObject(100,100,"/blackplatewithoutbase.png"));
		  //constant.add(new ImageObject(100,100,"/blackplatewithoutbase.png"));
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

		return (int) this.width;
	}

	@Override
	public int getHeight() {

		return (int) this.height-100;
	}

	@Override
	public boolean refresh() {


		  create++;
		  if(create%15==0) {
			  try {
				Plate p =new  NonBasedPlate(-150,constant.get(0).getY()-moving.get(0).getHeight());
				
				//p.setColor((int) ((Math.random()*11)));
				moving.add(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
			  create=0;
		  }
		
			temp.clear();
			
			
		    if(control.size()>1) {
		    	GameObject k=control.get(0);
				control.remove(0);
				GameObject f=null;
		    	int n=control.size();
		    for(int j=0;j<n;j++) {
		    	int miny=1500;
		    	for(int i=0;i<n-j;i++) {
		    		if(control.get(i).getY()<miny) {
		    			miny=control.get(i).getY();
		    			f=control.get(i);
		    		}
		    	}
		    	control.remove(f);temp.add(f);
		       }
		    control.clear();
		    control.add(k);
		    for(GameObject O : temp) {control.add(O);}
		   
		    }
		    
			for(GameObject f : moving) {
				Plate p=(Plate)f;
				caught=false;
				for(int i=0;i<control.size();i++) {
					Plate t=(Plate)control.get(i);
					//Clown t = (Clown) control.get(i);
				if(Math.abs(p.getX()-t.getX())<=3*p.getWidth()/4&&Math.abs(p.getY()+p.getHeight()-t.getY())<=10) {
						caught=true;i=control.size();
						p.setY(t.getY()-p.getHeight());
						//p.setHeightFromClown(control.get(0).getY()-p.getY());
					}
				}
			if(caught||(Math.abs(p.getY()+p.getHeight()-control.get(0).getY())<=10&&(Math.abs(p.getX()-control.get(0).getX())<3*p.getWidth()/4))) {
				temp.add(p);
				if(!caught) {
					p.setY(control.get(0).getY()-p.getHeight());
					//p.setHeightFromClown(control.get(0).getY()-p.getY());
				}
				
				//p.setShiftX(p.getX()-control.get(0).getX());
				control.add(p);
			    
			}
			else if(p.getX()>=constant.get(0).getX()+constant.get(0).getWidth()) {
		    	p.setY(p.getY()+10);
		    	}
		    else {
			p.setX(p.getX()+10);
			
		    }
			  if(p.getY()>1000) {
			    	temp.add(p);
			    }
		}
	
		for(GameObject t : temp) {
			Plate p=(Plate)t;
			moving.remove(p);
		}

		return true;
	}

	@Override
	public String getStatus() {

		return "";
	}

	@Override
	public int getSpeed() {

		return 50;
	}

	@Override
	public int getControlSpeed() {

		return 20;
	}

}
=======
package View;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import java.awt.Toolkit;

import Objects.*;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import Players.*;

public class Gui implements World {
	
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private final double width = screenSize.getWidth();
	private final double height = screenSize.getHeight();
	
	static List<GameObject> constant = new LinkedList<GameObject>();
	static List<GameObject> moving = new LinkedList<GameObject>();
	static List<GameObject> control = new LinkedList<GameObject>();
	static List<GameObject> temp = new LinkedList<GameObject>();
	
	public int create=0;
	int x=400; 
	int y=500;
	int ads;

	boolean caught=false;
	
	  public static void main(String[]agrs) throws IOException {
			JMenuBar  menuBar = new JMenuBar();
			JMenu menu = new JMenu("File");
			JMenuItem newMenuItem = new JMenuItem("New");
			JMenuItem pauseMenuItem = new JMenuItem("Pause");
			JMenuItem resumeMenuItem = new JMenuItem("Resume");
			menu.add(newMenuItem);
			menu.addSeparator();
			menu.add(pauseMenuItem);
			menu.add(resumeMenuItem);
			menuBar.add(menu);
			final GameController gameController = GameEngine.start("Circus of plates", new View.Gui(), menuBar, Color.lightGray);
			newMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
					try {
						gameController.changeWorld(new View.Gui());
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
			});
			pauseMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
					gameController.pause();
				}
			});
			resumeMenuItem.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent e) {
					gameController.resume();
				}
			});
		
		
		  
		  
	  }
	  public Gui() throws IOException  {
		         
		         
		  
	        	//GameObject obj=new ImageObject(400,75,"plates\\blackplatewithoutbase.png");
	        	
	        		
			try {
				moving.add(new NonBasedPlate(-150,75));
			} catch (IOException e) {

				e.printStackTrace();
			}
				
	        
		  
			control.add(new ControlBar(150,500));
			//control.add(new Clown(500, 400,"E:\\JavaProjectsEclipse\\CircusOfPlates\\clowns\\output-onlinepngtools.png"));
		
		 
		  try {
			constant.add(new ConstantBar(0,75+moving.get(0).getHeight()));
		} catch (IOException e) {

			e.printStackTrace();
		}
			  
		 
		  //control.add(new ImageObject(100,100,"/blackplatewithoutbase.png"));
		  //constant.add(new ImageObject(100,100,"/blackplatewithoutbase.png"));
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

		return (int) this.width;
	}

	@Override
	public int getHeight() {

		return (int) this.height-100;
	}

	@Override
	public boolean refresh() {


		  create++;
		  if(create%15==0) {
			  try {
				Plate p =new  NonBasedPlate(-150,constant.get(0).getY()-moving.get(0).getHeight());
				
				//p.setColor((int) ((Math.random()*11)));
				moving.add(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
			  create=0;
		  }
		
			temp.clear();
			
			
		    if(control.size()>1) {
		    	GameObject k=control.get(0);
				control.remove(0);
				GameObject f=null;
		    	int n=control.size();
		    for(int j=0;j<n;j++) {
		    	int miny=1500;
		    	for(int i=0;i<n-j;i++) {
		    		if(control.get(i).getY()<miny) {
		    			miny=control.get(i).getY();
		    			f=control.get(i);
		    		}
		    	}
		    	control.remove(f);temp.add(f);
		       }
		    control.clear();
		    control.add(k);
		    for(GameObject O : temp) {control.add(O);}
		   
		    }
		    
			for(GameObject f : moving) {
				Plate p=(Plate)f;
				caught=false;
				for(int i=0;i<control.size();i++) {
					Plate t=(Plate)control.get(i);
					//Clown t = (Clown) control.get(i);
				if(Math.abs(p.getX()-t.getX())<=3*p.getWidth()/4&&Math.abs(p.getY()+p.getHeight()-t.getY())<=10) {
						caught=true;i=control.size();
						p.setY(t.getY()-p.getHeight());
						//p.setHeightFromClown(control.get(0).getY()-p.getY());
					}
				}
			if(caught||(Math.abs(p.getY()+p.getHeight()-control.get(0).getY())<=10&&(Math.abs(p.getX()-control.get(0).getX())<3*p.getWidth()/4))) {
				temp.add(p);
				if(!caught) {
					p.setY(control.get(0).getY()-p.getHeight());
					//p.setHeightFromClown(control.get(0).getY()-p.getY());
				}
				
				//p.setShiftX(p.getX()-control.get(0).getX());
				control.add(p);
			    
			}
			else if(p.getX()>=constant.get(0).getX()+constant.get(0).getWidth()) {
		    	p.setY(p.getY()+10);
		    	}
		    else {
			p.setX(p.getX()+10);
			
		    }
			  if(p.getY()>1000) {
			    	temp.add(p);
			    }
		}
	
		for(GameObject t : temp) {
			Plate p=(Plate)t;
			moving.remove(p);
		}

		return true;
	}

	@Override
	public String getStatus() {

		return "";
	}

	@Override
	public int getSpeed() {

		return 50;
	}

	@Override
	public int getControlSpeed() {

		return 20;
	}

}
>>>>>>> 0d885cf jkk
