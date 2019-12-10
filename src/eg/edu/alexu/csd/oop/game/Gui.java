package eg.edu.alexu.csd.oop.game;

import javax.swing.*;
import javax.swing.JFrame;

import java.util.*;
import java.util.Timer;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Gui extends JPanel  {
    public int create=0,x=400,counter=0,y=500;
    public int xs[]= {-70,-65,-15,-10};
    public int ys[]= {75,90,90,75};
    ArrayList<plate> List=new ArrayList<>();
    ArrayList <plate> catched=new ArrayList<>();
    ArrayList <plate> temp=new ArrayList<>();
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas =new Canvas();
        frame.add(canvas);

    }
	
	public class Canvas extends JPanel implements KeyListener {
		

		public Canvas() {
			this.addKeyListener(new KeyListener() 
					{
				 @Override
				    public void keyTyped(KeyEvent e) {

				        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				            x+=30;
				        }
				        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				           x-=30;
				        }
				        if (e.getKeyCode() == KeyEvent.VK_UP) {
				        	y-=30;
				        }
				        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				        	y+=30;
				        }
				    }

				    @Override
				    public void keyPressed(KeyEvent e) {
				         
				    	  if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				              x+=30;
				              
				          }
				          if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				              x-=30;
				          }
				          
				          if (e.getKeyCode() == KeyEvent.VK_UP) {
					        	y-=30;
					        }
					        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					        	y+=30;
					        }
				    }

				    @Override
				    public void keyReleased(KeyEvent e) {
				    
				    	
				    }
					}
					
					);
			this.setFocusable(true);
            this.requestFocusInWindow();
			plate p=new plate(xs,ys);
     	   List.add(p);
     	   
     	   
			  final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
			    executorService.scheduleAtFixedRate(new Runnable() {
			        @Override
			        public void run() {	
			          repaint();
			        }
			    }, 2000, 80, TimeUnit.MILLISECONDS);
		}
		private static final long serialVersionUID = 1L;
	public void paintComponent(Graphics g) {
	    create++;
        if(create%10==0) {
     	   plate t=new plate(xs,ys);
     	   List.add(t);
     	   create=0;
        }
		super.paintComponent(g);
	   bar b=new bar();
		b.setX(x);
		b.setY(y);
		b.draw(g);
		temp.clear();
	    for(plate k : List) {
	    if(k.getY()>(y-15*counter)&&x==400&&k.getY()<(y+50-15*counter)) {
	    	temp.add(k);
	    	k.setX(x);
	    	k.setY(y-counter*15);
	    	k.moving=false;
	    	k.setcounter(counter);
	    	catched.add(k);
	    	counter++;
	    }
	    else {k.draw(g);}
	    if(k.getY()>1000) {temp.add(k);}
	   }
	    for(plate k : temp) {List.remove(k);}
	  for (plate k : catched) {
	    	k.setX(x);
	    	k.setY(y-15*k.getcounter());
	    	k.draw(g);}	
	  
	  
	  
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
	

}
