
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
}
