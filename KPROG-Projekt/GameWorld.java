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
    private static int worldHeight      = XML_Map_Reader.getWorldHeight();
    private static int worldWidth       = XML_Map_Reader.getWorldWidth();
    private static int worldCellSize    = XML_Map_Reader.getWorldCellsize();
    
    
    
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {
        super(worldHeight, worldWidth, worldCellSize);
        //setWorld();
        setBackground();
        setWalls();
    }
 
    
    private void setBackground()
    {
        super.setBackground(XML_Map_Reader.getWorldBackgroundImage());
    }
    
    private void setWalls()
    {

        
    }
    
}
