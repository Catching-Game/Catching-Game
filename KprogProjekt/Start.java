
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Start extends World {

    //  private static final int WORLD_WIDTH      = XMLMapReader.getWorldWidth();
    // private static final int WORLD_HEIGHT      = XMLMapReader.getWorldHeight();
    // private static final int WORLD_CELLSIZE    = XMLMapReader.getWorldCellsize();
    private PlayButton playButton;
    private TwoPlayerButton twoPlayerButton;

    private int playerCount;
    private ThreePlayerButton threePlayerButton;
    private FourPlayerButton fourPlayerButton;
    
    //The number of players who want to play the game
    private final int ONEPLAYER = 1;
    private final int TWOPLAYERS = 2;
    private final int THREEPLAYERS = 3;

    /**
     * Constructor for objects of class StartScreen.
     *
     */
    public Start() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        //super(GameWorld.WORLD_WIDTH, GameWorld.WORLD_HEIGHT, GameWorld.WORLD_CELLSIZE);
        this.initStartScreen();
        System.out.println("Number of actors currently in this world: " + numberOfObjects());
        //Greenfoot.start();
    }

    private void initStartScreen() {
        this.playButton = new PlayButton();
        this.twoPlayerButton = new TwoPlayerButton();
        this.threePlayerButton = new ThreePlayerButton();
        this.fourPlayerButton = new FourPlayerButton();

        this.addObject(playButton, 300, 100);
        this.addObject(twoPlayerButton, 100, 300);
        this.addObject(threePlayerButton, 200, 300);
        this.addObject(fourPlayerButton, 300, 300);

        setBackground(XMLMapReader.getWorldBackgroundImage());

    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;

    }

    public void showPlayerCount() {
        System.out.println(this.playerCount);
    }

    private class PlayButton extends Actor {
        
        GreenfootImage gi = new GreenfootImage(XMLMapReader.getCounterImage());
        private boolean alreadyClicked;
        
        int i = 0;

        public PlayButton() {
            
            act();
            this.setImage(gi);
            

        }

        public void act() {
            buttonClick();
        }

        private void buttonClick() {
            System.out.println("---- inside buttonClick of start.java");
            i++;
            System.out.println("Count: " +i);
            System.out.println("-- buttonAlreadyClicked = ´" + alreadyClicked + "´");
            if (Greenfoot.mouseClicked(this) && alreadyClicked == false) {
                setPlayerCount(ONEPLAYER);
                System.out.println("´" + ONEPLAYER + "´ player mode selected.");
                Greenfoot.stop();
                GameWorld gameWorld = new GameWorld(2);                
                this.alreadyClicked = true;
            }
        }
    }

    private class TwoPlayerButton extends Actor {

        public TwoPlayerButton() {

        }

        private final int PLAYERCOUNT = 2;

        @Override
        public void act() {
            if (Greenfoot.mouseClicked(this)) {
                setPlayerCount(PLAYERCOUNT);
            }
        }
    }

    private class ThreePlayerButton extends Actor {

    }

    private class FourPlayerButton extends Actor {

    }
}
