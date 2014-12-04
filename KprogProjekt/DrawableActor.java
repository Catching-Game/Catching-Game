import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents an actor that can be drawn.
 * This means that this actor contains our setupimage method (scales image).
 * 
 * @author simonhoinkis
 * @version 1.0
 * code cleaned by Matthias Koehler
 */
public class DrawableActor extends Actor
{
	/**
	 * Path for the image.
	 */
    private String IMAGEPATH = "";
    
    /**
     * Constructor of class DrawableActor.
     * @param cellSize the cellsize to scale the image
     * @param IMAGEPATH the path of the image
     */
    protected DrawableActor(int cellSize, String IMAGEPATH) {
        this.IMAGEPATH = IMAGEPATH;
        setUpImage(cellSize);
    }
    
    /**
     * Sets up the image.
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
