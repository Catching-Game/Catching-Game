import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DrawableActor here.
 * 
 * @author simonhoinkis
 * @version 1.0
 */
public class DrawableActor extends Actor
{
    private String IMAGEPATH = "";
    
    protected DrawableActor(int cellSize, String IMAGEPATH) {
        this.IMAGEPATH = IMAGEPATH;
        setUpImage(cellSize);
    }
    
    /**
     * Sets up the image
     * @param cellSize The CellSize of the World
     */
    private void setUpImage(int cellSize) {
    	GreenfootImage image = new GreenfootImage(IMAGEPATH);
    	image.scale(cellSize, cellSize);
    	this.setImage(image);    	
    }
    
    
    /**
     * Act - do whatever the DrawableActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
