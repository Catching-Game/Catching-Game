import java.util.ArrayList;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author simonhoinkis
 * @version 1.0
 */
public class Wall extends DrawableActor
{    
	/**
	 * Constructor of a Wall
	 * @param cellSize The CellSize of the World
	 */
    public Wall(int cellSize)
    {
    	super(cellSize, XMLMapReader.getWallImage());
    }
    
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //The wall doesn't want to do anything
    }
}
