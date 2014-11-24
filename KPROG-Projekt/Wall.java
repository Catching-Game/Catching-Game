import java.util.ArrayList;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{    
	/**
	 * Constructor of a Wall
	 * @param cellSize The CellSize of the World
	 */
    public Wall(int cellSize)
    {
    	setUpImage(cellSize);
    }
    
    /**
     * Sets up the image
     * @param cellSize The CellSize of the World
     */
    private void setUpImage(int cellSize) {
    	GreenfootImage image = new GreenfootImage(XML_Map_Reader.getWallImage());
    	image.scale(cellSize, cellSize);
    	this.setImage(image);    	
    }
    
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    

}
