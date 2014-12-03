
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Write a description of class Start here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Start extends World {

    private static final int WORLD_WIDTH = XMLMapReader.getWorldWidth();
    private static final int WORLD_HEIGHT = XMLMapReader.getWorldHeight();
    private static final int WORLD_CELLSIZE = XMLMapReader.getWorldCellsize();

    private PlayButton playButton;
    private TwoPlayerButton twoPlayerButton;
    private ThreePlayerButton threePlayerButton;
    private FourPlayerButton fourPlayerButton;

    protected int playerCount;
    protected GreenfootImage image;

    /**
     * Constructor for objects of class StartScreen.
     *
     */
    public Start() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, WORLD_CELLSIZE);
        //clear the system out print console
        System.out.print('\f');
        //super(GameWorld.WORLD_WIDTH, GameWorld.WORLD_HEIGHT, GameWorld.WORLD_CELLSIZE);
        this.initStartScreen();
    }

    private void initStartScreen() {
        this.playButton = new PlayButton();
        this.twoPlayerButton = new TwoPlayerButton();
        this.threePlayerButton = new ThreePlayerButton();
        this.fourPlayerButton = new FourPlayerButton();

        this.addObject(playButton, 5, 5);
        this.addObject(twoPlayerButton, 6, 6);
        this.addObject(threePlayerButton, 7, 7);
        this.addObject(fourPlayerButton, 8, 8);

        setBackground(XMLMapReader.getWorldBackgroundImage());
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;

    }

    public int showPlayerCount() {        
        return this.playerCount;
    }

    private class PlayButton extends Actor {

        public PlayButton() {            
            this.setImage(XMLMapReader.getCounterImage());
            act();
        }

        public void act() {
            System.out.println("----- PlayButton act method");
            buttonClick();
            System.out.println("leave act method");
            GameWorld gameWorld = new GameWorld(playerCount);  
        }

        private void buttonClick() {
            if (Greenfoot.mouseClicked(this)) {
                System.out.println("----- PlayButton pressed");
                System.out.println("-- starting new Gameworld...");                              
            }
        }
       
    }

    private class TwoPlayerButton extends Actor {

        private final int PLAYERCOUNT = 2;        

        /**
         * Default Constructor of TwoPlayerConstructor
         */
        public TwoPlayerButton() {            
            this.setImage(XMLMapReader.getCounterImage());
            act();
        }

        @Override
        public final void act() {
            
            System.out.println("----- TwoPlayerButton act method");
            
            if (Greenfoot.mouseClicked(this)) {
                System.out.println("-- Button pressed");
                playerCount = this.PLAYERCOUNT;
                System.out.println("-- #" + showPlayerCount() + "# Playermode selected");
            }
            System.out.println("leave act method");
        }

    }

    private class ThreePlayerButton extends Actor {

    }

    private class FourPlayerButton extends Actor {

    }

}
