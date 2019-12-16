package View;

import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Context {

	CheckCollision checkcollision=new CheckCollision();
	ManageCollision managecollision=new ManageCollision();
	ManageMoving managemoving=new ManageMoving();
	   
	private Strategy strategy;

	public void SetLists(List<GameObject> constant,List<GameObject> moving,List<GameObject> control) {
		
		checkcollision.Checkcollision(moving, control);
		strategy=checkcollision;
		excutestrategy();
		managecollision.Managecollision(checkcollision.getcollided(),moving,control);
		strategy=managecollision;
		excutestrategy();
		managemoving.Managemoving(managecollision.getmoving(), constant,managecollision.getcontrol());
		strategy=managemoving;
		excutestrategy();
	}
	
	public List<GameObject> getmoving(){
		
		return strategy.getmoving();
	}
	public List<GameObject> getcontrol(){
		
		return strategy.getcontrol();
	}
	
	
	public boolean isWin() {
		return managecollision.isWin();
	}
	public boolean gameOver() {
		return checkcollision.gameover();
	}
	
	public void excutestrategy() {
		strategy.excute();
	}
}
