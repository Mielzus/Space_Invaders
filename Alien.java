import javax.swing.ImageIcon;

public class Alien{
	
	/** The x coordinate of the alien **/
	private int x;
	/** The y coordinate of the alien **/
	private int y;
	/** The score added when the alien dies **/
	private int score;
	/** Whether or not the alien should be visible **/
	private boolean draw;
	/** The image displayed for the alien **/
	private ImageIcon image;
	
	/**
	  * Creates a new alien
	  * @param x The x coordinate of the alien
	  * @param y The y coordinate of the alien
	  * @param score The score the alien gives upon death
	  * @param image The image to be displayed on the label
	  */
	public Alien(int x, int y, int score, ImageIcon image){
		this.x = x;
		this.y = y;
		this.score = score;
		this.image = image;
		this.draw = true;
	}
	
	/**
	  * Retruns the x coordinate
	  * @return The x coordinate
	  */
	public int getX(){
		return x;
	}
	
	/**
	  * Retruns the y coordinate
	  * @return The y coordinate
	  */
	public int getY(){
		return y;
	}
	
	/**
	  * Retruns the alien score
	  * @return The alien score
	  */
	public int getScore(){
		return score;
	}
	
	/**
	  * Returns the imgae displayed for the alien
	  * @return the image for the alien
	  */
	public ImageIcon getIcon(){
		return image;
	}
	
	/**
	  * Retruns true or false depending on whether or not to draw the alien
	  * @return Whether or not to draw the alien
	  */
	public boolean getVisible(){
		return draw;
	}
	
	/**
	  * Sets the value of the x coordinate
	  * @param x The x coordinate
	  */
	public void setX(int x){
		this.x = x;
	}
	
	/**
	  * Sets the value of the y coordinate
	  * @param y The y coordinate
	  */
	public void setY(int y){
		this.y = y;
	}
	
	/**
	  * Sets the image to be displayed for this alien
	  * @param image The image to display
	  */
	public void setIcon(ImageIcon image){
		this.image = image;
	}
	
	/**
	  * Sets the visibility of the alien
	  * @param draw true or false on whether to draw the alien
	  */
	public void setVisible(boolean draw){
		this.draw = draw;
	}
}