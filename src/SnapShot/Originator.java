package SnapShot;

import java.util.LinkedList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Originator {

		private  List<GameObject> constant = new LinkedList<GameObject>();
		private  List<GameObject> moving = new LinkedList<GameObject>();
		private  List<GameObject> control = new LinkedList<GameObject>();
		
	     
	    public Originator(List<GameObject> constant,List<GameObject> moving,List<GameObject> control) {
	        super();
//	        this.constant =	constant;
//	        this.moving = moving;
//	        this.control=control;
	        this.constant = new LinkedList<GameObject>(constant);
	        this.moving = new LinkedList<GameObject>(moving);
	        this.control=new LinkedList<GameObject>(control);
	    }
	     
	    //Setters and getters
	     
	    public Memento createMemento() 
	    { 
//	    	
	        Memento m = new Memento(this.constant,this.moving, this.control);
	     
	        return m;
	    }
	     
	    public void restore(Memento m) {
	    	this.constant =m.getConstant();
	        this.moving =m.getMoving() ;
	        this.control=m.getControl();
	    }
	 
//	    @Override
//	    public String toString() {
//	        return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
//	    }
	
}
