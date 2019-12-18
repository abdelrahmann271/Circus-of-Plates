package SnapShot;

import java.util.LinkedList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Originator {


		
		private   List<GameObject> moving = new LinkedList<GameObject>();
		private   List<GameObject> control = new LinkedList<GameObject>();

	     
	    public Originator(List<GameObject> moving,List<GameObject> control) {
	        super();

	        this.moving =  moving;
	        this.control= control;

	    }
	     
	    //Setters and getters
	     
	    public Memento createMemento() 
	    { 
//	    	

	        Memento m = new Memento(moving, control);
	        

	        return m;
	    }
	     
	 
	 
//	    @Override
//	    public String toString() {
//	        return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
//	    }
	
}
