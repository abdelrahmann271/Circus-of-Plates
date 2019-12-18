package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

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
	int height,width;
	int dx,dy;
	BufferedImage[] SpriteImages; 
	int color,prevcolor=-1;
	boolean isVisible=true,freedome=false;
	Plate prev;
	String type,direction;
	Vector<Plate> next=new Vector<>();
	
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
	public void Setdirection(String s) {
		this.direction=s;
	}
	public String getdirection() {
		return direction;
	}
	public String getType()
	{
		return type;
	}
	public void setpreviouscolor(int c) {
		this.prevcolor=c;
	}
    public int getpreviouscolor() {
    	return prevcolor;
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
	public void addnext(Plate p) {
		this.next.add(p);
	}
	public Vector<Plate> getnext(){
		return next;
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
		//System.out.println(SpriteImages.length+" s "+color);
		return SpriteImages[color];
	}
	public void setpreviousplate(Plate p) {
		this.prev=p;
	}
	public Plate getpreviousplate() {
		return prev;
	}
	public void setdx(int dx) {
		this.dx=dx;
	}
	public void setdy(int dy) {
		this.dy=dy;
	}
	public int getdx() {
		return dx;
	}
	public int getdy() {
		return dy;
	}
	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		BufferedImage []img=new BufferedImage[1];
		img[0]=getImage();
		return img;
	}
	public void setfreedome(boolean f) {
		this.freedome=f;
	}
	public boolean getfreedome() {
		return freedome;
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
		//File file= new File(path+"\\"+color[this.getColor()]+type+".png");
		//out[0]=ImageIO.read(file);
	   
		this.SpriteImages=out;
	
	}

}
