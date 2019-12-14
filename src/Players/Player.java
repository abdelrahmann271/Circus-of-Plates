package Players;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Player extends JPanel implements Observer, GameObject  {
	
	int x,y;
	int MyScore=0;
 	boolean isVisible=true;
 	BufferedImage[]SpriteImages;
 	int ClownNumber=0;//0-7
 	int width=100,height=100;
 	String PlayerName;
	public Player() throws IOException
	{
		
		setSpriteImages();
		ChoosePlayerCharacter(ClownNumber);
	}
	public Player(String PlayerName) throws IOException
	{
		this.PlayerName=PlayerName;
		setSpriteImages();
		ChoosePlayerCharacter(ClownNumber);
	}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
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
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return isVisible;
	}
	public void setVisible(boolean Visability)
	{
		isVisible=Visability;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		//File file=new File("clowns\\56.png");
		File file=new File("clowns\\56.png");
		BufferedImage img[]=new BufferedImage[1];
		try {
			img[0]=ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
		
	}

	
	public void setSpriteImages() throws IOException
	{
		BufferedImage[] out=new BufferedImage[9];
		File file;
		String path="clowns";
		//System.out.println(type+ " ff");
		String []Number= {"1","2","3","4"
				,"5","6","7","8"};
		for(int i=0;i<8;i++)
		{   
			file=new File(path+"\\clown_"+Number[i]+".png");
			out[i]=ImageIO.read(file);
		}
		this.SpriteImages=out;
		
		
	
	}
	/**
	 * choose your character from the clowns pics
	 */
	public void ChoosePlayerCharacter(int ClownNumber)
	{
		this.ClownNumber=ClownNumber;
		System.out.println(this.ClownNumber+"a7o");
	}
	public BufferedImage getImage()
	{
		
		return SpriteImages[ClownNumber];
	}
	public void UpdatePlayerScore(int NewScore)
	{
		MyScore=NewScore;
	}
	public int getMyScore()
	{
		return MyScore;
	}
	public void SetScaleImage(int width,int height)
	{
		this.width=width;
		this.height=height;
	}
	public Image getScaledImage()
	{
		Image img=getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return img;
	}
	public void draw(Graphics g)
	{
		if(isVisible==false)
		{
			return;
		}
		Image img=getScaledImage();
		g.drawImage(img, getX(), getY(), this);
	}
	@Override
	public void update(Observable o, Object newScore) {
		// TODO Auto-generated method stub
		UpdatePlayerScore((int)newScore);
		
		
	}

}