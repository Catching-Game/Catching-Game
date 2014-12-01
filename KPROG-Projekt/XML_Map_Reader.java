import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;

/**
 * This class provides access to all variables that are contained by our Map.xml data
 * @author simonhoinkis
 * @version 1.1
 */
public final class XML_Map_Reader {
    private static final String FILEPATH = "XML/Map.xml";

    private XML_Map_Reader() {
    }
    
    /**
     * Tests the XML_Map_Reader
     *TODO Hier laesst sich einfach ein GUnit Test fuer spaeter umsetzen 
     */
    public static void test() {    
        System.out.println(XML_Map_Reader.getMiceCount());
        System.out.println(XML_Map_Reader.getMiceImage());
        System.out.println(XML_Map_Reader.getPlayerImage(PlayerID.THIRD));
        System.out.println(XML_Map_Reader.getTreeCount());
        System.out.println(XML_Map_Reader.getWallCount());
        System.out.println(XML_Map_Reader.getWallImage());
        System.out.println(XML_Map_Reader.getWorldBackgroundImage());
        System.out.println(XML_Map_Reader.getWorldCellsize());
        System.out.println(XML_Map_Reader.getWorldHeight());
        System.out.println(XML_Map_Reader.getWorldWidth());
        System.out.println(XML_Map_Reader.getPlayerPosition(PlayerID.FIRST));
    }
    
    /**
     * Get the world data
     * @return The world data element ("worlddata")
     */
    private static Element getWorlddata() {
        return XML_Helper.getRoot(XML_Map_Reader.FILEPATH).getChild("worlddata");
    }
    
    /**
     * Get Player
     * @return The player data
     */
    private static Element getPlayer() {
        return XML_Helper.getRoot(XML_Map_Reader.FILEPATH).getChild("player");
    }
    
    /**
     * Get Walls
     * @return The Walls
     */
    private static Element getWalls() {
        return XML_Helper.getRoot(XML_Map_Reader.FILEPATH).getChild("walls");
    }
    
    /**
     * Get Mice 
     * @return The mice
     */
    private static Element getMice() {
        return XML_Helper.getRoot(XML_Map_Reader.FILEPATH).getChild("mice");
    }
    
    /**
     * Get Trees
     * @return the trees
     */
    private static Element getTrees() {
        return XML_Helper.getRoot(XML_Map_Reader.FILEPATH).getChild("trees");
    }
    
    /**
     * 
     */
    private static Element getHounds(){
        return XML_Helper.getRoot(XML_Map_Reader.FILEPATH).getChild("hounds");
    }
    
    /**
     * Get Counter Image
     */
    private static Element getCounters(){
    	return XML_Helper.getRoot(XML_Map_Reader.FILEPATH).getChild("counters");
    }

    /**
     * Returns the width of the world
     * @return The width of the world
     */
    public static int getWorldWidth() {
        return XML_Helper.parseStrToInt(XML_Map_Reader.getWorlddata().getChildText("width"));       
    }
    
    /**
     * Returns the height of the world
     * @return The height of the world
     */
    public static int getWorldHeight() {
        return XML_Helper.parseStrToInt(XML_Map_Reader.getWorlddata().getChildText("height"));
    }
    
    /**
     * Returns the cell size of the world
     * @return The cell size of the world
     */
    public static int getWorldCellsize() {
        return XML_Helper.parseStrToInt(XML_Map_Reader.getWorlddata().getChildText("cellsize"));
    }
    
    /**
     * Returns the background image path
     * @return The background image path
     */
    public static String getWorldBackgroundImage() {
        return XML_Map_Reader.getWorlddata().getChildText("image");
    }
    
    /**
     * Returns the player position of a certain player
     * @param playerID The player which position should be returned
     * @return The Position of the player
     */
    public static Position getPlayerPosition(PlayerID playerID) {
        Position playerPosition;
        
        //get the current player
        Element player = XML_Map_Reader.getPlayer().getChild("player" + playerID.getValue());
        
        
        
        playerPosition = new Position(XML_Helper.parseStrToInt(player.getChildText("position_x")), 
                                    XML_Helper.parseStrToInt(player.getChildText("position_y")));
        
        return playerPosition;
    }
    
    /**
     * Returns player image path
     * @param playerID the player which image should be returned
     * @return the player image path
     */
    public static String getPlayerImage(PlayerID playerID) {
        //get the current player
        Element player = XML_Map_Reader.getPlayer().getChild("player" + playerID.getValue());
        
        return player.getChildText("image_stands");
    }
    /**
     * Returns player image path for going left.
     * @param playerID the player which image should be returned.
     * @return the player image
     */
    public static String getPlayerImageLeft(PlayerID playerID)
    {
        //get current player
        Element player = XML_Map_Reader.getPlayer().getChild("player" + playerID.getValue());
        
        return player.getChildText("image_left");
    }
    
     /**
     * Returns player image path for going right.
     * @param playerID the player which image should be returned.
     * @return the player image
     */
    public static String getPlayerImageRight(PlayerID playerID)
    {
        //get current player
        Element player = XML_Map_Reader.getPlayer().getChild("player" + playerID.getValue());
        
        return player.getChildText("image_right");
    }
    
