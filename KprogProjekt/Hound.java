
import org.jdom2.Element;

/**
 * Write a description of class Hound here.
 *
 * @author simonhoinkis
 * @version 0.1
 */
public class Hound extends MovableActor
{
  /**
   * Defines the speed of a hound moving in the gameworld.
   */
  private int speed;

  /**
   * Setup an image and the movement of a hound.
   * @param cellSize the cellsize of the gameworld
   */
  public Hound(final int cellSize)
  {
    super(cellSize, XMLMapReader.getHoundImage());
    init(cellSize);
  }

  /**
   * Act - do whatever the Hound wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in
   * the environment.
   */
  public void act()
  {
    this.input();
    this.move();
  }
  
  /**
   * Initialize class hound with a specific speed.
   * @param cellSize defines the speed of a hound.
   */
  private void init(final int cellSize)
  {
    this.speed = XML_Gamelogic_Reader.getHoundSpeed();
  }

  /**
   * The input of a hound.
   */
  private void input()
  {
    //TODO this is already coded in another version but not imported yet. 
  }

  /**
   * Defines how a hound moves.
   */
  private void move()
  {
    //TODO this is already coded in another version but not imported yet.
  }

  /**
   * saves the current state of the hound.
   */
  public Element save()
  {
    Element hound = new Element("hound");
    hound.addContent(new Element("position_x").setText(String.valueOf(this.getX())));
    hound.addContent(new Element("position_y").setText(String.valueOf(this.getY())));
    return hound;
  }
}
