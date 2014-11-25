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
    	GreenfootImage image = new GreenfootImage(XML_Map_Reader.getPlayerImage(PlayerID.FIRST));
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
    	this.eat();
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
    	for (int i = 0; i < this.speed; i++) {
    		if(this.canWalk(this.wantedDir)) {
    			this.walk(wantedDir);
    		}
    	}
    }
    
    /**
     * Walks into a certain direction
     * @param dir The direction
     */
    private void walk(Direction dir) {
        if(dir == Direction.UP) {
            this.setLocation(this.getX(), this.getY() -1);
        } else if (dir == Direction.DOWN) {
            this.setLocation(this.getX(), this.getY() +1);
        } else if (dir == Direction.LEFT) {
            this.setLocation(this.getX() -1, this.getY());
        } else if (dir == Direction.RIGHT) {
            this.setLocation(this.getX() +1, this.getY());
        }
    }
    
    /**
     * Checks if a player can walk into a certain direction
     * @param dir The direction
     * @return True if we can walk into this direction, false if not
     */
    private boolean canWalk(Direction dir) {
        //some collision stuff
        //TODO simplify
        if(dir == Direction.UP) {
            if (this.getOneObjectAtOffset(0, -1, Wall.class) != null) {
                return false;
            }
        } else if (dir == Direction.DOWN) {
            if (this.getOneObjectAtOffset(0, +1, Wall.class) != null) {
                return false;
            }
        } else if (dir == Direction.LEFT) {
            if (this.getOneObjectAtOffset(-1, 0, Wall.class) != null) {
                return false;
            }
        } else if (dir == Direction.RIGHT) {
            if (this.getOneObjectAtOffset(1, 0, Wall.class) != null) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Checks if a player touches a mouse, eats it and increases life if so
     */
    private void eat() {
    	if (this.isTouching(Mouse.class)) {
    		Mouse mouse = (Mouse) this.getOneIntersectingObject(Mouse.class);
    		this.lifes += mouse.getLifeIncreasement();
    		this.removeTouching(Mouse.class);
    	}
    }
}
