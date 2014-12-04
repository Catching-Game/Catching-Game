import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import java.awt.Color;

/**
 * this class provides the start buttons in the main menu.
 *
 * @author heikorehder,maximilianschmidt,matthiaskoehler,simonhoinkis
 * @version 1.0
 */
public class StartButton extends Actor
{
    private String name;
    private static final Color transparent = new Color(50,50,50,50);
    private static int playerCount;

    /**
     * Act method of Greenfoot
     */
    public void act()
    {
        
        if(Greenfoot.mouseClicked(this)){
            if(this.name == "Spiel Laden"){
                ((GameWorld) this.getWorld()).setUpLoadWorld();
            } else if(this.name == "2 Spieler"){
            	this.playerCount = 2;
                ((GameWorld) this.getWorld()).setUpWorld(this.playerCount);
                
            } else if(this.name == "3 Spieler"){
            	this.playerCount = 3;
                ((GameWorld) this.getWorld()).setUpWorld(this.playerCount);            
            } else if(this.name == "4 Spieler"){
            	this.playerCount = 4;
                ((GameWorld) this.getWorld()).setUpWorld(this.playerCount);
            }
        }
        
    }
    
    /**
     * Creates the button
     * @return the button
     */
    public static StartButton createButton(){
        return new StartButton();
    }
    
    /**
     * Sets name of the Button
     * @param e the new name of the button
     */
    public void setName(String e){
        this.name = e;
    }
    
    /**
     * Update the image on screen to show the current value.
     */
    public void setImage()
    {
        if(this.name == "Spiel Laden"){
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
                GreenfootImage image = new GreenfootImage(XMLMapReader.getButtonImageTwoPlayers());
               
                setImage(image);
            } else if(this.name == "3 Spieler"){
            	this.playerCount = 3;
            	GreenfootImage image = new GreenfootImage(XMLMapReader.getButtonImageThreePlayers());     
               setImage(image);
            } else if(this.name == "4 Spieler"){
            	this.playerCount = 4;
            	
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
    
    /**
     * Returns the current playerCount of the game.
     * @return the player count
     */
    public static int getPlayercount(){
    	return StartButton.playerCount;
    }
}
