import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * this class represents our mouse in the game
 * @author heikorehder
 * @version 0.1 / 23.11.2014
 */
public class Mouse extends Actor {
//	
//	
//	public void act(){
//		
//		//input();
//		move();
//	}
//	
//  
//
//	
//    private void move() {
//    	if(this.canWalkUP() && this.wantedDir == Direction.UP) {
//    		this.setLocation(this.getX(), this.getY() - this.speed);
//    		this.wantedDir = this.getDir();
//    	} else if(this.canWalkDOWN() && this.wantedDir == Direction.DOWN) {
//    		this.setLocation(this.getX(), this.getY() + this.speed);
//    	} else if(this.canWalkLEFT() && this.wantedDir == Direction.LEFT) {
//    		this.setLocation(this.getX() - this.speed, this.getY());
//    	} else if(this.canWalkRIGHT() && this.wantedDir == Direction.RIGHT) {
//    		this.setLocation(this.getX() + this.speed, this.getY());
//    	}
//    }
//    
//	
//    /**
//     * Checks if mouse can walk up
//     * @return true if yes, no if not
//     */
//    private boolean canWalkUP() {
//    	if(this.getOneObjectAtOffset(0, -speed, Wall.class) != null) {
//    		return false;
//    	}
//    	
//    	return true;
//    }
//
//    /**
//     * Checks if mouse can walk down
//     * @return true if yes, no if not
//     */
//    private boolean canWalkDOWN() {
//    	if(this.getOneObjectAtOffset(0, +speed, Wall.class) != null) {
//    		return false;
//    	}
//    	
//    	return true;  	
//    }
//    
//    /**
//     * Checks if mouse can walk left
//     * @return true if yes, no if not
//     */
//    private boolean canWalkLEFT() {
//    	if(this.getOneObjectAtOffset(-speed, 0, Wall.class) != null) {
//    		return false;
//    	}
//    	
//    	return true;
//    }
//    
//    /**
//     * Checks if mouse can walk right
//     * @return true if yes, no if not
//     */
//    private boolean canWalkRIGHT() {
//    	if(this.getOneObjectAtOffset(+speed, 0, Wall.class) != null) {
//    		return false;
//    	}
//    	
//    	return true;
//    }
}
