
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.jdom2.Element;

import java.util.Random;

/**
 * this class represents our mouse in the game.
 *
 * @author heikorehder&simonhoinkis&Maximilian Schmidt
 * @version 0.4 / 26.11.2014
 */
public class Mouse extends MovableActor {

    private int speed;
    private int lifeIncrease;
    private int sightRange;
    private Direction wantedDir;
/**
 * constructor for class mouse.
 * @param cellSize
 * @param dir 
 */
    public Mouse(int cellSize, Direction dir) {
        super(cellSize, XMLMapReader.getMiceImage());
        init(cellSize, dir);
    }

    /**
     * init all variables of the actor.
     */
    public void init(int cellSize, Direction dir) {
        this.speed = XMLGamelogicReader.getMouseSpeed();
        this.lifeIncrease = XMLGamelogicReader.getMouseLifeIncrease();
        this.sightRange = XMLGamelogicReader.getMouseSightRange();
        this.wantedDir = dir;
    }

    public void act() {
        move();
    }

    /**
     * Move Method.
     */
    private void move() {
        for (int i = 0; i < this.speed; i++) {
            if (this.canWalk(wantedDir) && !mouseSeesCat()) {
                this.walk(this.wantedDir);
            } else {
                boolean foundSolution = false;
                int tryCount = 0;
                while (!foundSolution && tryCount != 5) {
                    Direction dir = this.randomDir(wantedDir);
                    if (this.canWalk(dir)) {
                        foundSolution = true;
                        this.walk(dir);
                        wantedDir = dir;
                    }
                    tryCount++;
                }
            }
        }
    }

    /**
     * Checks if u can walk into some Directions.
     *
     * @param dir The direction you want walk to
     * @return True if you can, false if not
     */
    private boolean canWalk(Direction dir) {
        //some collision stuff
        //TODO simplify
        if (dir == Direction.UP) {
            if (this.getOneObjectAtOffset(0, -1, Wall.class) != null
                    || this.getOneObjectAtOffset(0, -1, Mouse.class) != null
                    || this.getOneObjectAtOffset(0, -1, Hound.class) != null) {
                return false;
            }
        } else if (dir == Direction.DOWN) {
            if (this.getOneObjectAtOffset(0, +1, Wall.class) != null
                    || this.getOneObjectAtOffset(0, +1, Mouse.class) != null
                    || this.getOneObjectAtOffset(0, +1, Hound.class) != null) {
                return false;
            }
        } else if (dir == Direction.LEFT) {
            if (this.getOneObjectAtOffset(-1, 0, Wall.class) != null
                    || this.getOneObjectAtOffset(-1, 0, Mouse.class) != null
                    || this.getOneObjectAtOffset(-1, 0, Hound.class) != null) {
                return false;
            }
        } else if (dir == Direction.RIGHT) {
            if (this.getOneObjectAtOffset(1, 0, Wall.class) != null
                    || this.getOneObjectAtOffset(1, 0, Mouse.class) != null
                    || this.getOneObjectAtOffset(1, 0, Hound.class) != null) {
                return false;
            }
        }

        //TODO verschachtelte Variante entschachteln
        return true;
    }

    /**
     * Checks if a mouse sees a cat (sightRange).
     *
     * @return True if so, false if not
     */
    private boolean mouseSeesCat() {
        //TODO Simpler Version?
        for (int i = 0; i <= this.sightRange; i++) {
            if (wantedDir == Direction.UP) {
                if (this.getOneObjectAtOffset(0, -i, Player.class) != null) {
                    return true;
                }
            } else if (wantedDir == Direction.DOWN) {
                if (this.getOneObjectAtOffset(0, +i, Player.class) != null) {
                    return true;
                }
            } else if (wantedDir == Direction.LEFT) {
                if (this.getOneObjectAtOffset(-i, 0, Player.class) != null) {
                    return true;
                }
            } else if (wantedDir == Direction.RIGHT) {
                if (this.getOneObjectAtOffset(i, 0, Player.class) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns a random direction that is not the oldDirection.
     *
     * @param oldDir The old Direction
     * @return A direction other than the old
     */
    private Direction randomDir(Direction oldDir) {
        Direction dir = Direction.NONE;

        do {
            Random random = new Random();
            int ranDir = random.nextInt(4);

            if (Direction.UP.ordinal() == ranDir) {
                dir = Direction.UP;
            } else if (Direction.DOWN.ordinal() == ranDir) {
                dir = Direction.DOWN;
            } else if (Direction.LEFT.ordinal() == ranDir) {
                dir = Direction.LEFT;
            } else if (Direction.RIGHT.ordinal() == ranDir) {
                dir = Direction.RIGHT;
            }
        } while (oldDir == dir);

        return dir;
    }

    /**
     * Returns the life increasement gained through a mouse.
     *
     * @return The life increasement
     */
    public int getLifeIncreasement() {
        return this.lifeIncrease;
    }

    /**
     * saves the current state of the mouse.
     */
    public Element save() {
        Element mouse = new Element("mouse");
        mouse.addContent(new Element("position_x").setText(String.valueOf(this.getX())));
        mouse.addContent(new Element("position_y").setText(String.valueOf(this.getY())));
        mouse.addContent(new Element("position_direction").setText(String.valueOf(this.wantedDir.ordinal())));

        return mouse;
    }
}
