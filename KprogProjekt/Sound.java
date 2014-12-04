
import greenfoot.GreenfootSound;
import java.util.HashMap;

/**
 * Listen to some music while playing. This class has 120 max. codelength in one line.
 * @author Matthias Köhler
 */
public class Sound
{
  /**
   * The current soundtrack.
   */
  private GreenfootSound soundtrack;
  /**
   * HashMap to save some songs.
   */
  private final HashMap<String, String> songlist;

  /**
   * Constructor of class Sound.
   */
  public Sound()
  {
    createSound("sounds/cantina.mp3"); //default song from beginning.
    soundtrack.playLoop();
    songlist = new HashMap();
    populateHashMap();
  }

  /**
   * Creates a sound for greenfoot from the folder sounds.
   * @param s the name of the song you want to create.
   * @return a new sound to work with.
   */
  private GreenfootSound createSound(final String s)
  {
    GreenfootSound gs = new GreenfootSound(s);
    this.soundtrack = gs;
    return gs;
  }
  /**
   * Pause the current song.
   */
  public final void pauseSong()
  {
    this.soundtrack.pause();
  }
  
  /**
   * Play the current song.
   */
  public final void playSong()
  {
    this.soundtrack.playLoop();
  }

  /**
   * Ignore this, its an old version.
   * Just to see how you can save LOC by thinking some time.
   * Change your current Song old version. Unused but stays to compare this version with HashMap Version.
   *
   * @param s name of the song to play
   */
  public final void changeSong(final String s)
  {
    if (s == "Gummibärenbande")
    {
      GreenfootSound gs = new GreenfootSound("sounds/gummibären.mp3");
      this.soundtrack = gs;
      this.soundtrack.playLoop();
    }
    if (s == "Cantinaband")
    {
      GreenfootSound gs = new GreenfootSound("sounds/cantina.mp3");
      this.soundtrack = gs;
      this.soundtrack.playLoop();
    }
    if (s == "I3est Song")
    {
      GreenfootSound gs = new GreenfootSound("sounds/fantasy.mp3");
      this.soundtrack = gs;
      this.soundtrack.playLoop();
    }

  }
  /**
   * Change your current Song version HashMap.
   */
  public final void changeSongWithHashMap(final String s)
  {
    this.soundtrack.stop();
    for (String song : songlist.keySet())
    {
      if (s.equals(song))
      {
        this.soundtrack = createSound(songlist.get(song));
        this.soundtrack.playLoop();
      }
    }
  }

  /**
   * Adds songs to the HashMap.
   */
  public final void populateHashMap()
  {
    songlist.put("Gummibärenbande", "sounds/gummibären.mp3");
    songlist.put("Cantinaband", "sounds/cantina.mp3");
    songlist.put("I3est Song", "sounds/fantasy.mp3");
  }
} //end of class Sound
