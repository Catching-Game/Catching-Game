import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class provides a pause function for our project.
 * 
 * @author simonhoinkis
 * @version 1.0 
 */
public class Pause extends Actor {
    /**
     * Act - do whatever the Pause wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("escape")) {
        	//saves the world
        	XMLSavestateWriter.save((GameWorld) this.getWorld());
        	//stops the current game
        	Greenfoot.stop();
        }    
    }
}
