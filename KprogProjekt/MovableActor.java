
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.jdom2.Element;

/**
 * Write a description of class MovableActor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class MovableActor extends DrawableActor {

    abstract public Element save();

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

    /**
     * Act - do whatever the MovableActor wants to do. This method is called
     * whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
    }
}