    public static String getPlayerName(PlayerID playerID){
    	//get current player name
    	Element player = XML_Map_Reader.getPlayer().getChild("player" + playerID.getValue());
    	
    	return player.getChildText("player_name");
    	
    }
    
    /**
     * Returns the wall image path
     * @return The wall image path
     */
    public static String getWallImage() {
        return getWalls().getChildText("image");
    }
    
    /**
     * Returns the wall count
     * @return The wall count
     */
    public static int getWallCount() {
        return getWalls().getChildren("wall").size();
    }
    
    /**
     * Returns an Array containing the Positions of the Wall
     * @return The Wall Positions
     */
    public static ArrayList<Position> getWallPositions() {
        List<Element> walls = getWalls().getChildren("wall");
        ArrayList<Position> wallPositions = new ArrayList<Position>();
        
        //add the positions to a list
        for(Element wall : walls) {
            wallPositions.add(new Position(XML_Helper.parseStrToInt(wall.getChildText("position_x")),
                                        XML_Helper.parseStrToInt(wall.getChildText("position_y"))));
        }
        
        return wallPositions;
    }
    
    /**
     * Returns the mice image paths
     * @return The image paths
     */
    public static String getMiceImage() {
        return XML_Map_Reader.getMice().getChildText("image");
    }
    
    /**
     * Returns the mice count
     * @return The mice count
     */
    public static int getMiceCount() {
        return XML_Map_Reader.getMice().getChildren("mouse").size();
    }
    
    /**
     * Returns the Mice Positions
     * @return The Mice positions
     */
    public static ArrayList<PositionWithDirection> getMicePositions() {
        List<Element> mice = getMice().getChildren("mouse");
        ArrayList<PositionWithDirection> mousePositions = new ArrayList<PositionWithDirection>();
        
        //add the positions to a list
        for(Element mouse : mice) {
            mousePositions.add(new PositionWithDirection(XML_Helper.parseStrToInt(mouse.getChildText("position_x")),
                                                        XML_Helper.parseStrToInt(mouse.getChildText("position_y")),
                                            Direction.valueOf(mouse.getChildText("position_direction"))));
        }
        
        return mousePositions;
    }
    
    /**
     * Returns the Tree image path
     * @return The tree image path
     */
    public static String getTreeImage() {
        //return this.getTrees();
        return XML_Map_Reader.getTrees().getChildText("image");
    }
    
    /**
     * Returns the tree count
     * @return The tree count
     */
    public static int getTreeCount() {
        return XML_Map_Reader.getTrees().getChildren("tree").size();
    }
    
    /**
     * Returns the tree positions
     * @return The tree positions
     */
    public static ArrayList<Position> getTreePositions() {
        List<Element> trees = getTrees().getChildren("tree");
        ArrayList<Position> treePositions = new ArrayList<Position>();
        
        //add the positions to a list
        for(Element tree : trees) {
            treePositions.add(new Position(XML_Helper.parseStrToInt(tree.getChildText("position_x")),
                                            XML_Helper.parseStrToInt(tree.getChildText("position_y"))));
        }
        
        return treePositions;
    }
    /**
     * Returns the Hound Image Path
     * @return a String with the Hound Image Path
     */
    public static String getHoundImage(){
        return XML_Map_Reader.getHounds().getChildText("image");
    }
    
    /**
     * Returns the quantity of the Hound objects
     * @return a int with the qantity of Hount objects
     */
    public static int getHoundCount(){
        return XML_Map_Reader.getHounds().getChildren("hound").size();
    }
    
    /**
     * Returns a PositionArrayList with Position x and Position y
     * @return ArrayList<Position> with Position x and Position y
     */
    public static ArrayList<Position> getHoundPositions(){
        List<Element> hounds = getHounds().getChildren("hound");
        ArrayList<Position> houndPositions = new ArrayList<Position>();
        
        //add the positions to a list
        for(Element hound : hounds){
            houndPositions.add(new Position(XML_Helper.parseStrToInt(hound.getChildText("position_x")),
                                             XML_Helper.parseStrToInt(hound.getChildText("position_y"))
                                             ));
        }
        return houndPositions;
    }
    
    /**
     * @return counter image
     */
    public static String getCounterImage(){
    	return XML_Map_Reader.getCounter().getChildText("image");
    }
    
    /**
     * Returns a PositionArrayList with Position x and Position y
     * @return ArrayList<Position> with Position x and Position y
     */
    public static ArrayList<Position> getCounterPosition(){
    	List<Element> counters = getCounter().getChildren("counter");
    	ArrayList<Position> counterPosition = new ArrayList<Position>();
    	
    	for(Element counter : counters){
    		counterPosition.add(new Position(XML_Helper.parseStrToInt(counter.getChildText("position_x")),
    				                         XML_Helper.parseStrToInt(counter.getChildText("position_y"))
    				                         ));
    	}
    	
    	return counterPosition;
    }
}