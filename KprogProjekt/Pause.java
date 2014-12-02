import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class provides a pause function for our project
 * 
 * @author simonhoinkis
 * @version 1.0 
 */
public class Pause extends Actor
{
    private boolean running = true; //indicates if the game is running or not
    
    /**
     * Act - do whatever the Pause wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("escape")) {
        	if(running) {
        	    Greenfoot.stop();
        	    XMLSavestateWriter.save((GameWorld) this.getWorld());
        	    running = false;
        	} else {
        	    Greenfoot.start();
        	    running = true;
        	}
        }    
    }
}
