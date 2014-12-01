import greenfoot.GreenfootSound;

/**
 * @author Matthias Köhler
 */
public class Sound
{

  public Sound()
  {
    createSound();
    System.out.println("Sound created and loop started.Have fun!");
  }
  
  private void createSound()
  {
    GreenfootSound gs = new GreenfootSound("sounds/cantina.mp3");
    gs.playLoop();
  }

}
