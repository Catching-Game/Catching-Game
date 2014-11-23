import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.text.Position;

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{    
    private static final int WORLD_WIDTH      = XML_Map_Reader.getWorldWidth();
    private static final int WORLD_HEIGHT      = XML_Map_Reader.getWorldHeight();
    private static final int WORLD_CELLSIZE    = XML_Map_Reader.getWorldCellsize();

    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {
    	super(GameWorld.WORLD_WIDTH, GameWorld.WORLD_HEIGHT, GameWorld.WORLD_CELLSIZE);

        this.setBackground();
        this.setUpWorld();
    }
 
    private void setBackground()
    {
        this.setBackground(XML_Map_Reader.getWorldBackgroundImage());
    }
    
    private void setUpWorld() {
    	this.setWalls();
    	this.setPlayer();
    }
    
    private void setWalls()
    {
    	//Iteration to set up the walls
    	for (int i = 0; i < XML_Map_Reader.getWallCount(); i++) {
    		this.addObject(new Wall(this.getCellSize()), XML_Map_Reader.getWallPositions().get(i).getX(), 
    										XML_Map_Reader.getWallPositions().get(i).getY());
    	}
    }
    
    private void setPlayer() {	
    	this.addObject(new Player(this.getCellSize()), XML_Map_Reader.getPlayerPosition(PlayerID.FIRST).getX(),
    								XML_Map_Reader.getPlayerPosition(PlayerID.FIRST).getY());
    	//TODO ID System zum Test wurde nur die PlayerID.First eingefuegt
    }
    
}
