
import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Write a description of class StartButtons here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{ 
    protected int playerCount = 1; // at least one player
    
    
    private final int THREEPLAYERS = 3;
    private final int FOURPLAYERS = 4;
    public StartButton(int playerCount)
    {
        this.playerCount = playerCount;
    }
  /**
   * An example of a method - replace this comment with your own
   *
   * @param y a sample parameter for a method
   * @return the sum of x and y
   */
  public void act()
  {
    if (Greenfoot.mouseClicked(this))
    {
      if (playerCount == 1)
      {
          System.out.println("One Player");
        }
        if (playerCount == 2)
        {
            System.out.println("Two Player");
        }
    }
    
    //if(Greenfoot.mouseClicked(twoPlayerButton))
    //{
    //  System.out.println("TwoPlayerButton");
   // }
  }

  public static StartButton createButton(int playerCount)
  {
    return new StartButton(playerCount);
  }
}
