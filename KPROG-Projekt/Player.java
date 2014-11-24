import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * this class represents our Player in the game
 * @author simonhoinkis
 * @version 0.1
 */
public class Player extends Actor
{
	private int lifes;
	private int speed;
	private Direction wantedDir; //the direction the player wants to walk
	
	public Player(int cellSize) {
		init(cellSize);
	}
	
	/**
	 * init all variables of the actor
	 */
	private void init(int cellSize) {
		this.lifes = XML_Gamelogic_Reader.getPlayerLifes();
		this.speed = XML_Gamelogic_Reader.getPlayerSpeed();
		this.setUpImage(cellSize);
	}
	
	/**
	 * Sets up the Image of the player
	 * @param cellSize
	 */
	private void setUpImage(int cellSize) {
    	GreenfootImage image = new GreenfootImage(XML_Map_Reader.getPlayer().getChildText("image");
    	image.scale(cellSize, cellSize);
    	this.setImage(image);    
	}
	
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    	this.input();
    	this.move();
        // Add your action code here.
    }
    
    /**
     * Get the current wanted direction and saves it in wantedDir
     */
    private void input() {
    	if(Greenfoot.isKeyDown("up")) {
    		this.wantedDir = Direction.UP;
    	} else if(Greenfoot.isKeyDown("down")) {
    		this.wantedDir = Direction.DOWN;
    	} else if(Greenfoot.isKeyDown("left")) {
    		this.wantedDir = Direction.LEFT;
    	} else if(Greenfoot.isKeyDown("right")) {
    		this.wantedDir = Direction.RIGHT;
    	} else {
    		this.wantedDir = Direction.NONE;
    	}
    }
    
    /**
     * The Player Movement
     */
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
     * Checks if player can walk up
     * @return true if yes, no if not
     */
    private boolean canWalkUP() {
    	if(this.getOneObjectAtOffset(0, -speed, Wall.class) != null) {
    		return false;
    	}
    	
    	return true;
    }

    /**
     * Checks if player can walk down
     * @return true if yes, no if not
     */
    private boolean canWalkDOWN() {
    	if(this.getOneObjectAtOffset(0, +speed, Wall.class) != null) {
    		return false;
    	}
    	
    	return true;  	
    }
    
    /**
     * Checks if player can walk left
     * @return true if yes, no if not
     */
    private boolean canWalkLEFT() {
    	if(this.getOneObjectAtOffset(-speed, 0, Wall.class) != null) {
    		return false;
    	}
    	
    	return true;
    }
    
    /**
     * Checks if player can walk right
     * @return true if yes, no if not
     */
    private boolean canWalkRIGHT() {
    	if(this.getOneObjectAtOffset(+speed, 0, Wall.class) != null) {
    		return false;
    	}
    	
    	return true;
    }
}
