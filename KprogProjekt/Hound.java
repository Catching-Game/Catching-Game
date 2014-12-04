import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


import org.jdom2.Element;

/**
 * This class represents our hound, he is using a broadsearch to find the player, also
 * he is using the "single tone pattern"
 * @author simonhoinkis
 * @version 1.0
 */
public class Hound extends MovableActor
{
	/**
	 * The single ton hound.
	 */
	private static Hound hound;
	
	//Some standard vars
    private int mapHeight;
    private int mapWidth;
    private int speed;
    
    //vars used for the broadsearch algorithm
    private Map<Integer, ArrayList<Position>> searchField;
    //Position of the target player
    private Position playerPosition;
    
    //The current array
    private boolean[][] visited; 
    private int[][] pathlength;
    
    //The initial 
    private boolean[][] initVisited; 
    private int[][] initPathlength;
    
    //Positions of every player
    private Position[] playerPositions;
    
    /**
     * Set Up the Hound Image, Movement,etc.
     * @param cellSize the cellsize of the world
     */
    private Hound(int cellSize) {
        super(cellSize, XMLMapReader.getHoundImage());
        init(cellSize);
        
    }
    
    /**
     * Gives back the current hound of the class (singletone).
     * @param cellSize the cellsize of the world
     * @return The hound of the class
     */
    public static Hound getInstance(int cellSize) {
       //Is there no hound?
    	if(Hound.hound == null) {
    		//create a hound
            Hound.hound = new Hound(cellSize);
            return Hound.hound;
        } else {
        	//return the single tone hound
            return Hound.hound;
        }
    }
    
    /**
     * Act - do whatever the Hound wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.move();
    }    
    
    /**
     * Initialise every var for the hound.
     * @param cellSize cell size of the world
     */
    private void init(int cellSize) {
        this.searchField = new HashMap<Integer, ArrayList<Position>>();
        this.speed = XMLGamelogicReader.getHoundSpeed();
        this.mapWidth = XMLMapReader.getWorldWidth();
        this.mapHeight = XMLMapReader.getWorldHeight();
        
        //Set up the arrays
        visited = new boolean[this.mapWidth][this.mapHeight];
        pathlength = new int[this.mapWidth][this.mapHeight];
        initVisited = new boolean[this.mapWidth][this.mapHeight];
        initPathlength = new int[this.mapWidth][this.mapHeight];
        
        //set up the init arrays
        initFields();
    }
    
    /**
     * initialise the init variables, using the XML file for walls&trees (non moving).
     */
    private void initFields() {
    	//Set visited of every field to false and pathlength to 0
        for (int i1 = 0; i1 < this.mapWidth; i1++) {
            for (int i2 = 0; i2 < this.mapHeight; i2++) {
                this.initVisited[i1][i2] = false;
                this.initPathlength[i1][i2] = 0;
            }
        }
        
        //initialise the walls
        for (int i = 0; i < XMLMapReader.getWallCount(); i++) {
            int posY = XMLMapReader.getWallPositions().get(i).getY();
            int posX = XMLMapReader.getWallPositions().get(i).getX();
            initVisited[posX][posY] = true;
        }
        
        //initialise the trees
        for (int i = 0; i < XMLMapReader.getTreeCount(); i++){
            int posY = XMLMapReader.getTreePositions().get(i).getY();
            int posX = XMLMapReader.getTreePositions().get(i).getX();
            initVisited[posX][posY] = true;
        }
    }
    
    /**
     * resets the variables used for the search algorithm.
     */
    private void resetFields() {      
    	//initialise the searchfield var
        searchField = new HashMap<Integer, ArrayList<Position>>(); 
        
        //initialise the player positions (players are movable, so needs to be updated)
        this.setPlayerPositions();
        
        //sets the start Position of the hound
        this.setHoundPosition();
        
        for (int i1 = 0; i1 < this.mapWidth; i1++) {
            for (int i2 = 0; i2 < this.mapHeight; i2++) {
                this.visited[i1][i2] = initVisited[i1][i2];
                this.pathlength[i1][i2] = initPathlength[i1][i2];
            }
        }
    }
    
    /**
     * Sets the start position of the hound in our searchField, also says the field.
     * our hound is standing on is already visited.
     */
    private void setHoundPosition() {
        ArrayList<Position> positionHound = new ArrayList<Position>();
        positionHound.add(new Position(this.getX(), this.getY()));
        visited[this.getX()][this.getY()] = true;
        this.searchField.put(0, positionHound);
    }
    
