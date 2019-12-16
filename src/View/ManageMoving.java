package View;

import java.util.LinkedList;
import java.util.List;

import Objects.Plate;
import Objects.PlateFactory;
import eg.edu.alexu.csd.oop.game.GameObject;

public class ManageMoving implements Strategy {
	
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
		 if(moving==null) {System.out.println("ggg");}
			return moving;
		}
		public List<GameObject> getconstant(){
			return constant;
		}
	
	public void excute() {
	 temp.clear();
		for(GameObject p : moving) {
			
			if((((Plate)p).getType()=="left"&&(p.getX()>=constant.get(0).getX()+constant.get(0).getWidth())||
					((Plate)p).getType()=="right"&&(p.getX()+p.getWidth()<=constant.get(1).getX())
					)) {
			    	p.setY(p.getY()+10);
			    	}
			    else if(((Plate)p).getType()=="left") {
			      
			    	p.setX(p.getX()+10); }
			
			    else {
			    	p.setX(p.getX()-10);
			    	
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
    }
