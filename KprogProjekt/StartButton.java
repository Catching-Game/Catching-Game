import greenfoot.Actor;
import greenfoot.Greenfoot;
/**
 * Write a description of class StartButtons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            System.out.println("PlayButton");
}
    }
    
    public static StartButton createButton(){
        return new StartButton();
    }
}
