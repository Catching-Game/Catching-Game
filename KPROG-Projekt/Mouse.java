import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * this class represents our mouse in the game
 * 
 * @author heikorehder
 * @version 0.1 / 23.11.2014
 */
public class Mouse extends Actor {
	private int speed;
	private int lifeIncrease;
	private int sightRange;

	public Mouse(int cellSize) {
		init(cellSize);
		act();
	}

	/**
	 * init all variables of the actor.
	 */

	public void init(int cellSize) {
		this.speed = XML_Gamelogic_Reader.getPlayerSpeed();
		this.lifeIncrease = XML_Gamelogic_Reader.getMouseLifeIncrease();
		this.sightRange = XML_Gamelogic_Reader.getMouseLifeIncrease();
		this.setUpImage(cellSize);
	}

	/**
	 * Sets up the Image of the mouse
	 * 
	 * @param cellSize
	 */
	private void setUpImage(int cellSize) {
		GreenfootImage image = new GreenfootImage(XML_Map_Reader.getMiceImage());
		image.scale(cellSize, cellSize);
		this.setImage(image);

	}
	
	public void act(){
		
	}
}
