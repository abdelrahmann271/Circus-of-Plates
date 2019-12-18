package View;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Logger.LoggerSingle;
import Players.Player;
import Players.Stick;
import eg.edu.alexu.csd.oop.game.GameObject;


public class CheckCollision implements Strategy {
    
    
	List<GameObject> moving;
	List<GameObject> control;
	List<GameObject[]> collided=new ArrayList<>();
	List<GameObject> temp= new ArrayList<>();
	boolean gameOver=false;
	
	public void Checkcollision(List<GameObject> moving,List<GameObject> control) {
		this.moving=moving;
		this.control=control;
		sort(control);
	}
	
	public List<GameObject> getmoving(){
		return moving;
	}
	public List<GameObject> getcontrol(){
		return control;
	}
	
	public void sort(List<GameObject> control) {
		temp.clear();
	   // if(control.size()>0) {
	    
			GameObject f=null;
	    	int n=control.size();
	    for(int j=0;j<n;j++) {
	    	
	    	int miny=5000;
	    	for(int i=0;i<n-j;i++) {
	    		
	    		if(control.get(i).getY()<miny) {
	    			miny=control.get(i).getY();
	    			f=control.get(i);
	    		}
	    	}
	    	control.remove(f);temp.add(f);
	       }
	    control.clear();
	   
	    for(GameObject O : temp) {control.add(O);}
	   
	  //  }
	}
	
	public boolean gameover() {
		if(gameOver) {
			Logger log = LoggerSingle.getInstance();
				log.setLevel(Level.ALL);
				log.info("game over");
		}
		return gameOver;
	}
	
	public List<GameObject[]> getcollided(){
		return collided;
	}
	
	public void excute() {
		collided.clear();
		for(GameObject p : moving) {
			
			for(GameObject t : control) {
				
				if(Math.abs(p.getX()-t.getX())<=3*p.getWidth()/4&&Math.abs(p.getY()+p.getHeight()-t.getY())<=10) {
					
					GameObject arr[]=new GameObject[2];
					arr[0]=p;
					arr[1]=t;
					control.add(p);
					collided.add(arr);
					break;
				}
				if(t.getY()<75) {
					gameOver=true;
				}
			}
		}
	}
}
