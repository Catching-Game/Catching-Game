

import greenfoot.GreenfootSound;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Matthias Köhler
 */
public class Sound {

    /**
     * The current soundtrack
     */
    public GreenfootSound soundtrack;

    /**
     * Button to stop the song
     */
    private Button buttonStop;

    /**
     * Constructor of class Sound.
     */
    public Sound() {
        createSound();
        soundtrack.playLoop();
    }

    /**
     * Creates a sound for greenfoot from the folder sounds.
     */
    private void createSound() {
        GreenfootSound gs = new GreenfootSound("sounds/cantina.mp3");
        this.soundtrack = gs;
    }
    /**
     * Change your current Song -- change to XML
     */
    public void changeSong(String s)
    {
        if(s == "Gummibärenbande")
        {
            GreenfootSound gs = new GreenfootSound("sounds/gummibären.mp3");
            this.soundtrack = gs;
            this.soundtrack.playLoop();
        }
        if(s == "Cantinaband")
        {
            GreenfootSound gs = new GreenfootSound("sounds/cantina.mp3");
            this.soundtrack = gs;
            this.soundtrack.playLoop();
        }
        if(s == "I3est Song")
        {
            GreenfootSound gs = new GreenfootSound("sounds/fantasy.mp3");
            this.soundtrack = gs;
            this.soundtrack.playLoop();
        }
        
    }
}
