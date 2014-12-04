import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.jdom2.Element;

/**
 * this class represents our Player in the game.
 *
 * @author simonhoinkis
 * @version 1.0
 */
public class Player extends MovableActor {
	//our state pattern used by the project
	private TurnContext turnContext;
	
	//basic stats
    private int lifes;
    private int speed;
    
    //key vars for movement
    private String keyUp;
    private String keyDown;
    private String keyRight;
    private String keyLeft;
    
    //the direction the player wants to walk
    private Direction wantedDir;
    
    //Vars used by the counter
    private Counter counter;
    private String playerName;
   
    //who is this player in the game context
    private PlayerID playerID;

    /**
     * Constructor of a player object in the game
     * @param cellSize cellsize of the world
     * @param name name of the player
     * @param gw game world
     * @param playerID the player id
     * @param keyUp the up key
     * @param keyDown the down key
     * @param keyLeft the left key
     * @param keyRight the right key
     * @param lifes the lifes
     */
    public Player(int cellSize, String name, GameWorld gw, PlayerID playerID, String keyUp, 
    									String keyDown, String keyLeft, String keyRight, int lifes) {
        super(cellSize, XMLMapReader.getPlayerImage(playerID));
        this.playerID = playerID;
        initKeyVars(keyUp, keyDown, keyLeft, keyRight);
        initGameVars(name, gw, playerID, lifes);
    }

    /**
     * init all game variables of the actor
     */
    private void initGameVars(String name, GameWorld gw, PlayerID playerID, int lifes) {
        this.lifes = lifes;
        this.speed = XMLGamelogicReader.getPlayerSpeed();
        this.counter = new Counter(name, this.lifes, gw, playerID);
        this.playerName = name;
        this.turnContext = new TurnContext();
    }
    
   /**
    * initialise the movement of the player
    * @param keyUp the key used moving the player upwards
    * @param keyDown the key used moving the player downwards
    * @param keyLeft the key used moving the player left
    * @param keyRight the key used moving the player right
    */
   private void initKeyVars(String keyUp, String keyDown, String keyLeft, String keyRight) {
	   this.keyUp = keyUp;
	   this.keyDown = keyDown;
	   this.keyRight = keyRight;
	   this.keyLeft = keyLeft;
   }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        this.input();
        this.move();
        this.eat();
        this.getsEaten();
    }

    /**
     * Get the current wanted direction and saves it in wantedDir.
     */
    private void input() {
        if (Greenfoot.isKeyDown(keyUp)) {
            this.wantedDir = Direction.UP;
        } else if (Greenfoot.isKeyDown(keyDown)) {
            this.wantedDir = Direction.DOWN;
        } else if (Greenfoot.isKeyDown(keyLeft)) {
            this.wantedDir = Direction.LEFT;
        } else if (Greenfoot.isKeyDown(keyRight)) {
            this.wantedDir = Direction.RIGHT;
        } else {
            this.wantedDir = Direction.NONE;
        }
    }

    /**
     * The Player Movement.
     */
    private void move() {
        for (int i = 0; i < this.speed; i++) {
            if (this.canWalk(this.wantedDir)) {
                this.walk(this.wantedDir);
                this.turnContext.step(this.wantedDir);
            }
        }
    }

    /**
     * Checks if a player can walk into a certain direction.
     *
     * @param dir The direction
     * @return True if we can walk into this direction, false if not
     */
    private boolean canWalk(Direction dir) {
        //some collision stuff
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
     * Checks if a player touches a mouse, eats it and increases life if so.
     */
    private void eat() {
        if (this.isTouching(Mouse.class)) {
        	//get the (or at least say a) mouse that is touching the player
            Mouse mouse = (Mouse) this.getOneIntersectingObject(Mouse.class);
            
            //increase life of the player
            this.lifes += mouse.getLifeIncreasement();
            
            //remove the mouse that is touched
            this.removeTouching(Mouse.class);
            
            //change the counter of our lifes
            this.counter.changeAnzeige(this.lifes);
        }   	
    }
    
    /**
     * Checks if a player touches a dog, and if so he geats eaten and loses life.
     */
    private void getsEaten() {
        if (this.isTouching(Hound.class)) {
        	//Set back the hound of the game to prevent "spawn-killing"
        	((Hound) this.getOneIntersectingObject(Hound.class)).setLocation(XMLMapReader.getHoundPositions().get(0).getX(),
        																	XMLMapReader.getHoundPositions().get(0).getY());
        	this.lifes -= XMLGamelogicReader.getHoundLifeDecrease(); 
        	
        	//changes the counter of our lifes
        	this.counter.changeAnzeige(this.lifes);
        	
        	//player is still "alive"
        	if(this.lifes > 0) { 
        		//set his location to his spawning position
        		this.setLocation(XMLMapReader.getPlayerPosition(this.playerID).getX(), 
        						XMLMapReader.getPlayerPosition(this.playerID).getY());
        	} else {
        		//removes the player from the world
        		this.getWorld().removeObject((Actor) this);
        	}
        }
    }
    
    /**
     * Get the lifes of our players.
     * @return the lifes of our players
     */
    public int getLifes() {
    	return this.lifes;
    }
    
    /**
     * Returns the player name.
     * @return the player name
     */
    public String getPlayerName() {
    	return this.playerName;
    }
    
    /**
     * saves the current state of the player.
     */
    public Element save() {
    	Element player = new Element("player" + this.playerID.getValue());
    	player.addContent(new Element("position_x").setText(String.valueOf(this.getX())));
    	player.addContent(new Element("position_y").setText(String.valueOf(this.getY())));
    	player.addContent(new Element("position_direction").setText(String.valueOf(this.wantedDir.ordinal())));
    	
    	player.addContent(new Element("lifes").setText(String.valueOf(this.lifes)));
    	
    	return player;
    }
}
    
    


