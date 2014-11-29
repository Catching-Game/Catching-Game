import org.jdom2.Element;
import java.util.List;
import java.util.ArrayList;


/**
 * XML_Gamelogic_Reader reads the xml gamelogic file to provide the usage of gamelogic variables
 * @author simonhoinkis
 * @version 1.1
 */
public final class XML_Gamelogic_Reader {
		private static final String FILEPATH = "XML/Gamelogic.xml";
		
		private XML_Gamelogic_Reader() {
		}
		
		/**
		 * Tests the XML Reader
		 * TODO Hier ist ebenfalls ein einfacher GUnit test moeglich
		 */
		public static void test() {    
			System.out.println(XML_Gamelogic_Reader.getGametime());
			System.out.println(XML_Gamelogic_Reader.getMouseSightRange());
			System.out.println(XML_Gamelogic_Reader.getMouseLifeIncrease());
			System.out.println(XML_Gamelogic_Reader.getMouseSpeed());
			System.out.println(XML_Gamelogic_Reader.getPlayerLifes());
			System.out.println(XML_Gamelogic_Reader.getPlayerSpeed());
			System.out.println(XML_Gamelogic_Reader.getHoundSpeed());
		}

		/**
		 * Returns the player child
		 * @return Player child
		 */
		private static Element getPlayer() {
			return XML_Helper.getRoot(XML_Gamelogic_Reader.FILEPATH).getChild("player");
		}
		
		/**
		 * Returns the hound child
		 * @return The hound child
		 */
		private static Element getHound() {
			return XML_Helper.getRoot(XML_Gamelogic_Reader.FILEPATH).getChild("hound");
		}
		
		/**
		 * Returns the Mouse child
		 * @return The mouse child
		 */
		private static Element getMouse() {
			return XML_Helper.getRoot(XML_Gamelogic_Reader.FILEPATH).getChild("mouse");
		}
		
		/**
		 * Returns the Timeframe of the game (called gametime)
		 * @return The Gametime
		 */
		public static int getGametime() {
			return XML_Helper.parseStrToInt(XML_Helper.getRoot(XML_Gamelogic_Reader.FILEPATH).getChildText("gametime"));
		}
		
		/**
		 * Returns the lifes of a player
		 * @return The lifes of a player
		 */
		public static int getPlayerLifes() {
//			List<Element> playerlife = XML_Gamelogic_Reader.getPlayer().getChildren("lifes");
//			ArrayList<Integer> playerlifes = new ArrayList<Integer>();
//			for(Element life : playerlife){
//				playerlifes.add(XML_Helper.parseStrToInt(life));
//			}
			return XML_Helper.parseStrToInt(XML_Helper.getRoot(XML_Gamelogic_Reader.FILEPATH).getChildText("life"));
		}
		
		/**
		 * Returns the player speed
		 * @return Speed of the player
		 */
		public static int getPlayerSpeed() {
			return XML_Helper.parseStrToInt(XML_Gamelogic_Reader.getPlayer().getChildText("speed"));
		}
		
		/**
		 * Returns the speed of the hound
		 * @return Speed of the hound
		 */
		public static int getHoundSpeed() {
			return XML_Helper.parseStrToInt(XML_Gamelogic_Reader.getHound().getChildText("speed"));
		}
		
		/**
		 * Returns the Speed of the mouse
		 * @return Speed of Mouse
		 */
		public static int getMouseSpeed() {
			return XML_Helper.parseStrToInt(XML_Gamelogic_Reader.getMouse().getChildText("speed"));
		}
		
		/**
		 * Returns the Sight Range of the mouse
		 * @return Mouse sight range
		 */
		public static int getMouseSightRange() {
			return XML_Helper.parseStrToInt(XML_Gamelogic_Reader.getMouse().getChildText("sight_range"));
		}
		
		/**
		 * Returns the life increase u gain by eating a mouse
		 * @return The life increase
		 */
		public static int getMouseLifeIncrease() {
			return XML_Helper.parseStrToInt(XML_Gamelogic_Reader.getMouse().getChildText("life_increase"));
		}	
}
