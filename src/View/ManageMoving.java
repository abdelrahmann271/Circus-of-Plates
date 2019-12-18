package View;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import Levels.*;
import Score.*;
import Objects.Plate;
import Objects.PlateFactory;
import eg.edu.alexu.csd.oop.game.GameObject;

public class ManageMoving implements Observer,Strategy {
	
	private static ManageMoving Object = new ManageMoving();
	public static ManageMoving getUniqueInstance()
	{
		return Object;
		
	}
	private ManageMoving() {

	}
	private int movingSpeedFactor = 10;
	PlateFactory pf= PlateFactory.getUniqueInstance();
	List<GameObject> moving;
	List<GameObject> constant;
	List<GameObject> control;
	List<GameObject> temp=new LinkedList<GameObject>();
	
	 public void Managemoving (List<GameObject> moving,List<GameObject> constant,List<GameObject> control) {
		 this.control=control;
		 this.moving=moving;
		 this.constant=constant;
	 }
	 public List<GameObject> getmoving(){
//		 if(moving==null) {System.out.println("ggg");}
			return moving;
		}
		public List<GameObject> getconstant(){
			return constant;
		}
		
	public boolean checkcollision(GameObject p) {
		
		for(GameObject t : control) {
			
			if(Math.abs(p.getX()-t.getX())<=3*p.getWidth()/4&&Math.abs(p.getY()+p.getHeight()-t.getY())<=10) {
				return true;
			}
		}
		return false;
	}
	
	public void excute() {
	 temp.clear();
		for(GameObject p : moving) {
			
			if((((Plate)p).getdirection()=="left"&&(p.getX()>=constant.get(0).getX()+constant.get(0).getWidth())||
					((Plate)p).getdirection()=="right"&&(p.getX()+p.getWidth()<=constant.get(1).getX())||((Plate) p).getfreedome()
					)) {
				     for(int i=1;i<=movingSpeedFactor;i++) {
				    	 
				    	 p.setY(p.getY()+1);
				    	 if(checkcollision(p)) {
				    		 i=movingSpeedFactor+1;
				    	 }
				     }
			    	
			    	}
			    else if(((Plate)p).getdirection()=="left") {
			      
			    	p.setX(p.getX()+movingSpeedFactor); }
			
			    else {
			    	p.setX(p.getX()-movingSpeedFactor);
			    	
			    }
			   if(p.getY()>2000) {
				   temp.add(p);
			   }
		    }
		
		for(GameObject O : temp) {
			pf.addToGarbage((Plate)O);
			moving.remove(O);
		}
		
	    }
	@Override
	public List<GameObject> getcontrol() {

		return control;
	}
	public void setMovingSpeedFactor(int movingSpeedFactor) {
		this.movingSpeedFactor = movingSpeedFactor;
	}
	public int getMovingSpeedFactor() {
		return movingSpeedFactor;
	}
	public int getScoreDecFactor(Score score)
	{
		return (score.getScore()/25);
	}
	@Override
	public void update(Observable score, java.lang.Object arg) {
		
		this.movingSpeedFactor = LevelFactory.getInstance().getMyLevel().getPlatesSpeed();
	}
 }
