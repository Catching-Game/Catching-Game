import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.jdom2.Element;

/**
 * Actors of this class can move around the world (abstract factory pattern).
 * 
 * @author simonhoinkis
 * @version version 1.0
 */
public abstract class MovableActor extends DrawableActor
{
    abstract public Element save();
    
    /**
     * herited constructor of MovableActor to create one.
     * @param cellSize the cellsize of the world
     * @param IMAGEPATH the path of the actor image
     */
    protected MovableActor(int cellSize, String IMAGEPATH) {
        super(cellSize, IMAGEPATH);
    }
    
    /**
     * Walks into a certain direction.
     *
     * @param dir The direction
     */
    protected void walk(Direction dir) {
        if (dir == Direction.UP) {
            this.setLocation(this.getX(), this.getY() - 1);
        } else if (dir == Direction.DOWN) {
            this.setLocation(this.getX(), this.getY() + 1);
        } else if (dir == Direction.LEFT) {
            this.setLocation(this.getX() - 1, this.getY());
        } else if (dir == Direction.RIGHT) {
            this.setLocation(this.getX() + 1, this.getY());
        }
    }
}
