import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * This class provides access to all variables that are contained by our Map.xml data
 * @author simonhoinkis
 * @version 1.0
 */
public final class XML_Map_Reader {
	private static final String XML_MAP_FILEPATH = "XML/Map.xml";
	//private static final String XML_SAVESTATE_FILEPATH = "XML/Savestate.xml";
	//private static final String XML_GAMELOGIC_FILEPATH = "XML/Gamelogic.xml";
	
	private XML_Map_Reader(){
		
	}
	
	/**
	 * Tests the XML Reader
	 */
	public static void test() {    
		System.out.println(XML_Map_Reader.getMiceCount());
		System.out.println(XML_Map_Reader.getMiceImage());
		System.out.println(XML_Map_Reader.getPlayerImage(PlayerID.THIRD));
		System.out.println(XML_Map_Reader.getPlayerSpeed());
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
	 * Get Map root
	 * @return The Map root
	 */
	private static Element getMapRoot() {
		Element mapRoot = null;
		try {
			
			//read the Map information from the XML file into a JDOM Document
			Document xmlMap = new SAXBuilder().build(XML_Map_Reader.XML_MAP_FILEPATH);
			
			mapRoot = xmlMap.getRootElement();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return mapRoot;
	}
	
	/**
	 * Get the world data
	 * @return The world data element ("worlddata")
	 */
	private static Element getWorlddata() {
		return XML_Map_Reader.getMapRoot().getChild("worlddata");
	}
	
	/**
	 * Get Player
	 * @return The player data
	 */
	private static Element getPlayer() {
		return XML_Map_Reader.getMapRoot().getChild("player");
	}
	
	/**
	 * Get Walls
	 * @return The Walls
	 */
	private static Element getWalls() {
		return XML_Map_Reader.getMapRoot().getChild("walls");
	}
	
	/**
	 * Get Mice 
	 * @return The mice
	 */
	private static Element getMice() {
		return XML_Map_Reader.getMapRoot().getChild("mice");
	}
	
	/**
	 * Get Trees
	 * @return the trees
	 */
	private static Element getTrees() {
		return XML_Map_Reader.getMapRoot().getChild("trees");
	}
	
	private static int xmlIntParser(String str) {
		int parseNumber = 0;
		
		try {
			parseNumber = Integer.parseInt(str);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return parseNumber;
	}

	/**
	 * Returns the width of the world
	 * @return The width of the world
	 */
	public static int getWorldWidth() {
		return XML_Map_Reader.xmlIntParser(XML_Map_Reader.getWorlddata().getChildText("width"));		
	}
	
	/**
	 * Returns the height of the world
	 * @return The height of the world
	 */
	public static int getWorldHeight() {
		return XML_Map_Reader.xmlIntParser(XML_Map_Reader.getWorlddata().getChildText("height"));
	}
	
	/**
	 * Returns the cell size of the world
	 * @return The cell size of the world
	 */
	public static int getWorldCellsize() {
		return XML_Map_Reader.xmlIntParser(XML_Map_Reader.getWorlddata().getChildText("cellsize"));
	}
	
	/**
	 * Returns the background image path
	 * @return The background image path
	 */
	public static String getWorldBackgroundImage() {
		return XML_Map_Reader.getWorlddata().getChildText("wiese_klein.jpg");
	}
	
	/**
	 * Returns the player speed
	 * @return The player speed
	 */
	public static int getPlayerSpeed() {
		return XML_Map_Reader.xmlIntParser((XML_Map_Reader.getPlayer().getChildText("speed")));
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
		
		
		
		playerPosition = new Position(XML_Map_Reader.xmlIntParser(player.getChildText("position_x")), 
										XML_Map_Reader.xmlIntParser(player.getChildText("position_y")));
		
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
		
		return player.getChildText("image");
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
	
	public static ArrayList<Position> getWallPositions() {
		List<Element> walls = getWalls().getChildren("wall");
		ArrayList<Position> wallPositions = new ArrayList<Position>();
		
		//add the positions to a list
		for(Element wall : walls) {
			wallPositions.add(new Position(XML_Map_Reader.xmlIntParser(wall.getChildText("position_x")),
										XML_Map_Reader.xmlIntParser(wall.getChildText("position_y"))));
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
		List<Element> mice = getWalls().getChildren("mouse");
		ArrayList<PositionWithDirection> mousePositions = new ArrayList<PositionWithDirection>();
		
		//add the positions to a list
		for(Element mouse : mice) {
			mousePositions.add(new PositionWithDirection(XML_Map_Reader.xmlIntParser(mouse.getChildText("position_x")),
											XML_Map_Reader.xmlIntParser(mouse.getChildText("position_y")),
											Direction.valueOf(mouse.getChildText("direction"))));
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
		List<Element> trees = getWalls().getChildren("tree");
		ArrayList<Position> treePositions = new ArrayList<Position>();
		
		//add the positions to a list
		for(Element tree : trees) {
			treePositions.add(new Position(XML_Map_Reader.xmlIntParser(tree.getChildText("position_x")),
										XML_Map_Reader.xmlIntParser(tree.getChildText("position_y"))));
		}
		
		return treePositions;
	}
}
