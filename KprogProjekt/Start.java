
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
    
    

    /**
     * Constructor for objects of class StartScreen.
     *
     */
    public Start() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        //super(GameWorld.WORLD_WIDTH, GameWorld.WORLD_HEIGHT, GameWorld.WORLD_CELLSIZE);
        this.initStartScreen();
        Greenfoot.start();
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
        

        public void act() {
            buttonClick();
        }

        private void buttonClick() {
            if (Greenfoot.mouseClicked(this)) {
                GameWorld gameWorld = new GameWorld(playerCount);
            }
        }
    }

        private class TwoPlayerButton extends Actor {

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