    /**
     * Gives back a new Position to walk to for our hound.
     * @return the new position our hound has to walk to
     */
    private Position getNewPosition() {
    	//resets every var for the algorithm
        this.resetFields();
        
        //no player was found yet
        boolean playerFound = false;
        
        //start searching with a depth of zero
        int depth = 0;
        
        //go through our Positions until a player was found
        while(!playerFound) {
        	//is there any arraylist?
        	if(searchField.get(depth) != null) {
            	//The array List for a certain depth
                ArrayList<Position> currentPositions = searchField.get(depth);
                
                for(int index = 0; index < currentPositions.size(); index++) {
                        Position p = (Position) currentPositions.get(index);

                        playerFound = searchPlayer(p);
                        
                        //jump out of the for
                        if (playerFound) {
                        	//conditions for index set so for is no longer executed
                            index = currentPositions.size();
                        }
                }
            } else {
            	//there is no player found but this part is used to jump out of the while
            	//when there is no further array to search for the player Position
            	playerFound = true;
            }
            depth++;
        }
        depth--;
        
        //was there any position set (playerFound can be set true even without any player)
        if(this.playerPosition != null) {
        	return searchHound(depth, playerPosition.getX(), playerPosition.getY());
        }
        
        return null;

    }

    /**
     * search for the hound (backtraacing part).
     * @param i the pathlength
     * @param posX Position X of the player
     * @param posY Position Y of the player
     * @return the position to walk to
     */
    private Position searchHound(int i, int posX, int posY) {
        //System.out.println(i);
        if(i == 1) {
            return new Position (posX, posY);
        }
        
        if(pathlength[posX][posY+1] == (i - 1)) {
            return searchHound(--i, posX, posY + 1);
        }
        if(pathlength[posX][posY-1] == (i - 1)) {
            return searchHound(--i, posX, posY - 1);
        }
        if(pathlength[posX+1][posY] == (i - 1)) {
            return searchHound(--i, posX + 1, posY);
        }
        if(pathlength[posX-1][posY] == (i - 1)) {
            return searchHound(--i, posX - 1, posY);
        }
        
        return null;
    }
    
    /**
     * Search for the player in the current system,
     * @param p the position of the hound
     * @return gives back true if the player is found, and false if not
     */
    private boolean searchPlayer(Position p) {
        int posX = p.getX();
        int posY = p.getY();
        int depth = pathlength[posX][posY]+1;
        
        if (searchField.get(depth) == null) {
            searchField.put(depth, new ArrayList());
        }
        
        if(visited[posX][posY+1] == false) {
            visited[posX][posY+1] = true;
            pathlength[posX][posY+1] = depth;
            ((ArrayList) searchField.get(depth)).add(new Position(posX, posY+1));
        }
        if(visited[posX][posY-1] == false) {
            visited[posX][posY-1] = true;
            pathlength[posX][posY-1] = depth;
            ((ArrayList) searchField.get(depth)).add(new Position(posX, posY-1));
        }
        if(visited[posX+1][posY] == false) {
            visited[posX+1][posY] = true;
            pathlength[posX+1][posY] = depth;
            ((ArrayList) searchField.get(depth)).add(new Position(posX+1, posY));
        }
        if(visited[posX-1][posY] == false) {
            visited[posX-1][posY] = true;
            pathlength[posX-1][posY] = depth;
            ((ArrayList) searchField.get(depth)).add(new Position(posX-1, posY));
        }

        for(int i = 0; i < playerPositions.length; i++) {
            if (posX == playerPositions[i].getX() && posY == playerPositions[i].getY()) {
                playerPosition = new Position(posX, posY);    
                return true;
            }
        }
  
        return false;
    }
    
    /**
     * Sets the player Positions.
     */
    private void setPlayerPositions() {
        List<Object> playerList = this.getWorld().getObjects(Player.class);
        playerPositions = new Position[playerList.size()];
        for (int i = 0; i < playerList.size(); i++) {
            playerPositions[i] = new Position(((Player) playerList.get(i)).getX(),
                                                ((Player) playerList.get(i)).getY());
        }
    }
    
    /**
     * Moves the Dog to the new Position by the algorithm.
     */
    private void move() {
        Position p = this.getNewPosition();
        if(p != null) {
            this.setLocation(p.getX(), p.getY());
        }  
    }
    
    /**
     * saves the current state of the hound.
     * @return gets the Hound Element
     */
    public Element save() {
        Element hound = new Element("hound");
        hound.addContent(new Element("position_x").setText(String.valueOf(this.getX())));
        hound.addContent(new Element("position_y").setText(String.valueOf(this.getY())));
        
        return hound;
    }
}
