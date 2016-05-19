import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener{

	/** The icons for the aliens **/
	private ImageIcon smallAlien_1 = new ImageIcon("images/aliens/smallInvader.png");
	private ImageIcon smallAlien_2 = new ImageIcon("images/aliens/smallInvader_2.png");
	private ImageIcon mediumAlien_1 = new ImageIcon("images/aliens/mediumInvader.png");
	private ImageIcon mediumAlien_2 = new ImageIcon("images/aliens/mediumInvader_2.png");
	private ImageIcon largeAlien_1 = new ImageIcon("images/aliens/largeInvader.png");
	private ImageIcon largeAlien_2 = new ImageIcon("images/aliens/largeInvader_2.png");
	/** Icon for bonus UFO **/
	private ImageIcon ufo = new ImageIcon("images/aliens/ufo.png");
	/** Player cannon **/
	private ImageIcon cannon = new ImageIcon("images/cannon/laserCannon.png");
	/** Game bullet **/
	private ImageIcon bullet = new ImageIcon("images/cannon/bullet.png");
	
	/** Timer to create an action at the end of each interval **/
	private Timer tm = new Timer(5, this);
	/** The array to hold all of the alien objects **/
	private Alien[][] aliens = new Alien[5][11];
	
	/**Game window dimensions **/
	private int winX = 1000, winY = 700;
	/** Cannon position **/
	private int cannonX = winX/2 -32, cannonY = winY-75;
	/** Alien start location **/
	private int x = 148, y = 60;
	/** Velocity for the aliens and cannon **/
	private int alienVelocity = 1, cannonVelocity = 0;
	/** Counter variable **/
	private int counter, version = 1;
	
	/**
	  * Creates new alien objects and places them relative to the current 
	  * x and y values
	  */
	private void resetAliens(){
		for(int i = 0; i < aliens.length; i++){
			for(int j = 0; j < aliens[i].length; j++){
				if(version == -1){
					if(i < 1)
						aliens[i][j] = new Alien(x, y, 10, smallAlien_1);
					else if(i < 3)
						aliens[i][j] = new Alien(x, y, 20, mediumAlien_1);
					else if(i < 5)
						aliens[i][j] = new Alien(x, y, 30, largeAlien_1);
				}
				else if(version == 1){
					if(i < 1)
						aliens[i][j] = new Alien(x, y, 10, smallAlien_2);
					else if(i < 3)
						aliens[i][j] = new Alien(x, y, 20, mediumAlien_2);
					else if(i < 5)
						aliens[i][j] = new Alien(x, y, 30, largeAlien_2);
				}
				x += 64;
			}
			y += 64;
			x -= 704;
		}
		y -= 320;
	}
	
	/**
	  * Creates a new game panel by starting the timer and
	  * setting up the aliens in their initial positions
	  */
	public GamePanel(){
		tm.start();
		resetAliens();
	}
	
	/**
	  * Colours the background and draws the appropriate ImageIcons to the panel
	  * @param g The graphics module 
	  */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, winX, winY);
		for(int i = 0; i < aliens.length; i++){
			for(int j = 0; j < aliens[i].length; j++){
				Alien temp = aliens[i][j];
				g.setColor(Color.WHITE);
				g.drawString(Integer.toString(temp.getScore()), temp.getX(), temp.getY());
				if(temp.getVisible())
					(temp.getIcon()).paintIcon(this, g, temp.getX(), temp.getY());
			}
		}
		cannon.paintIcon(this, g, cannonX, cannonY);
	}
	
	/**
	  * Moves the aliens according the their set velocity
	  * Moves the cannon based on user keypresses
	  * Changes the aliens appearance after a number of cycles
	  */
	public void actionPerformed(ActionEvent e){
		if(aliens[0][0].getX() < 0 || aliens[0][10].getX() > winX-64){
			x -= alienVelocity;
			y += 10;
			alienVelocity *= -1;
		}
		else if(aliens[4][0].getY() > winY-64)
			alienVelocity = 0;
		else{
			x += alienVelocity;
		}
		cannonX += cannonVelocity;
		counter++;
		if(counter % 50 == 0)
			version *= -1;
		resetAliens();
		repaint();
	}
	
	/**
	  * Performs actions based on the depressed key intputted
	  * @param keyCode the ASCII code of the keypress from the user
	  */
	public void passPressedKey(int keyCode){
		if(keyCode == KeyEvent.VK_LEFT){
			cannonVelocity = -3;
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			cannonVelocity = 3;
		}
	}
	
	/**
	  * Performs actions based on the released key intputted
	  * @param keyCode the ASCII code of the key release from the user
	  */
	public void passReleasedKey(int keyCode){
		if(keyCode == KeyEvent.VK_LEFT){
			cannonVelocity = 0;
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			cannonVelocity = 0;
		}
	}
}