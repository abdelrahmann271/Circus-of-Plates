package SnapShot;

import java.util.LinkedList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Memento {


	private   List<GameObject> constant = new LinkedList<GameObject>();
	private List<GameObject> moving = new LinkedList<GameObject>();
	private List<GameObject> control = new LinkedList<GameObject>();
	    public Memento(List<GameObject> constant, List<GameObject> moving, List<GameObject> control) {
	        super();
	        this.constant = constant;
	        this.moving = moving;
	        this.control = control;
	    }
	 
	    public List<GameObject> getConstant() {
	        return constant;
	    }
	 
	    public List<GameObject> getMoving() {
	        return moving;
	    }
	 
	    public List<GameObject> getControl() {
	        return control;
	    }
}
