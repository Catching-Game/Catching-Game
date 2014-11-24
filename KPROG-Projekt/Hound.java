import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hound extends Actor
{
	private int speed;
	
	/**
	 * Set Up the Hound Image, Movement,etc.
	 * @param cellSize
	 */
	public Hound(int cellSize){
		init(cellSize);
	}
	
    /**
     * Act - do whatever the Hound wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.input();
        this.move();
    }    
	
	private void init(int cellSize){
		this.speed = XML_Gamelogic_Reader.getHoundSpeed();
		this.setUpImage(cellSize);
	}
	
	private void setUpImage(int cellSize){
		GreenfootImage image = new GreenfootImage(XML_Map_Reader.getHoundImage());
		image.scale(cellSize,cellSize);
		this.setImage(image);
	}

    
    private void input(){
    	
    }
    
    private void move(){
    	
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
