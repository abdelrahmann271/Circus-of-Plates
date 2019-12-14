package View;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Worlds.GameWorld;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;

import java.awt.Color;



public class GUItestFeatures extends javax.swing.JFrame {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	//Values in the constructor will change
	GameWorld gameWorldFirstLevel = new GameWorld(1000,1000); //Just trying the game engine with any world

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUItestFeatures window = new GUItestFeatures();
					window.frame.setVisible(true);
					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);	//Make The Game window take all the screen				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public GUItestFeatures() throws IOException {
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		//Just Put the background image path .. 
//		File file = new File("C:\\Users\\Abdelrahman Nour\\Desktop\\Tent2.png");
//		BufferedImage myImage = ImageIO.read(file);
//		frame.setContentPane(new Background(myImage));
		//Adding the JMenu bar for the game engine controllers...
		JMenuBar  menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		menu.setBackground(Color.YELLOW);
		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem pauseMenuItem = new JMenuItem("Pause");
		JMenuItem resumeMenuItem = new JMenuItem("Resume");
		menu.add(newMenuItem);
		menu.addSeparator();
		menu.add(pauseMenuItem);
		menu.add(resumeMenuItem);
		menuBar.add(menu);
//		frame.setJMenuBar(menuBar);
		
		final GameController gameController = GameEngine.start("Very Simple Game in 99 Line of Code", gameWorldFirstLevel, menuBar, Color.BLACK);
		newMenuItem.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
				gameController.changeWorld(gameWorldFirstLevel);
			}
		});
		pauseMenuItem.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
				gameController.pause();
			}
		});
		resumeMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gameController.resume();
			}
		});
		
		


	}
}
