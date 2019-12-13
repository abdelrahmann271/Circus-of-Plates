<<<<<<< Upstream, based on origin/ayman
package Worlds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import Objects.*;
import Objects.Plate;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import Players.*;


public class GameWorld implements World {
	
	//All the Game logic will be Here !
	
	private final int width ;
	private final int height;	
	private final List<GameObject> constant = new LinkedList<GameObject>();
	private final List<GameObject> moving = new LinkedList<GameObject>();
	private final List<GameObject> control = new LinkedList<GameObject>();
	
	public GameWorld(int screenWidth, int screenHeight) throws IOException {
		
		this.width = screenWidth;
		this.height = screenHeight;
		
<<<<<<< Upstream, based on origin/ayman
//		NonBasedPlate pp = new NonBasedPlate(100,100);
		//pp.SetSpriteImages();
//		control.add(pp);
		
		
		
		Clown c = new Clown(400, 400, "E:\\JavaProjectsEclipse\\CircusOfPlates\\clowns\\output-onlinepngtools.png");
		control.add(c);
		
//		
//		
		Bar bar1 = new Bar(0,100,"E:\\JavaProjectsEclipse\\CircusOfPlates\\plates\\bar.png");
		constant.add(bar1);
		Bar bar6 = new Bar(200,100,"E:\\JavaProjectsEclipse\\CircusOfPlates\\plates\\bar.png");
		constant.add(bar6);
		Bar bar2 = new Bar(0,200,"E:\\JavaProjectsEclipse\\CircusOfPlates\\plates\\bar.png");
		constant.add(bar2);
		Bar bar3 = new Bar(0,300,"E:\\JavaProjectsEclipse\\CircusOfPlates\\plates\\bar.png");
		constant.add(bar3);
//		Bar bar4 = new Bar(200,400,"E:\\JavaProjectsEclipse\\CircusOfPlates\\plates\\bar.png");
//		constant.add(bar4);
		Bar bar5 = new Bar(0,400,"E:\\JavaProjectsEclipse\\CircusOfPlates\\plates\\bar.png");
		constant.add(bar5);
=======
		PotPlate pp = new PotPlate(100,100);
		pp.SetSpriteImages();
		control.add(pp);
		
		Bar bar1 = new Bar();
>>>>>>> df43748 jk
		
		
		
	}

	@Override
	public List<GameObject> getConstantObjects() {

		return constant;
	}

	@Override
	public List<GameObject> getMovableObjects() {

		return moving;
	}

	@Override
	public List<GameObject> getControlableObjects() {

		return control;
	}

	@Override
	public int getWidth() {

		return this.width;
	}

	@Override
	public int getHeight() {

		return this.height;
	}

	@Override
	public boolean refresh() {

<<<<<<< Upstream, based on origin/ayman
		return true;
=======
		return false;
>>>>>>> df43748 jk
	}

	@Override
	public String getStatus() {

		return null;
	}

	@Override
	public int getSpeed() {

<<<<<<< Upstream, based on origin/ayman
		return 10;
=======
		return 0;
>>>>>>> df43748 jk
	}

	@Override
	public int getControlSpeed() {

<<<<<<< Upstream, based on origin/ayman
		return 10;
=======
		return 0;
>>>>>>> df43748 jk
	}

}
=======
package Worlds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import Objects.*;
import Objects.Plate;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

public class GameWorld implements World {
	
	//All the Game logic will be Here !
	
	private final int width ;
	private final int height;	
	private final List<GameObject> constant = new LinkedList<GameObject>();
	private final List<GameObject> moving = new LinkedList<GameObject>();
	private final List<GameObject> control = new LinkedList<GameObject>();
	
	public GameWorld(int screenWidth, int screenHeight) throws IOException {
		
		this.width = screenWidth;
		this.height = screenHeight;
		
		PotPlate pp = new PotPlate(100,100);
		pp.SetSpriteImages();
		control.add(pp);
		
		Bar bar1 = new Bar();
		
		
		
	}

	@Override
	public List<GameObject> getConstantObjects() {

		return constant;
	}

	@Override
	public List<GameObject> getMovableObjects() {

		return moving;
	}

	@Override
	public List<GameObject> getControlableObjects() {

		return control;
	}

	@Override
	public int getWidth() {

		return this.width;
	}

	@Override
	public int getHeight() {

		return this.height;
	}

	@Override
	public boolean refresh() {

		return false;
	}

	@Override
	public String getStatus() {

		return null;
	}

	@Override
	public int getSpeed() {

		return 0;
	}

	@Override
	public int getControlSpeed() {

		return 0;
	}

}
>>>>>>> c563127 k
