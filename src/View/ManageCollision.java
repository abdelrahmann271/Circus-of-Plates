package View;

import java.util.List;
import Objects.Plate;
import eg.edu.alexu.csd.oop.game.GameObject;

public class ManageCollision implements Strategy {
    

	List<GameObject[]> collided;
	List<GameObject> control;
	List<GameObject> moving;
	boolean isWin=false;
	
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
	
	@Override
	public void excute() {

	for(GameObject[] arr : collided) {
			
			arr[0].setY(arr[1].getY()-arr[0].getHeight());
			moving.remove(arr[0]);
			control.add(arr[0]);
			if(arr[1] instanceof Plate) {
				((Plate)arr[0]).setpreviouscolor(((Plate)arr[1]).getColor());
				if(((Plate)arr[0]).getColor()==((Plate)arr[1]).getColor()&&((Plate)arr[1]).getColor()==((Plate)arr[1]).getpreviouscolor()) {
					isWin=true;
					//Get the score
				}
			}
			
		}
	}

}
