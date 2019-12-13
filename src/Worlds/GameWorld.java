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

		return true;
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
