import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
	
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(XML_Map_Reader.getWorldHeight(), XML_Map_Reader.getWorldWidth(), 
        		XML_Map_Reader.getWorldCellsize()); 
        
        setBackground(getWorldBackgroundImage());
        
    }
}
