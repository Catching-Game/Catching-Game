import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.jdom2.Element;

/**
 * this class represents our Player in the game
 *
 * @author simonhoinkis
 * @version 0.2
 */
public class Player extends MovableActor {
 
    private int lifes;
    private int speed;
    private Direction wantedDir; //the direction the player wants to walk
    private Zaehleranzeige zaehler;
    private String playerName;
   
    private PlayerID playerID;

    public Player(int cellSize, String name, GameWorld gw, PlayerID playerID) {
        super(cellSize, XMLMapReader.getPlayerImage(playerID));
        this.playerID = playerID;
        init(name, gw, playerID);
    }

    /**
     * init all variables of the actor
     */
    private void init(String name, GameWorld gw, PlayerID playerID) {
        this.lifes = XML_Gamelogic_Reader.getPlayerLifes();
        this.speed = XML_Gamelogic_Reader.getPlayerSpeed();
        this.zaehler = new Zaehleranzeige(name, this.lifes, gw, playerID);
        this.playerName = name;
        
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        this.input();
        this.move();
        this.eat();
        // Add your action code here.
    }

    /**
     * Get the current wanted direction and saves it in wantedDir
     */
    private void input() {
        if (Greenfoot.isKeyDown("up")) {
            this.wantedDir = Direction.UP;
        } else if (Greenfoot.isKeyDown("down")) {
            this.wantedDir = Direction.DOWN;
        } else if (Greenfoot.isKeyDown("left")) {
            this.wantedDir = Direction.LEFT;
        } else if (Greenfoot.isKeyDown("right")) {
            this.wantedDir = Direction.RIGHT;
        } else if(Greenfoot.isKeyDown("escape")) {
        	Greenfoot.stop();
        	XMLSavestateWriter.save((GameWorld) this.getWorld());
        } else{
            this.wantedDir = Direction.NONE;
        }
    }

    /**
     * The Player Movement
     */
    private void move() {
        for (int i = 0; i < this.speed; i++) {
            if (this.canWalk(this.wantedDir)) {
                this.walk(wantedDir);
            }
        }
    }

    /**
     * Checks if a player can walk into a certain direction
     *
     * @param dir The direction
     * @return True if we can walk into this direction, false if not
     */
    private boolean canWalk(Direction dir) {
        //some collision stuff
        //TODO simplify
        if (dir == Direction.UP) {
            if (this.getOneObjectAtOffset(0, -1, Wall.class) != null) {
                return false;
            }
        } else if (dir == Direction.DOWN) {
            if (this.getOneObjectAtOffset(0, +1, Wall.class) != null) {
                return false;
            }
        } else if (dir == Direction.LEFT) {
            if (this.getOneObjectAtOffset(-1, 0, Wall.class) != null) {
                return false;
            }
        } else if (dir == Direction.RIGHT) {
            if (this.getOneObjectAtOffset(1, 0, Wall.class) != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a player touches a mouse, eats it and increases life if so
     */
    private void eat() {
        if (this.isTouching(Mouse.class)) {
            Mouse mouse = (Mouse) this.getOneIntersectingObject(Mouse.class);
            this.lifes += mouse.getLifeIncreasement();
            this.removeTouching(Mouse.class);
            zaehler.changeAnzeige(this.lifes);
        }   	
    }
    
    /**
     * saves the current state of the player
     */
    public Element save() {
    	Element player = new Element("player" + this.playerID.ordinal());
    	player.addContent(new Element("position_x").setText(String.valueOf(this.getX())));
    	player.addContent(new Element("position_y").setText(String.valueOf(this.getY())));
    	player.addContent(new Element("position_direction").setText(String.valueOf(this.wantedDir.ordinal())));
    	
    	player.addContent(new Element("lifes").setText(String.valueOf(this.lifes)));
    	
    	return player;
    }
}
    
    

