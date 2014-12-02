import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.text.Position;

/**
 * Write a description of class GameWorld here.
 * 
 * @author simonhoinkis
 * @version 0.2
 */
public class GameWorld extends World{    
    private static final int WORLD_WIDTH      = XMLMapReader.getWorldWidth();
    private static final int WORLD_HEIGHT      = XMLMapReader.getWorldHeight();
    private static final int WORLD_CELLSIZE    = XMLMapReader.getWorldCellsize();
    


    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld(){
        super(GameWorld.WORLD_WIDTH, GameWorld.WORLD_HEIGHT, GameWorld.WORLD_CELLSIZE);

        this.setGui();

        
        prepare();
    }

    /**
     * Sets the Background
     */
    private void setBackground(){
        this.setBackground(XMLMapReader.getWorldBackgroundImage());
    }

    /**
     * Sets up the World
     */
    private void setUpWorld(){
        this.setWalls();
        this.setPlayer();
        this.setTrees();
        this.setHounds();
        this.setMice();
        //anstatt der 1 muss noch die genaue spieleranzahl eingefgt werden 
      
       
    }
    
    /**
     * Set up Load world from SaveXML
     */
    private void setUpLoadWorld(){
        
    }

    /**
     * Sets up the walls
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
     * Sets up the player in the Gameworld
     */
    private void setPlayer() {   
        this.addObject(new Player(this.getCellSize(), XMLMapReader.getPlayerName(PlayerID.FIRST), this, PlayerID.FIRST), XMLMapReader.getPlayerPosition(PlayerID.FIRST).getX(),
            XMLMapReader.getPlayerPosition(PlayerID.FIRST).getY());
        //TODO ID System zum Test wurde nur die PlayerID.First eingefuegt
    }

    /**
     * Set up Tree Image from xml
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
     * Set up the Hounds in the Gameworld
     */
    private void setHounds(){
        for (int i = 0; i < XMLMapReader.getHoundCount(); i++){
            int posY = XMLMapReader.getHoundPositions().get(i).getY();
            int posX = XMLMapReader.getHoundPositions().get(i).getX();
            int cellSize = this.getCellSize();
            this.addObject(new Hound(cellSize),posX,posY);
        }

    }

    /**
     * Set up the Mice in the Gameworld
     */
    private void setMice(){
        for (int i = 0;i < XMLMapReader.getMiceCount(); i++){
            int posY = XMLMapReader.getMicePositions().get(i).getY();
            int posX = XMLMapReader.getMicePositions().get(i).getX();
            Direction dir = XMLMapReader.getMicePositions().get(i).getDir();
            int cellSize = this.getCellSize();
            this.addObject(new Mouse(cellSize,dir),posX,posY);
        }
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare(){
    }
    



   private void setGui(){
       TheFrame frame = new TheFrame();
       boolean isLoadGame = false;
       boolean isNewGame = false;
       
       while (isLoadGame == isNewGame) {
    	   isLoadGame = frame.getIsLoadGame();
    	   isNewGame  = frame.getIsNewGame();
    	   Greenfoot.stop();
       }
       
       if(isLoadGame) {
    	   
       } else if (isNewGame) {
    	   Greenfoot.start();
           this.setBackground();
           this.setUpWorld();
       }
   }
}
