import java.util.Random;

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
	private Direction wantedDir;
	
	/**
	 * Set Up the Hound Image, Movement,etc.
	 * @param cellSize
	 */
	public Hound(int cellSize, Direction dir){
		init(cellSize, dir);
	}
	
    /**
     * Act - do whatever the Hound wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       
        this.move();
    }    
	
	private void init(int cellSize, Direction dir){
		this.speed = XML_Gamelogic_Reader.getHoundSpeed();
		this.setUpImage(cellSize);
		this.wantedDir = dir;
		
	}
	
	private void setUpImage(int cellSize){
		GreenfootImage image = new GreenfootImage(XML_Map_Reader.getHoundImage());
		image.scale(cellSize,cellSize);
		this.setImage(image);
	}

    
	private void move() {

		
		 if (this.canWalkUP() && this.wantedDir == Direction.UP) {
			walkUP();
			this.wantedDir = Direction.UP;
		}
		 else if (this.canWalkDOWN() && this.wantedDir == Direction.DOWN) {
			walkDOWN();
			this.wantedDir = Direction.DOWN;
		}
			
		 else if (this.canWalkLEFT() && this.wantedDir == Direction.LEFT) {
			walkLEFT();
			this.wantedDir = Direction.LEFT;
		}
		 else if (this.canWalkRIGHT() && this.wantedDir == Direction.RIGHT) {
			walkRIGHT();
			this.wantedDir = Direction.RIGHT;
	}
		 else {
			 
			 if (randomDir() == 0 && this.canWalkDOWN()) {
					walkDOWN();
					this.wantedDir = Direction.DOWN;
				} else if (randomDir() == 1 && this.canWalkLEFT()) {
					walkLEFT();
					this.wantedDir = Direction.LEFT;
				} else if (randomDir() == 2 && this.canWalkRIGHT()) {
					walkRIGHT();
					this.wantedDir = Direction.RIGHT;
				}
				else if (randomDir() == 3 && this.canWalkUP()){
					
					walkUP();
					this.wantedDir = Direction.UP;
				}
			 
		 }
	}

		 
	
	
	

	/**
	 * Checks if mouse can walk up
	 * 
	 * @return true if yes, no if not
	 */
	private boolean canWalkUP() {
		if (this.getOneObjectAtOffset(0, -speed, Wall.class) != null) {
			return false;
		}
		else if(this.getOneObjectAtOffset(0, -speed, Mouse.class) != null){
			return false;
		}
		else if(this.getOneObjectAtOffset(0, -speed, Hound.class) != null){
			return false;
		}
		

		return true;
	}

	/**
	 * Checks if mouse can walk down
	 * 
	 * @return true if yes, no if not
	 */
	private boolean canWalkDOWN() {
		if (this.getOneObjectAtOffset(0, +speed, Wall.class) != null) {
			return false;
		}
		else if(this.getOneObjectAtOffset(0, +speed, Mouse.class) != null){
			return false;
		}
		else if(this.getOneObjectAtOffset(0, +speed, Hound.class) != null){
			return false;
		}

		return true;
	}

	/**
	 * Checks if mouse can walk left
	 * 
	 * @return true if yes, no if not
	 */
	private boolean canWalkLEFT() {
		if (this.getOneObjectAtOffset(-speed, 0, Wall.class) != null) {
			return false;
		}
		else if(this.getOneObjectAtOffset(-speed, 0, Mouse.class) != null){
			return false;
		}
		else if(this.getOneObjectAtOffset(-speed, 0, Hound.class) != null){
			return false;
		}

		return true;
	}

	/**
	 * Checks if mouse can walk right
	 * 
	 * @return true if yes, no if not
	 */
	private boolean canWalkRIGHT() {
		if (this.getOneObjectAtOffset(+speed, 0, Wall.class) != null) {
			return false;
		}
		else if(this.getOneObjectAtOffset(+speed, 0, Mouse.class) != null){
			return false;
		}
		else if(this.getOneObjectAtOffset(+speed, 0, Hound.class) != null){
			return false;
		}

		return true;
	}

	private void walkUP() {
		this.setLocation(this.getX(), this.getY() - this.speed);
	}

	private void walkDOWN() {
		this.setLocation(this.getX(), this.getY() + this.speed);
	}

	private void walkLEFT() {
		this.setLocation(this.getX() - this.speed, this.getY());
	}

	private void walkRIGHT() {
		this.setLocation(this.getX() + this.speed, this.getY());
	}

	public int randomDir() {
		Random random = new Random();
		return random.nextInt(4);

	}
}
