package View;

import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;

public interface Strategy {

	public void excute();
	
	public List<GameObject> getmoving();
	
	public List<GameObject> getcontrol();
	
}
