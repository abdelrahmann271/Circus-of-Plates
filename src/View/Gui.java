package View;
import java.awt.Color;
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

import Objects.*;
import Players.*;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;


public class Gui implements World {
	static List<GameObject> constant = new LinkedList<GameObject>();
	static List<GameObject> moving = new LinkedList<GameObject>();
	static List<GameObject> control = new LinkedList<GameObject>();
	static List<GameObject> temp = new LinkedList<GameObject>();
	public int create=0,width;
	boolean caught=false,gameover=false,win=false;
	PlateFactory pf= new PlateFactory();
	
	
	  public static void main(String[]agrs) {
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
					gameController.changeWorld(new View.Gui());
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
	  public Gui()  {
	
	        		
			try {
				 
				//moving.add(new NonBasedPlate(-150,75));
				moving.add(pf.GenerateRandomPlate());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				
				Player clown =new Player("");
				clown.setX(150);clown.setY(600);clown.ChoosePlayerCharacter((int)Math.random()*8);
				clown.setSpriteImages();
				control.add(clown);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			control.add(new Stick());
			
		 
		  try {
			constant.add(new ConstantBar(0,75));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			  
	  }
	
	@Override
	public List<GameObject> getConstantObjects() {
		// TODO Auto-generated method stub
		return constant;
	}

	@Override
	public List<GameObject> getMovableObjects() {
		// TODO Auto-generated method stub
		return moving;
	}

	@Override
	public List<GameObject> getControlableObjects() {
		// TODO Auto-generated method stub
		return control;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 1500;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 800;
	}

	@Override
	public boolean refresh() {
		// TODO Auto-generated method stub
       if(gameover) {
    	   System.out.println("GAMEOVER!");
    	   return false;
       }
       if(win) {
    	   System.out.println("LEVEL UP!");
    	   return false;
       }
		
		  create++;
		  if(create%15==0) {
			  try {
				  moving.add(pf.GenerateRandomPlate());
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
		    
			for(GameObject p : moving) {
				
				caught=false;
				for(int i=0;i<control.size();i++) {
					GameObject t=control.get(i);
					if(t.getY()<constant.get(0).getY()) {
						gameover=true;
						}
				if(Math.abs(p.getX()-t.getX())<=3*p.getWidth()/4&&Math.abs(p.getY()+p.getHeight()-t.getY())<=10) {
						caught=true;i=control.size();
						p.setY(t.getY()-p.getHeight());
						control.add(p);temp.add(p);
						if(t instanceof Plate) {
						Plate P=(Plate)p,T=(Plate)t;
						P.setpreviouscolor(T.getColor());
						if(P.getColor()==T.getColor()&&T.getColor()==T.getpreviouscolor()) {
							win=true;
						}
					  }
					}
				}
		
			 if(!caught&&(p.getX()>=constant.get(0).getX()+constant.get(0).getWidth())) {
		    	p.setY(p.getY()+10);
		    	}
		    else if(!caught) {
			p.setX(p.getX()+10);
			
		    }
			  if(p.getY()>1000) {
			    	temp.add(p);
			    }
		}
	
		for(GameObject p : temp) {
			
			if(p.getY()>1000) {
				pf.addToGarbage((Plate)p);
			}
			moving.remove(p);
		}

		return true;
	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public int getControlSpeed() {
		// TODO Auto-generated method stub
		return 20;
	}

}
