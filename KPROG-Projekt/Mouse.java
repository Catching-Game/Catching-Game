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
	private Direction wantedDir;

	public Mouse(int cellSize, Direction dir) {
		init(cellSize,dir);
		this.wantedDir = dir;
	}

	/**
	 * init all variables of the actor.
	 */

	public void init(int cellSize, Direction dir) {
		this.speed = XML_Gamelogic_Reader.getMouseSpeed();
		this.lifeIncrease = XML_Gamelogic_Reader.getMouseLifeIncrease();
		this.sightRange = XML_Gamelogic_Reader.getMouseSightRange();
		this.wantedDir = dir;
		
		
		
		
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
		//input();
		move();
	}
	
  

	
    private void move() {
    	if(this.canWalkUP() && this.wantedDir == Direction.UP) {
    		this.setLocation(this.getX(), this.getY() - this.speed);
    	} else if(this.canWalkDOWN() && this.wantedDir == Direction.DOWN) {
    		this.setLocation(this.getX(), this.getY() + this.speed);
    	} else if(this.canWalkLEFT() && this.wantedDir == Direction.LEFT) {
    		this.setLocation(this.getX() - this.speed, this.getY());
    	} else if(this.canWalkRIGHT() && this.wantedDir == Direction.RIGHT) {
    		this.setLocation(this.getX() + this.speed, this.getY());
    	}
    }
    
	
    /**
     * Checks if mouse can walk up
     * @return true if yes, no if not
     */
    private boolean canWalkUP() {
    	if(this.getOneObjectAtOffset(0, -speed, Wall.class) != null) {
    		return false;
    	}
    	
    	return true;
    }

    /**
     * Checks if mouse can walk down
     * @return true if yes, no if not
     */
    private boolean canWalkDOWN() {
    	if(this.getOneObjectAtOffset(0, +speed, Wall.class) != null) {
    		return false;
    	}
    	
    	return true;  	
    }
    
    /**
     * Checks if mouse can walk left
     * @return true if yes, no if not
     */
    private boolean canWalkLEFT() {
    	if(this.getOneObjectAtOffset(-speed, 0, Wall.class) != null) {
    		return false;
    	}
    	
    	return true;
    }
    
    /**
     * Checks if mouse can walk right
     * @return true if yes, no if not
     */
    private boolean canWalkRIGHT() {
    	if(this.getOneObjectAtOffset(+speed, 0, Wall.class) != null) {
    		return false;
    	}
    	
    	return true;
    }
}
