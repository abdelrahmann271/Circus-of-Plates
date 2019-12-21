package Objects;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.List;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Levels.Level;
import Levels.LevelFactory;
import Levels.LevelOne;
import Levels.LevelThree;
import Levels.LevelTwo;
import Score.Score;

public class Test extends JPanel {
int x=20;
int ads=(int) ((Math.random()*11));
ArrayList<Plate> list=new ArrayList<Plate>();
public Test() throws IOException
{
	this.setFocusable(true);
    this.requestFocusInWindow();
    Image img = createImageWithText();

   // g.drawImage(img,50,50,this);
    Level asd=LevelOne.getInstance();
    Level asd2=LevelTwo.getInstance();
    System.out.println(System.identityHashCode(asd));
    System.out.println(System.identityHashCode(asd2));
    LevelFactory a=LevelFactory.getInstance();
	PlateFactory b=PlateFactory.getUniqueInstance();
	Score s=Score.getInstance();
	s.setScore(52);
	
	Level as=a.getMyLevel();

	System.out.println(as.getcurrentLevel());
	System.out.println(System.identityHashCode(a.getMyLevel()));
	System.out.println(System.identityHashCode(a.One));
	
	System.out.println(b.getSupportedColors());
	list.add(b.GenerateRandomPlate("left"));
	
	  final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
	    executorService.scheduleAtFixedRate(new Runnable() {
	        @Override
	        public void run() {	
	        	
	       x++;
	    //   System.out.println("asd");
	          repaint();
	          
	        }
	    }, 2000, 80, TimeUnit.MILLISECONDS);
}
   public void paint(Graphics g) {
	   super.paint(g);
      Image img = createImageWithText();
    
   for(int i=0;i<list.size();i++)
   {
	   Plate a=list.get(i);
	   a.setX(50+i*30);
	   a.setY(50+i*30);
	   a.draw(g);
   }
	  // System.out.println();
	  //a.draw(g);
	
	   g.drawLine(0, 10+x*10, 20, 30);
	   repaint();
        

      //g.drawImage(img,50,50,this);
   }
	public static final int SPRITE_WIDTH = 40;
   private Image createImageWithText() {
      BufferedImage bufferedImage =new BufferedImage(200, 200,	BufferedImage.TYPE_INT_ARGB);
      Graphics g = bufferedImage.getGraphics();
      int a=1;
      File file;
      if(a==1)
     file =new File("plates\\goldplatewithdeepbase.png");
      else
      {
    	  file=new File("C:\\Users\\OWNER\\git\\circusofplates6\\plates\\blackplatewithdeepbase.png");
      }
      BufferedImage bufferedImage2=null;
      try {
		 bufferedImage2 =ImageIO.read(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
	//Graphics g2=bufferedImage2.getGraphics();
	//g2.drawImage(bufferedImage2, 0, 0, 200, 200, null);
	/*
      g.drawString("www.tutorialspoint.com", 20,20);
      g.drawString("www.tutorialspoint.com", 20,40);
      g.drawString("www.tutorialspoint.com", 20,60);
      g.drawString("www.tutorialspoint.com", 20,80);
      g.drawString("www.tutorialspoint.com", 20,100);
      
      */
      //System.out.println(bufferedImage2.getWidth()+ "dd");
      return bufferedImage2;
   }
   
   public static void main(String[] args) throws IOException {
	 
      JFrame frame = new JFrame();
      frame.getContentPane().add(new Test());

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400, 400);
      frame.setVisible(true);
      
   }
}