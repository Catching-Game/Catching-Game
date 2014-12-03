import greenfoot.Actor;
import greenfoot.GreenfootImage;

/**
 * Write a description of class DrawableActor here.
 * @author simonhoinkis
 * @version 1.0
 */
public class DrawableActor extends Actor
{
  /**
   * Path for the image.
   */
    private String imagepath = "";
    /**
     * Constructor of class DrawableActor.
     * @param cellSize the cellsize to scale the image
     * @param imagepath the path of the image
     */
    protected DrawableActor(final int cellSize, final String imagepath) {
        this.imagepath = imagepath;
        setUpImage(cellSize);
    }

    /**
     * Sets up the image.
     * @param cellSize The CellSize of the World
     */
    private void setUpImage(final int cellSize) {
    	GreenfootImage image = new GreenfootImage(imagepath);
    	image.scale(cellSize, cellSize);
    	this.setImage(image);
    }
    
    /**
     * Act - do whatever the DrawableActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act()
    {
        // Add your action code here.
    }
} //end of class DrawableActor.
