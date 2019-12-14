<<<<<<< Upstream, based on origin/ayman
package Objects;

import java.awt.Color;
import java.awt.Graphics;
<<<<<<< Upstream, based on origin/ayman
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class Plate extends JPanel implements GameObject  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x=400;
	int y=500;
	int height;
	int dx;
	BufferedImage[] SpriteImages; 
	int color;
	boolean isVisible=true;
	String type;
	//X and Y 
	
	Plate() throws IOException
	{
		
	}
	public Plate(int X,int Y) throws IOException
	{
		this.x=X;
		this.y=Y;
		this.SetSpriteImages();
	}
	public void setType(String type)
	{
		 this.type=type;
	}
	public String getType()
	{
		return type;
	}
	
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		this.x=x;
		
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y=y;
		
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		int Width=SpriteImages[0].getWidth();
		return Width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		int Height=SpriteImages[0].getHeight();
		return Height;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return isVisible;
	}
	public void setVisible(boolean Visible)
	{
		this.isVisible=Visible;
	}
	/**
	 * 
	 * @param color
	 * number 0 is the black one 
		//number 1 is the blue one 
		// number 2 is the cyan one
		// number 3 is the darkred one
		// number 4 is the gold one
		// number 5 is the green one
		// number 6 is the orange one 
		// number 7 is the pink
		//number 8 is purple
		// number 9 is red
		// number 10 is yellow
	 */
	public void setColor(int color)
	{
		this.color=color;
		
	}
	public int getColor()
	{
		return color;
	}
	public BufferedImage getImage()
	{
		return SpriteImages[color];
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		return SpriteImages;
	}
	
	public void draw(Graphics g)
	{
		if(isVisible==false)
		{
			return;
		}
		BufferedImage img=this.getImage();
		g.setColor(Color.orange);
		g.fillRect(0, 75+this.getHeight(),400,10);
		g.drawImage(img, getX(), getY(), this);
	}
	public  void SetSpriteImages() throws IOException
	{
		BufferedImage[] out=new BufferedImage[1];
		//File file;
		String path="plates";
		//System.out.println(type+ " ff");
		String []color= {"black","blue","cyan","darkred"
				,"gold","green","orange","pink","purple","red","yellow"};
		/*for(int i=0;i<11;i++)
		{   
			file=new File(path+"\\"+color[i]+type+".png");
			out[i]=ImageIO.read(file);
		}*/
		File file= new File(path+"\\"+color[this.getColor()]+type+".png");
		out[0]=ImageIO.read(file);
	   
		this.SpriteImages=out;
	
	}

}
=======

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import eg.edu.alexu.csd.oop.game.GameObject;



public abstract class Plate extends JPanel implements GameObject  {
	int x=400;
	int y=500;
	int height;
	int dx;
	BufferedImage[] SpriteImages; 
	int color;
	boolean isVisible=true;
	String type;
	//X and Y 
	
	Plate() throws IOException
	{
		
	}
	public Plate(int X,int Y) throws IOException
	{
		this.x=X;
		this.y=Y;
		this.SetSpriteImages();
	}
	public void setType(String type)
	{
		 this.type=type;
	}
	public String getType()
	{
		return type;
	}
	
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		this.x=x;
		
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y=y;
		
	}
	public void setHeightFromClown(int h) {
		this.height=h;
	}
	public int getHeightFromClown() {
		return this.height;
	}
    public void setShiftX(int dx) {
    	this.dx=dx;
    }
    public int getShiftX() {
    	return dx;
    }
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		int Width=SpriteImages[0].getWidth();
		return Width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		int Height=SpriteImages[0].getHeight();
		return Height;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return isVisible;
	}
	public void setVisible(boolean Visible)
	{
		this.isVisible=Visible;
	}
	/**
	 * 
	 * @param color
	 * number 0 is the black one 
		//number 1 is the blue one 
		// number 2 is the cyan one
		// number 3 is the darkred one
		// number 4 is the gold one
		// number 5 is the green one
		// number 6 is the orange one 
		// number 7 is the pink
		//number 8 is purple
		// number 9 is red
		// number 10 is yellow
	 */
	public void setColor(int color)
	{
		this.color=color;
		
	}
	public int getColor()
	{
		return color;
	}
	public BufferedImage getImage()
	{
		return SpriteImages[color];
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		return SpriteImages;
	}
	
	public void draw(Graphics g)
	{
		if(isVisible==false)
		{
			return;
		}
		BufferedImage img=this.getImage();
		g.setColor(Color.orange);
		g.fillRect(0, 75+this.getHeight(),400,10);
		g.drawImage(img, getX(), getY(), this);
	}
	public  void SetSpriteImages() throws IOException
	{
		BufferedImage[] out=new BufferedImage[11];
		File file;
		String path="plates";
		//System.out.println(type+ " ff");
		String []color= {"black","blue","cyan","darkred"
				,"gold","green","orange","pink","purple","red","yellow"};
		for(int i=0;i<11;i++)
		{   
			file=new File(path+"\\"+color[i]+type+".png");
			out[i]=ImageIO.read(file);
		}
		this.SpriteImages=out;
	
	}
	

}

>>>>>>> 3f97cef 1
=======
package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class Plate extends JPanel implements GameObject  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x=400;
	int y=500;
	int height;
	int dx;
	BufferedImage[] SpriteImages; 
	int color;
	boolean isVisible=true;
	String type;
	//X and Y 
	
	Plate() throws IOException
	{
		
	}
	public Plate(int X,int Y) throws IOException
	{
		this.x=X;
		this.y=Y;
		this.SetSpriteImages();
	}
	public void setType(String type)
	{
		 this.type=type;
	}
	public String getType()
	{
		return type;
	}
	
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		this.x=x;
		
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y=y;
		
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		int Width=SpriteImages[0].getWidth();
		return Width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		int Height=SpriteImages[0].getHeight();
		return Height;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return isVisible;
	}
	public void setVisible(boolean Visible)
	{
		this.isVisible=Visible;
	}
	/**
	 * 
	 * @param color
	 * number 0 is the black one 
		//number 1 is the blue one 
		// number 2 is the cyan one
		// number 3 is the darkred one
		// number 4 is the gold one
		// number 5 is the green one
		// number 6 is the orange one 
		// number 7 is the pink
		//number 8 is purple
		// number 9 is red
		// number 10 is yellow
	 */
	public void setColor(int color)
	{
		this.color=color;
		
	}
	public int getColor()
	{
		return color;
	}
	public BufferedImage getImage()
	{
		return SpriteImages[color];
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		return SpriteImages;
	}
	
	public void draw(Graphics g)
	{
		if(isVisible==false)
		{
			return;
		}
		BufferedImage img=this.getImage();
		g.setColor(Color.orange);
		g.fillRect(0, 75+this.getHeight(),400,10);
		g.drawImage(img, getX(), getY(), this);
	}
	public  void SetSpriteImages() throws IOException
	{
		BufferedImage[] out=new BufferedImage[1];
		//File file;
		String path="plates";
		//System.out.println(type+ " ff");
		String []color= {"black","blue","cyan","darkred"
				,"gold","green","orange","pink","purple","red","yellow"};
		/*for(int i=0;i<11;i++)
		{   
			file=new File(path+"\\"+color[i]+type+".png");
			out[i]=ImageIO.read(file);
		}*/
		File file= new File(path+"\\"+color[this.getColor()]+type+".png");
		out[0]=ImageIO.read(file);
	   
		this.SpriteImages=out;
	
	}
	

}

>>>>>>> 59b6b7c k
