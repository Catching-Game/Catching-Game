import greenfoot.GreenfootSound;

/**
 * @author Matthias Köhler
 */
public class Sound
{
  /**
   * The current soundtrack
   */
  private GreenfootSound soundtrack;
  /**
   * Constructor of class Sound.
   */
  public Sound()
  {
    createSound();
//    soundtrack.playLoop();
    System.out.println("Sound created and loop started.Have fun!");
  }

  /**
   * Creates a sound for greenfoot from the folder sounds.
   */
  private void createSound()
  {
    GreenfootSound gs = new GreenfootSound("sounds/cantina.mp3");
    this.soundtrack = gs;
  }
}
