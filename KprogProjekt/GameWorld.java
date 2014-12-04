import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.text.Position;

/**
 * Our GameWorld Object representing the world of CATching Game.
 * 
 * @author simonhoinkis & maximilianschmidt
 * @version 1.0
 */
public class GameWorld extends World{    
	/**
	 * The width of the gameworld.
	 */
    private static final int WORLD_WIDTH      = XMLMapReader.getWorldWidth();
    
    /**
     * The height of the gameworld.
     */
    private static final int WORLD_HEIGHT      = XMLMapReader.getWorldHeight();
    
    /**
     * The cellsize of the gameworld.
     */
    private static final int WORLD_CELLSIZE    = XMLMapReader.getWorldCellsize();
    
    /**
     * Constructor for objects of class GameWorld.
     */
    public GameWorld(){
        super(GameWorld.WORLD_WIDTH, GameWorld.WORLD_HEIGHT, GameWorld.WORLD_CELLSIZE);
        this.setupStart();
    }

    /**
     * Sets the Background
     */
    private void setBackground(){
        this.setBackground(XMLMapReader.getWorldBackgroundImage());
    }

    /**
     * Sets up the World.
     * @param playerCount the number of players
     */
    public void setUpWorld(int playerCount) {
    	//clear the buttons
    	this.removeObjects(getObjects(StartButton.class));
        this.setWalls();
        this.setPlayer(playerCount);
        this.setTrees();
        this.setHounds();
        this.setMice();
        this.addGameParts();
    }
    
    /**
     * Set up Load world from SaveXML.
     */
    public void setUpLoadWorld(){
    	//clear the buttons
    	this.removeObjects(getObjects(StartButton.class));
        this.setWalls();
        this.setTrees();
        this.loadPlayers();
        this.loadHounds();
        this.loadMice();
        this.addGameParts();
    }
    
    /**
     * adds a win condition and a game pause /save possibility.
     */
    private void addGameParts() {
        this.addObject(new Pause(), 0, 0);
        this.addObject(new Win(), 0, 0);
    }
    
    /**
     * Loads the number of players into the game.
     */
    public void loadPlayers() {
      int playerCount = XMLSavestateReader.getPlayerCount();
      PlayerID p;
      p = PlayerID.FOURTH;
      if (XMLSavestateReader.isExisting(p)) {
        this.addObject(new Player(this.getCellSize(), XMLMapReader.getPlayerName(p), this, p, "5", "8", "7", "9", XMLSavestateReader.getPlayerLife(p)),
        		XMLSavestateReader.getPlayerPosition(p).getX(),
                XMLSavestateReader.getPlayerPosition(p).getY());
      }
      p = PlayerID.THIRD;
      if (XMLSavestateReader.isExisting(p)) {
        this.addObject(new Player(this.getCellSize(), XMLMapReader.getPlayerName(p), this, p, "t", "g", "f", "h", XMLSavestateReader.getPlayerLife(p)),
        		XMLSavestateReader.getPlayerPosition(p).getX(),
                XMLSavestateReader.getPlayerPosition(p).getY());
      }
      p = PlayerID.SECOND;
      if (XMLSavestateReader.isExisting(p)) {
        this.addObject(new Player(this.getCellSize(), XMLMapReader.getPlayerName(p), this, p, "w", "s", "a", "d", XMLSavestateReader.getPlayerLife(p)), 
        		XMLSavestateReader.getPlayerPosition(p).getX(),
                XMLSavestateReader.getPlayerPosition(p).getY());
      }
        p = PlayerID.FIRST;
      if (XMLSavestateReader.isExisting(p)) {
        this.addObject(new Player(this.getCellSize(), XMLMapReader.getPlayerName(p), this, p, "up", "down", "left", "right", XMLSavestateReader.getPlayerLife(p)),
        		XMLSavestateReader.getPlayerPosition(p).getX(),
                XMLSavestateReader.getPlayerPosition(p).getY());
      }
    }
    
    /**
     * Load hounds.
     */
    private void loadHounds() {
      for (int i = 0; i < XMLSavestateReader.getHoundCount(); i++) {
        int posY = XMLSavestateReader.getHoundPositions().get(i).getY();
        int posX = XMLSavestateReader.getHoundPositions().get(i).getX();
        int cellSize = this.getCellSize();
        this.addObject(Hound.getInstance(cellSize), posX, posY);
      }
    }

    /**
     * Set up the Load Mice in the Gameworld.
     */
    private void loadMice() {
      for (int i = 0; i < XMLSavestateReader.getMiceCount(); i++) {
        int posY = XMLSavestateReader.getMicePositions().get(i).getY();
        int posX = XMLSavestateReader.getMicePositions().get(i).getX();
        Direction dir = XMLSavestateReader.getMicePositions().get(i).getDir();
        int cellSize = this.getCellSize();
        this.addObject(new Mouse(cellSize, dir), posX, posY);
      }
    }
    
