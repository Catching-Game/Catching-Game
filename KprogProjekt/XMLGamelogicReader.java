
import org.jdom2.Element;
import java.util.List;
import java.util.ArrayList;

/**
 * XMLGamelogicReader reads the xml gamelogic file to provide the usage of
 * gamelogic variables.
 *
 * @author simonhoinkis
 * @version 1.1
 */
public final class XMLGamelogicReader {

    private static final String FILEPATH = "XML/Gamelogic.xml";
    /**
     * constructor for XMLGamelogicReader.
     */
    private XMLGamelogicReader() {
    }
    /**
     * Tests the XML Reader TODO Hier ist ebenfalls ein einfacher GUnit test.
     * moeglich
     */
    public static void test() {
        System.out.println(XMLGamelogicReader.getGametime());
        System.out.println(XMLGamelogicReader.getMouseSightRange());
        System.out.println(XMLGamelogicReader.getMouseLifeIncrease());
        System.out.println(XMLGamelogicReader.getMouseSpeed());
        System.out.println(XMLGamelogicReader.getPlayerLifes());
        System.out.println(XMLGamelogicReader.getPlayerSpeed());
        System.out.println(XMLGamelogicReader.getHoundSpeed());
    }

    /**
     * Returns the player child.
     *
     * @return Player child
     */
    private static Element getPlayer() {
        return XMLHelper.getRoot(XMLGamelogicReader.FILEPATH).getChild("player");
    }

    /**
     * Returns the hound child.
     *
     * @return The hound child
     */
    private static Element getHound() {
        return XMLHelper.getRoot(XMLGamelogicReader.FILEPATH).getChild("hound");
    }

    /**
     * Returns the Mouse child.
     *
     * @return The mouse child
     */
    private static Element getMouse() {
        return XMLHelper.getRoot(XMLGamelogicReader.FILEPATH).getChild("mouse");
    }

    /**
     * Returns the Timeframe of the game (called gametime).
     *
     * @return The Gametime
     */
    public static int getGametime() {
        return XMLHelper.parseStrToInt(XMLHelper.getRoot(XMLGamelogicReader.FILEPATH).getChildText("gametime"));
    }

    /**
     * Returns the lifes of a player.
     *
     * @return The lifes of a player
     */
    public static int getPlayerLifes() {
//			List<Element> playerlife = XMLGamelogicReader.getPlayer().getChildren("lifes");
//			ArrayList<Integer> playerlifes = new ArrayList<Integer>();
//			for(Element life : playerlife){
//				playerlifes.add(XMLHelper.parseStrToInt(life));
        //}
        return XMLHelper.parseStrToInt(XMLGamelogicReader.getPlayer().getChildText("lifes"));
    }

    /**
     * Returns the player speed.
     *
     * @return Speed of the player
     */
    public static int getPlayerSpeed() {
        return XMLHelper.parseStrToInt(XMLGamelogicReader.getPlayer().getChildText("speed"));
    }

    /**
     * Returns the speed of the hound.
     *
     * @return Speed of the hound
     */
    public static int getHoundSpeed() {
        return XMLHelper.parseStrToInt(XMLGamelogicReader.getHound().getChildText("speed"));
    }

    /**
     * Returns the Speed of the mouse.
     *
     * @return Speed of Mouse
     */
    public static int getMouseSpeed() {
        return XMLHelper.parseStrToInt(XMLGamelogicReader.getMouse().getChildText("speed"));
    }

    /**
     * Returns the Sight Range of the mouse.
     *
     * @return Mouse sight range
     */
    public static int getMouseSightRange() {
        return XMLHelper.parseStrToInt(XMLGamelogicReader.getMouse().getChildText("sight_range"));
    }

    /**
     * Returns the life increase u gain by eating a mouse.
     *
     * @return The life increase
     */
    public static int getMouseLifeIncrease() {
        return XMLHelper.parseStrToInt(XMLGamelogicReader.getMouse().getChildText("life_increase"));
    }
}
