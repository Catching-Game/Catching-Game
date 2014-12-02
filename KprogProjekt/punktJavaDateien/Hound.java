import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.jdom2.Element;

/**
 * Write a description of class Hound here.
 * 
 * @author simonhoinkis
 * @version 0.1
 */
public class Hound extends MovableActor
{
	private int speed;
	
	/**
	 * Set Up the Hound Image, Movement,etc.
	 * @param cellSize
	 */
	public Hound(int cellSize) {
	    super(cellSize, XMLMapReader.getHoundImage());
		init(cellSize);
	}
	
    /**
     * Act - do whatever the Hound wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.input();
        this.move();
    }    
	
	private void init(int cellSize){
		this.speed = XML_Gamelogic_Reader.getHoundSpeed();
	}
    
    private void input(){
    	
    }
    
    private void move(){
    	
    }
    
    /**
     * saves the current state of the hound
     */
    public Element save() {
    	Element hound = new Element("hound");
    	hound.addContent(new Element("position_x").setText(String.valueOf(this.getX())));
    	hound.addContent(new Element("position_y").setText(String.valueOf(this.getY())));
    	
    	return hound;
    }
}
