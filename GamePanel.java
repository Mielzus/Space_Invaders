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
	private ImageIcon bonusUFO = new ImageIcon("images/aliens/ufo.png");
	private ImageIcon laserCannon = new ImageIcon("images/cannon/laserCannon.png");
	private ImageIcon bullet = new ImageIcon("images/cannon/laser.png");
	
	/** Timer to create an action at the end of each interval **/
	private Timer tm = new Timer(5, this);
	/** The array to hold all of the alien objects **/
	private Alien[][] aliens = new Alien[5][11];
	
	/**Game window dimensions **/
	private int winX = 1000, winY = 700;
	/** Cannon position **/
	private int cannonX = winX/2 -32, cannonY = winY-75;
	/** laser position **/
	private int laserX, laserY;
	/** Alien start location **/
	private int x = 148, y = 60;
	/** Amount of pixels Alien objects move **/
	private int alienVelocity = 1, cannonXVel = 0, laserVelocity = 0;;
	/** Counter variable **/
	private int counter, version = 1;
	/** The variable to hold the players score **/
	private int score;
	
	/** Game UFO **/
	private Alien ufo = new Alien(0, 0, 0, bonusUFO);
	/** Player cannon **/
	private Alien cannon = new Alien(cannonX, cannonY, 0, laserCannon);
	/** Game bullet **/
	private Alien laser = new Alien(0, 0, 0, bullet);
	
	/**
	  * Creates new alien objects and places them relative to the current 
	  * x and y values
	  */
	private void resetAliens(){
		laser.setVisible(false);
		for(int i = 0; i < aliens.length; i++){
			for(int j = 0; j < aliens[i].length; j++){
				if(i < 1)
					aliens[i][j] = new Alien(x, y, 10, smallAlien_1);
				else if(i < 3)
					aliens[i][j] = new Alien(x, y, 20, mediumAlien_1);
				else if(i < 5)
					aliens[i][j] = new Alien(x, y, 30, largeAlien_1);
				x += 64;
			}
			y += 64;
			x -= 704;
		}
		y -= 320;
	}
	
	/**
	  * Updates the x and y positions of the alien objects
	  */
	private void updateAliens(){
		for(int i = 0; i < aliens.length; i++){
			for(int j = 0; j < aliens[i].length; j++){
				aliens[i][j].setX(x);
				aliens[i][j].setY(y);
				if(version == -1){
					if(i < 1)
						aliens[i][j].setIcon(smallAlien_1);
					else if(i < 3)
						aliens[i][j].setIcon(mediumAlien_1);
					else if(i < 5)
						aliens[i][j].setIcon(largeAlien_1);
				}
				else if(version == 1){
					if(i < 1)
						aliens[i][j].setIcon(smallAlien_2);
					else if(i < 3)
						aliens[i][j].setIcon(mediumAlien_2);
					else if(i < 5)
						aliens[i][j].setIcon(largeAlien_2);
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
	  * Detects if there is a collision between two Alien objects
	  * @param one The first object to compare
	  * @param two The second object to compare
	  * @return true or false based on collision status
	  */
	public boolean collision(Alien one, Alien two){
		int oneMidX = one.getX() +  one.getIcon().getIconWidth()/2;
		int oneMidY = one.getY() +  one.getIcon().getIconHeight()/2;
		int twoMidX = two.getX() +  two.getIcon().getIconWidth()/2;
		int twoMidY = two.getY() +  two.getIcon().getIconHeight()/2;
		if(Math.abs(oneMidX - twoMidX) < (one.getIcon().getIconWidth()/2 + two.getIcon().getIconWidth()/2) 
			&& Math.abs(oneMidY - twoMidY) < (one.getIcon().getIconHeight()/2 + two.getIcon().getIconHeight()/2))
			return true;
		else
			return false;
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
				if(temp.getVisible())
					(temp.getIcon()).paintIcon(this, g, temp.getX(), temp.getY());
			}
		}
		if(laser.getVisible())
			laser.getIcon().paintIcon(this, g, laser.getX(), laser.getY());
		
		cannon.getIcon().paintIcon(this, g, cannon.getX(), cannon.getY());
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("VERDANA", Font.BOLD, 25));
		g.drawString("Score", 50, 55);
		g.drawString(Integer.toString(score), 140, 55);
		//g.drawString("Lives", 700, 55);
	}
	
	/**
	  * Moves the aliens according the their set velocity
	  * Moves the cannon based on user keypresses
	  * Changes the aliens appearance after a number of cycles
	  * Checks if there is a collision between the aliens and cannon
	  * Adds to score if there is a collision
	  */
	public void actionPerformed(ActionEvent e){
		if(aliens[0][0].getX() < 0 || aliens[0][10].getX() > winX-64){
			x -= alienVelocity;
			y += 5;
			alienVelocity *= -1;
		}
		else{
			x += alienVelocity;
		}
		
		if(aliens[4][0].getY() > winY-64)
			alienVelocity = 0;
		
		for(int i = 0; i < aliens.length; i++){
			for(int j = 0; j < aliens[i].length; j++){
				//If the alien is visible
				if(aliens[i][j].getVisible()){
					//Checks if there is a collision between the two objects
					if(collision(aliens[i][j], laser) && aliens[i][j].getVisible() && laser.getVisible()){
						//Sets the visibility of the alien to false
						aliens[i][j].setVisible(!collision(aliens[i][j], laser));
						//Sets the visibility of the laser to false
						laser.setVisible(false);
						//Increments the score by the aliens score value
						score += aliens[i][j].getScore();
					}
				}
			}
		}
		
		if(cannon.getX() < -5){
			cannon.setX(-5);
			cannonXVel = 0;
		}
		else if(cannon.getX() > winX-60){
			cannon.setX(winX-60);
			cannonXVel = 0;
		}
		else{
			cannon.setX(cannon.getX() + cannonXVel);
		}
		
		laser.setY(laser.getY() + laserVelocity);
		if(laser.getY() < 0){
			laser.setVisible(false);
			laserVelocity = 0;
		}
		
		counter++;
		if(counter % 75 == 0)
			version *= -1;
		updateAliens();
		repaint();
	}
	
	/**
	  * Performs actions based on the depressed key intputted
	  * @param keyCode the ASCII code of the keypress from the user
	  */
	public void passPressedKey(int keyCode){
		if(keyCode == KeyEvent.VK_LEFT){
			cannonXVel = -3;
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			cannonXVel = 3;
		}
		if(keyCode == KeyEvent.VK_SPACE){
			if(!laser.getVisible()){
				laser.setX(cannon.getX() + laserCannon.getIconWidth()/2 - 4);
				laser.setY(cannon.getY() + 16);
				laser.setVisible(true);
				laserVelocity = -5;
			}
		}
	}
	
	/**
	  * Performs actions based on the released key intputted
	  * @param keyCode the ASCII code of the key release from the user
	  */
	public void passReleasedKey(int keyCode){
		if(keyCode == KeyEvent.VK_LEFT){
			cannonXVel = 0;
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			cannonXVel = 0;
		}
	}
}