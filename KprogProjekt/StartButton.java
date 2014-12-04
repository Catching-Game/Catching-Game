<<<<<<< HEAD
import java.awt.Color;

import greenfoot.*;
=======

import greenfoot.Actor;
import greenfoot.Greenfoot;

>>>>>>> origin/master
/**
 * Write a description of class StartButtons here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{
<<<<<<< HEAD
    private String name;
    private static final Color transparent = new Color(50,50,50,50);
    private static int playerCount;
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void act()
    {
        
        if(Greenfoot.mouseClicked(this)){
            if(this.name == "Spiel Laden"){
                System.out.println("Spiel Laden");
            } else if(this.name == "2 Spieler"){
            	this.playerCount = 2;
                System.out.println("2 Spieler");
                ((GameWorld) this.getWorld()).setUpWorld(this.playerCount);
                
            } else if(this.name == "3 Spieler"){
            	this.playerCount = 3;
                System.out.println("3 Spieler");
                ((GameWorld) this.getWorld()).setUpWorld(this.playerCount);            
            } else if(this.name == "4 Spieler"){
            	this.playerCount = 4;
                System.out.println("4 Spieler");
                ((GameWorld) this.getWorld()).setUpWorld(this.playerCount);
            }
        }
        
    }
    
    public static StartButton createButton(){
        return new StartButton();
    }
    
    public void setName(String e){
        this.name = e;
    }
    
    /**
     * Update the image on screen to show the current value.
     * @author Neil Brown and Michael Kölling 
     */
    public void setImage()
    {
        GreenfootImage image = new GreenfootImage(XMLMapReader.getCounterImage());
        GreenfootImage text = new GreenfootImage(this.name, 22, Color.BLACK, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
    
    public static int getPlayercount(){
    	return playerCount;
    }
=======

  protected int playerCount = 1; // at least one player
  private final int ONEPLAYER = 1;
  private final int TWOPLAYERS = 2;
  private final int THREEPLAYERS = 3;
  private final int FOURPLAYERS = 4;

  public StartButton(int playerCount)
  {
    this.playerCount = playerCount;
  }

  /**
   * An example of a method - replace this comment with your own.
   *
   * @param y a sample parameter for a method
   * @return the sum of x and y
   */
  public void act()
  {
    System.out.println(Greenfoot.getMouseInfo().getButton());
    if (Greenfoot.mouseClicked(this))
    {
      if (playerCount == TWOPLAYERS)
      {
        System.out.println("Two Player");
      }
      if (playerCount == THREEPLAYERS)
      {
        System.out.println("Three PLayer");
      }
      if (playerCount == FOURPLAYERS)
      {
        System.out.println("Four Player");
      }
    }
  }

  /**
   * Create a Startbutton.
   *
   * @param playerCount the number of players
   * @return return the button with number of players
   */
  public static StartButton createButton(final int playerCount)
  {
    return new StartButton(playerCount);
  }
>>>>>>> origin/master
}