    /**
     * Sets up the walls.
     */
    private void setWalls(){
        //Iteration to set up the walls
        for (int i = 0; i < XMLMapReader.getWallCount(); i++) {
            this.addObject(new Wall(this.getCellSize()), 
                XMLMapReader.getWallPositions().get(i).getX(), 
                XMLMapReader.getWallPositions().get(i).getY());
        }
    }

    /**
     * Sets up the player in the Gameworld.
     * @param playerCount the number of players
     */
    private void setPlayer(int playerCount) {
        PlayerID p;
        
        if (playerCount == 4) {
            p = PlayerID.FOURTH;
            this.addObject(new Player(this.getCellSize(), XMLMapReader.getPlayerName(p), this, p, "5", "8", "7", "9", XMLGamelogicReader.getPlayerLifes()),
            		XMLMapReader.getPlayerPosition(p).getX(),
            XMLMapReader.getPlayerPosition(p).getY());
        }
        if (playerCount >= 3) {
            p = PlayerID.THIRD;
            this.addObject(new Player(this.getCellSize(), XMLMapReader.getPlayerName(p), this, p, "t", "g", "f", "h", XMLGamelogicReader.getPlayerLifes()),
            		XMLMapReader.getPlayerPosition(p).getX(),
                    XMLMapReader.getPlayerPosition(p).getY());
        }
        if (playerCount >=2) {
            p = PlayerID.SECOND;  
            this.addObject(new Player(this.getCellSize(), XMLMapReader.getPlayerName(p), this, p, "w", "s", "a", "d", XMLGamelogicReader.getPlayerLifes()),
            		XMLMapReader.getPlayerPosition(p).getX(),
                    XMLMapReader.getPlayerPosition(p).getY());
            
            p = PlayerID.FIRST;
            this.addObject(new Player(this.getCellSize(), XMLMapReader.getPlayerName(p), this, p, "up", "down", "left", "right", XMLGamelogicReader.getPlayerLifes()),
            		XMLMapReader.getPlayerPosition(p).getX(),
            XMLMapReader.getPlayerPosition(p).getY());
        }
    }

    /**
     * Set up Tree Image from xml.
     */
    private void setTrees(){
        for (int i = 0; i < XMLMapReader.getTreeCount(); i++){
            int posY = XMLMapReader.getTreePositions().get(i).getY();
            int posX = XMLMapReader.getTreePositions().get(i).getX();
            int cellSize = this.getCellSize();
            this.addObject(new Tree(cellSize), posX, posY);
        }
    }

    /**
     * Set up the Hounds in the Gameworld.
     */
    private void setHounds() {
    	//Sets only one Hound because we got a single tone pattern
        for (int i = 0; i < XMLMapReader.getHoundCount(); i++){
            int posY = XMLMapReader.getHoundPositions().get(i).getY();
            int posX = XMLMapReader.getHoundPositions().get(i).getX();
            int cellSize = this.getCellSize();
            this.addObject(Hound.getInstance(cellSize),posX,posY);
        }

    }

    /**
     * Set up the Mice in the Gameworld.
     */
    private void setMice() {
        for (int i = 0;i < XMLMapReader.getMiceCount(); i++){
            int posY = XMLMapReader.getMicePositions().get(i).getY();
            int posX = XMLMapReader.getMicePositions().get(i).getX();
            Direction dir = XMLMapReader.getMicePositions().get(i).getDir();
            int cellSize = this.getCellSize();
            this.addObject(new Mouse(cellSize,dir), posX, posY);
        }
    }

    /**
     * Starts the game with four buttons to choose if you want.
     * to load a previous game or how many players you want for.
     * starting a new one.
     */
    private void setupStart(){
    	//Defines the four buttones
        StartButton loadButton = StartButton.createButton();
        loadButton.setName("Spiel Laden");
        loadButton.setImage();
        StartButton twoPlayerButton = StartButton.createButton();
        twoPlayerButton.setName("2 Spieler");
        twoPlayerButton.setImage();
        StartButton threePlayerButton = StartButton.createButton();
        threePlayerButton.setName("3 Spieler");
        threePlayerButton.setImage();
        StartButton fourPlayerButton = StartButton.createButton();
        fourPlayerButton.setName("4 Spieler");     
        fourPlayerButton.setImage();

        //add the to the world
        this.addObject(loadButton, 5, 5);
        this.addObject(twoPlayerButton, 6, 6);
        this.addObject(threePlayerButton, 7, 7);
        this.addObject(fourPlayerButton, 8, 8);

        //Sets a standard background
        setBackground(XMLMapReader.getWorldBackgroundImage());
  }
}
