package View;

import javax.swing.*;
import javax.swing.JFrame;


import Objects.Plate;
import Objects.*;
import Objects.NonBasedPlate;
import Objects.Plate;
import Objects.Bar;



import java.util.*;
import java.util.Timer;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Gui extends JPanel  {
    public int create=0,x=400,y=500,ads,width;
    boolean caught=false;
    ArrayList<Plate> List=new ArrayList<>();
    ArrayList <Plate> catched=new ArrayList<>();
    ArrayList <Plate> temp=new ArrayList<>();
	private JFrame frame;
	

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
            try {
				Plate p =new  NonBasedPlate(-150,75);
				List.add(p);
				width=p.getWidth();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
			  final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
			    executorService.scheduleAtFixedRate(new Runnable() {
			        @Override
			        public void run() {	
			          repaint();
			        }
			    }, 2000, 50, TimeUnit.MILLISECONDS);
			    
		}
		private static final long serialVersionUID = 1L;
	public void paintComponent(Graphics g) {

	  create++;
	  if(create%15==0) {
		  try {
			Plate p =new  NonBasedPlate(-150,75);
			p.SetSpriteImages();
			p.setColor((int) ((Math.random()*11)));
			List.add(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  create=0;
	  }
	  super.paintComponent(g);
	  Bar b=new Bar();
		b.setX(x);
		b.setY(y);
		b.setWidth(width);
		b.draw(g);
		temp.clear();
		for(Plate p : List) {
			caught=false;
			for(int i=catched.size()-1;i>=0;i--) {
				Plate t=catched.get(i);
			if(Math.abs(p.getX()-t.getX())<=3*p.getWidth()/4&&Math.abs(p.getY()+p.getHeight()-t.getY())<10) {
					caught=true;i=-1;
					p.setY(t.getY()-p.getHeight());
					p.setHeightFromClown(b.getY()-p.getY());
				}
			}
		if(caught||(Math.abs(p.getY()+p.getHeight()-b.getY())<10&&(Math.abs(p.getX()-b.getX())<3*p.getWidth()/4))) {
			temp.add(p);
			if(!caught) {
				p.setY(b.getY()-p.getHeight());
				p.setHeightFromClown(b.getY()-p.getY());
			}
			
			p.setShiftX(p.getX()-b.getX());
			catched.add(p);
		    
		}
		else if(p.getX()==400) {
	    	p.setY(p.getY()+10);
	    	p.draw(g);}
	    else {
		p.setX(p.getX()+10);
		p.draw(g);
	    }
		  if(p.getY()>1000) {
		    	temp.add(p);
		    }
	}
		
	for(Plate p : catched) {
		p.setX(p.getShiftX()+b.getX());
		p.setY(b.getY()-p.getHeightFromClown());
		p.draw(g);
	}
	for(Plate p : temp) {
		List.remove(p);
	}

	  
	  
	  
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