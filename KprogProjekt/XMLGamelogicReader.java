import org.jdom2.Element;
import java.util.List;
import java.util.ArrayList;


/**
 * XML_Gamelogic_Reader reads the xml gamelogic file to provide the usage of gamelogic variables.
 * @author simonhoinkis
 * @version 1.1
 */
public final class XMLGamelogicReader {
		private static final String FILEPATH = "XML/Gamelogic.xml";
		
		/**
		 * private constructor, cant be created
		 */
		private XMLGamelogicReader() {
		}

		/**
		 * Returns the player child.
		 * @return Player child
		 */
		private static Element getPlayer() {
			return XMLHelper.getRoot(XMLGamelogicReader.FILEPATH).getChild("player");
		}
		
		/**
		 * Returns the hound child.
		 * @return The hound child
		 */
		private static Element getHound() {
			return XMLHelper.getRoot(XMLGamelogicReader.FILEPATH).getChild("hound");
		}
		
		/**
		 * Returns the Mouse child.
		 * @return The mouse child
		 */
		private static Element getMouse() {
			return XMLHelper.getRoot(XMLGamelogicReader.FILEPATH).getChild("mouse");
		}
		
		/**
		 * Returns the lifes of a player.
		 * @return The lifes of a player
		 */
		public static int getPlayerLifes() {
			return XMLHelper.parseStrToInt(XMLGamelogicReader.getPlayer().getChildText("lifes"));
		}
		
		/**
		 * Returns the player speed.
		 * @return Speed of the player
		 */
		public static int getPlayerSpeed() {
			return XMLHelper.parseStrToInt(XMLGamelogicReader.getPlayer().getChildText("speed"));
		}
		
		/**
		 * Returns the speed of the hound.
		 * @return Speed of the hound
		 */
		public static int getHoundSpeed() {
			return XMLHelper.parseStrToInt(XMLGamelogicReader.getHound().getChildText("speed"));
		}
		
		/**
		 * Returns the Speed of the mouse.
		 * @return Speed of Mouse
		 */
		public static int getMouseSpeed() {
			return XMLHelper.parseStrToInt(XMLGamelogicReader.getMouse().getChildText("speed"));
		}
		
		/**
		 * Returns the Sight Range of the mouse.
		 * @return Mouse sight range
		 */
		public static int getMouseSightRange() {
			return XMLHelper.parseStrToInt(XMLGamelogicReader.getMouse().getChildText("sight_range"));
		}
		
		/**
		 * Returns the life increase u gain by eating a mouse.
		 * @return The life increase
		 */
		public static int getMouseLifeIncrease() {
			return XMLHelper.parseStrToInt(XMLGamelogicReader.getMouse().getChildText("life_increase"));
		}	
		
		/**
		 * Returns the life decrease u get when a hound touches you.
		 * @return The life decrease
		 */
		public static int getHoundLifeDecrease() {
			return XMLHelper.parseStrToInt(XMLGamelogicReader.getHound().getChildText("life_decrease"));
		}
}
