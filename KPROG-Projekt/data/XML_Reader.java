import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class XML_Reader {
	private static final String XML_MAP_FILEPATH = "XML/Map.xml";
	//private static final String XML_SAVESTATE_FILEPATH = "XML/Savestate.xml";
	//private static final String XML_GAMELOGIC_FILEPATH = "XML/Gamelogic.xml";
	private static Document xmlMap;
	//private static String xmlSavestate;
	//private static String xmlGamelogic;
	
	public static void main(String[] args) {    
    
	}
	
	private Element getMapRoot() {
		Element mapRoot = null;
		try {
			//read the Map information from the XML file into a JDOM Document
			XML_Reader.xmlMap = new SAXBuilder().build(XML_Reader.XML_MAP_FILEPATH);
			
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
	
	private Element getWorlddata() {
		return this.getMapRoot().getChild("worlddata");
	}
	
	private Element getPlayer() {
		return this.getMapRoot().getChild("player");
	}
	
	private Element getWalls() {
		return this.getMapRoot().getChild("walls");
	}
	
	private Element getMice() {
		return this.getMapRoot().getChild("mice");
	}
	
	private Element getTrees() {
		return this.getMapRoot().getChild("trees");
	}

	public int getWorldWith() {
		return Integer.parseInt(this.getWorlddata().getChildText("width"));		
	}
	
	public int getWorldHeight() {
		return Integer.parseInt(this.getWorlddata().getChildText("height"));
	}
	
	public int getWorldCellsize() {
		return Integer.parseInt(this.getWorlddata().getChildText("cellsize"));
	}
	
	public String getWorldBackgroundImage() {
		return this.getWorlddata().getChildText("background");
	}
	
	public int getPlayerSpeed() {
		return Integer.parseInt(this.getPlayer().getChildText("speed"));
	}
	
	public Position getPlayerPosition(PlayerID playerID) {
		Position playerPosition;
		
		//get the current player
		Element player = this.getPlayer().getChild("player" + playerID);
		
		
		
		playerPosition = new Position(Integer.parseInt(player.getChildText("position_x")), 
										Integer.parseInt(player.getChildText("position_y")));
		
		return playerPosition;
	}
	
	public String getPlayerImage(PlayerID playerID) {
		//get the current player
		Element player = this.getPlayer().getChild("player" + playerID);
		
		return player.getChildText("image");
	}
	
	public String getWallImage() {
		return getWalls().getChildText("image");
	}
	
	public int getWallCount() {
		return getWalls().getChildren("wall").size();
	}
	
	public ArrayList<Position> getWallPositions() {
		List<Element> walls = getWalls().getChildren("wall");
		ArrayList<Position> wallPositions = new ArrayList<Position>();
		
		//add the positions to a list
		for(Element wall : walls) {
			wallPositions.add(new Position(Integer.parseInt(wall.getChildText("position_x")),
											Integer.parseInt(wall.getChildText("position_y"))));
		}
		
		return wallPositions;
	}
	
	public String getMiceImage() {
		return this.getMice().getChildText("image");
	}
	
	public int getMiceCount() {
		return this.getMice().getChildren("mouse").size();
	}
	
	public ArrayList<PositionWithDirection> getMicePositions() {
		List<Element> mice = getWalls().getChildren("mouse");
		ArrayList<PositionWithDirection> mousePositions = new ArrayList<PositionWithDirection>();
		
		//add the positions to a list
		for(Element mouse : mice) {
			mousePositions.add(new PositionWithDirection(Integer.parseInt(mouse.getChildText("position_x")),
											Integer.parseInt(mouse.getChildText("position_y")),
											Direction.valueOf(mouse.getChildText("direction"))));
		}
		
		return mousePositions;
	}
	
	public String getTreeImage() {
		//return this.getTrees();
		return this.getTrees().getChildText("image");
	}
	
	public int getTreeCount() {
		return this.getTrees().getChildren("Tree").size();
	}
	
	public ArrayList<Position> getTreePositions() {
		List<Element> trees = getWalls().getChildren("tree");
		ArrayList<Position> treePositions = new ArrayList<Position>();
		
		//add the positions to a list
		for(Element tree : trees) {
			treePositions.add(new Position(Integer.parseInt(tree.getChildText("position_x")),
											Integer.parseInt(tree.getChildText("position_y"))));
		}
		
		return treePositions;
	}
}
