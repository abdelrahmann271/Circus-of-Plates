package View;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Logger.LoggerSingle;
import Objects.Plate;
import Players.*;
import eg.edu.alexu.csd.oop.game.GameObject;
import Score.*;

public class ManageCollision implements Strategy {
	
	private Score score = Score.getInstance();
	private int scoreCounter = 0;
	
	List<GameObject[]> collided;
	List<GameObject> control;
	List<GameObject> moving;
	List<GameObject> temp=new LinkedList<GameObject>();
	boolean isWin=false;
	int height;
	public void Managecollision(List<GameObject[]> collided,List<GameObject> moving,List<GameObject> control) {
		this.collided=collided;
		this.moving=moving;
		this.control=control;
	}
	
	public boolean isWin() {
		return isWin;
	}
	
	public List<GameObject> getmoving(){
		return moving;
	}
	public List<GameObject> getcontrol(){
		return control;
	}
    public void DFS(Plate p) {
    	control.remove(p);
    	moving.add(p);
    	for(Plate t : p.getnext()) {
    		DFS(t);
    	}
    }
	
	@Override
	public void excute() {

		Player clown=null;
		
		   for(GameObject O : control) {
			   if(O instanceof Player) {
				   clown=(Player)O;
				   break;
			   }
		   }
		
	for(GameObject[] arr : collided) {
				
			arr[0].setY(arr[1].getY()-arr[0].getHeight());
			((Plate)arr[0]).setfreedome(true);
			moving.remove(arr[0]);
			((Plate)arr[0]).setdx(((Plate)arr[0]).getX()-clown.getX());
			((Plate)arr[0]).setdy(((Plate)arr[0]).getY()-clown.getY());
			if(arr[1] instanceof Plate) {
				((Plate)arr[0]).setpreviousplate(((Plate)arr[1]));
				((Plate)arr[0]).setpreviouscolor(((Plate)arr[1]).getColor());
				((Plate)arr[1]).addnext(((Plate)arr[0]));
				if(((Plate)arr[0]).getColor()==((Plate)arr[1]).getColor()&&((Plate)arr[1]).getColor()==((Plate)arr[1]).getpreviouscolor()) {
					isWin=true;
					DFS(((Plate)arr[1]).getpreviousplate());
					moving.remove(arr[0]);
					moving.remove(arr[1]);
					moving.remove(((Plate)arr[1]).getpreviousplate());
					if(((Plate)arr[1]).getpreviousplate().getpreviousplate()!=null) {
						((Plate)arr[1]).getpreviousplate().getpreviousplate().getnext().remove(((Plate)arr[1]).getpreviousplate());
					}
					
					System.out.println("3 Plates are collected");
					scoreCounter+=25;
					Logger log = LoggerSingle.getInstance();
	 				log.setLevel(Level.ALL);
	 				log.info("3 plates are collected and score = " + scoreCounter);
					score.setScore(scoreCounter);
					//Get the score
				}
			}
			
		}
	 

	   for(GameObject O : control) {
		   if(O instanceof Stick) {
			   Stick stick=(Stick)O;
			   stick.setX(stick.getdx()+clown.getX());
			   stick.setY(stick.getdy()+clown.getY());
		   }
		   if(O  instanceof Plate) {
			   Plate p=(Plate)O;
			   p.setX(p.getdx()+clown.getX());
			   p.setY(p.getdy()+clown.getY());
		   }
	   }
	
	}

}
