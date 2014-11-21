import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 *
 * @author Simon Hoinkis, Matthias Köhler, Heiko Rehder, Max Schmidt
 * @version 21.11.2014 - 15:21
 */
public class Enemy extends Actor
{

    public Enemy()
    {
        act();

    }

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        try
        {
            setImage("/Dog.png");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("This Image path is not working...");
        }
    }
    
    public static void main(String[] args)
    {
        Enemy e = new Enemy();
       
    }
}
