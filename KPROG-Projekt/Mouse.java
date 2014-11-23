import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * this class represents our Mouse in the game
 * @author heikorehder
 * @version 0.1 / 23.11.2014
 */
public class Mouse extends Actor
{
    private int speed;
    
    /*
     * init all variables of the actor
     */
    
    public Mouse(){
    	init();
    }
    

    public void init(){
    	this.speed = XML_Gamelogic_Reader.getPlayerSpeed();
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
