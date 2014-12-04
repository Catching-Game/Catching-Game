import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import java.awt.Color;

/**
 * Write a description of class StartButtons here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{
    private String name;
    private static final Color transparent = new Color(50,50,50,50);
    private static int playerCount;
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void act()
    {
        
        if(Greenfoot.mouseClicked(this)){
            if(this.name == "Spiel Laden"){
                System.out.println("Spiel Laden");
            } else if(this.name == "2 Spieler"){
            	this.playerCount = 2;
                System.out.println("2 Spieler");
                ((GameWorld) this.getWorld()).setUpWorld(this.playerCount);
                
            } else if(this.name == "3 Spieler"){
            	this.playerCount = 3;
                System.out.println("3 Spieler");
                ((GameWorld) this.getWorld()).setUpWorld(this.playerCount);            
            } else if(this.name == "4 Spieler"){
            	this.playerCount = 4;
                System.out.println("4 Spieler");
                ((GameWorld) this.getWorld()).setUpWorld(this.playerCount);
            }
        }
        
    }
    
    public static StartButton createButton(){
        return new StartButton();
    }
    
    public void setName(String e){
        this.name = e;
    }
    
    /**
     * Update the image on screen to show the current value.
     * @author Neil Brown and Michael Kölling 
     */
    public void setImage()
    {
        if(this.name == "Spiel Laden"){
                System.out.println("Spiel Laden");
                GreenfootImage image = new GreenfootImage(XMLMapReader.getCounterImage());
                GreenfootImage text = new GreenfootImage(this.name, 22, Color.BLACK, transparent);
                if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
                image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
                        setImage(image);
            } else if(this.name == "2 Spieler"){
            	this.playerCount = 2;
                System.out.println("2 Spieler");
                GreenfootImage image = new GreenfootImage(XMLMapReader.getButtonImageTwoPlayers());
               
                setImage(image);
            } else if(this.name == "3 Spieler"){
            	this.playerCount = 3;
            	GreenfootImage image = new GreenfootImage(XMLMapReader.getButtonImageThreePlayers());
                System.out.println("3 Spieler");
                         
               setImage(image);
            } else if(this.name == "4 Spieler"){
            	this.playerCount = 4;
                System.out.println("4 Spieler");
                GreenfootImage image = new GreenfootImage(XMLMapReader.getButtonImageFourPlayers());
                
                        setImage(image);
            }
        //GreenfootImage image = new GreenfootImage(XMLMapReader.getButtonImageTwoPlayers());
        //GreenfootImage text = new GreenfootImage(this.name, 22, Color.BLACK, transparent);
        
        //if (text.getWidth() > image.getWidth() - 20)
        //{
          //  image.scale(text.getWidth() + 20, image.getHeight());
        //}
        
        //image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                       // (image.getHeight()-text.getHeight())/2);
       // setImage(image);
    }
    
    public static int getPlayercount(){
    	return playerCount;
    }
}
