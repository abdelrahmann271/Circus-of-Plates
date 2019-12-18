package SnapShot;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import Objects.Plate;
import Players.Player;
import eg.edu.alexu.csd.oop.game.GameObject;
import Objects.*;
public class Memento {

	Vector<Integer> x_coordinates=new Vector<>();
	Vector<Integer> y_coordinates=new Vector<>();
	private  List<GameObject> All = new LinkedList<GameObject>();
	
	    public Memento(List<GameObject> moving, List<GameObject> control) {
	        super();  
	       for(GameObject O : moving) {
	    	   x_coordinates.add(O.getX());
	    	   y_coordinates.add(O.getY());
	    	   All.add(O);
	       }
	       for(GameObject O : control) {
	    	   x_coordinates.add(O.getX());
	    	   y_coordinates.add(O.getY());
	    	   All.add(O);
	       }
	      
	    }
	
	    public List<GameObject> getAll(){
	    	int i=0;
	    	for(GameObject O : All) {
	    		O.setX(x_coordinates.get(i));
	    		O.setY(y_coordinates.get(i));
	    		i++;
	    	}
	    	
	    	return All;
	    }
}
