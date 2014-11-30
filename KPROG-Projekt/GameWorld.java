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
    private static final int WORLD_WIDTH      = XML_Map_Reader.getWorldWidth();
    private static final int WORLD_HEIGHT      = XML_Map_Reader.getWorldHeight();
    private static final int WORLD_CELLSIZE    = XML_Map_Reader.getWorldCellsize();

    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld(){
        super(GameWorld.WORLD_WIDTH, GameWorld.WORLD_HEIGHT, GameWorld.WORLD_CELLSIZE);
        this.startFrame();
        this.setBackground();
        this.setUpWorld();
    }

    /**
     * Sets the Background
     */
    private void setBackground(){
        this.setBackground(XML_Map_Reader.getWorldBackgroundImage());
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
        //TODO anstatt der 1 muss noch die genaue spieleranzahl eingefuegt werden 
        this.setLiveCounter(1);
    }
    
    /**
     * Show input Dialog 
     */
    private void startFrame(){
    	TheFrame frame = new TheFrame();
//    	do{
//    		Greenfoot.stop();
//    	}while(frame.getisNewGame() == frame.getisLoadGame());
//    	if(frame.getisNewGame() != frame.getisLoadGame()){
//    		if(frame.getisNewGame() == true){
//    			Greenfoot.start();
//    			System.out.print("newgame function");
//    	        this.setBackground();
//    	        this.setUpWorld();
//    	        prepare();
//    		}else if(frame.getisLoadGame() == true){
//    			super.start();
//    			System.out.print("loadgame function");
//    	        this.setBackground();
//    	        this.setUpWorld();
//    		}
//    	}
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
        for (int i = 0; i < XML_Map_Reader.getWallCount(); i++) {
            this.addObject(new Wall(this.getCellSize()), 
                XML_Map_Reader.getWallPositions().get(i).getX(), 
                XML_Map_Reader.getWallPositions().get(i).getY());
        }
    }

    /**
     * Sets up the player in the Gameworld
     */
    private void setPlayer(){   
        this.addObject(new Player(this.getCellSize()), XML_Map_Reader.getPlayerPosition(PlayerID.FIRST).getX(),
            XML_Map_Reader.getPlayerPosition(PlayerID.FIRST).getY());
        //TODO ID System zum Test wurde nur die PlayerID.First eingefuegt
    }

    /**
     * Set up Tree Image from xml
     */
    private void setTrees(){
        for (int i = 0; i < XML_Map_Reader.getTreeCount(); i++){
            int posY = XML_Map_Reader.getTreePositions().get(i).getY();
            int posX = XML_Map_Reader.getTreePositions().get(i).getX();
            int cellSize = this.getCellSize();
            this.addObject(new Tree(cellSize), posX, posY);
        }
    }

    /**
     * Set up the Hounds in the Gameworld
     */
    private void setHounds(){
        for (int i = 0; i < XML_Map_Reader.getHoundCount(); i++){
            int posY = XML_Map_Reader.getHoundPositions().get(i).getY();
            int posX = XML_Map_Reader.getHoundPositions().get(i).getX();
            int cellSize = this.getCellSize();
            this.addObject(new Hound(cellSize),posX,posY);
        }

    }

    /**
     * Set up the Mice in the Gameworld
     */
    private void setMice(){
        for (int i = 0;i < XML_Map_Reader.getMiceCount(); i++){
            int posY = XML_Map_Reader.getMicePositions().get(i).getY();
            int posX = XML_Map_Reader.getMicePositions().get(i).getX();
            Direction dir = XML_Map_Reader.getMicePositions().get(i).getDir();
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
    
    private void setLiveCounter(int anzahlSpieler){
        for(int i = 0; i < anzahlSpieler;i = i + 1){
            String name = "Spieler: ";
            int posX = XML_Map_Reader.getCounterPosition().get(i).getX();
            int posY = XML_Map_Reader.getCounterPosition().get(i).getY();
            int life = XML_Gamelogic_Reader.getPlayerLifes();
            Zaehleranzeige zaehler = new Zaehleranzeige(name,life,posX,posY);
            addObject(zaehler.getCounter(),zaehler.getX(),zaehler.getY());
        }
    }
}
