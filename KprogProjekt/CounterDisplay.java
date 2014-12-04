import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.Observer; 
import java.util.Observable;

/**
 * A Counter class that allows you to display a numerical value on screen.
 * 
 * The Counter is an actor, so you will need to create it, and then add it to
 * the world in Greenfoot.  If you keep a reference to the Counter then you
 * can adjust its value.  Here's an example of a world class that
 * displays a counter with the number of act cycles that have occurred:
 * 
 * <pre>
 * class CountingWorld
 * {
 *     private Counter actCounter;
 *     
 *     public CountingWorld()
 *     {
 *         super(600, 400, 1);
 *         actCounter = new Counter("Act Cycles: ");
 *         addObject(actCounter, 100, 100);
 *     }
 *     
 *     public void act()
 *     {
 *         actCounter.setValue(actCounter.getValue() + 1);
 *     }
 * }
 * </pre>
 * 
 * @author Neil Brown and Michael K√∂lling&heikorehder,maximilianschmidt,simonhoinkis
 * @version 1.0
 */
public class CounterDisplay extends Actor implements Observer
{
    private static final Color transparent = new Color(50,50,50,50);
    private GreenfootImage background;
    private int lifes;
    private String playerName;


    /**
     * Create a new counter, initialised to 0.
     */
    public CounterDisplay(String name,int lifes)
    {
        background = new GreenfootImage(XMLMapReader.getCounterImage());  // get image from class
        this.lifes = lifes;
        this.playerName = name;
        updateImage();
    }
    
    /**
     * Animate the display to count up (or down) to the current target value.
     */
    public void act() 
    {
    }

    /**
     * Set a new counter value.  This will not animate the counter.
     */
    public void setValue(int newValue)
    {
        this.lifes = newValue;
        updateImage();
    }
    
    /**
     * Sets a text prefix that should be displayed before
     * the counter value (e.g. "Score: ").
     */
    public void setPrefix(String prefix)
    {
        this.playerName = prefix;
        updateImage();
    }

    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(XMLMapReader.getCounterImage());
        GreenfootImage text = new GreenfootImage(this.playerName.concat(":") + this.lifes, 22, Color.BLACK, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
    
    /*
     * Gets update from Observeable.
     */
    public void update(Observable o, Object life){
    	setValue( (Integer) life);
    
    }
    
    /**
     * Returns a playerName
     * @return the name of the player
     */
    public String getPlayerName(){
    	return this.playerName;
    }
}
