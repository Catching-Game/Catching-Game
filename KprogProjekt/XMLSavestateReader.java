
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Element;

/**
 * The XML_Savestate_Reader reads our savestate to provide our loading function
 *
 * @author simonhoinkis
 * @version 0.11
 */
public final class XMLSavestateReader {

    private static final String FILEPATH = "XML/Savestate.xml";

    private XMLSavestateReader() {
    }
/**
 * get mice from xml.
 * @return 
 */
    private static Element getMice() {
        return XMLHelper.getRoot(XMLSavestateReader.FILEPATH).getChild("mice");
    }
/**
 * get hounds from xml.
 * @return
 */
    private static Element getHounds() {
        return XMLHelper.getRoot(XMLSavestateReader.FILEPATH).getChild("hounds");
    }
    /**
     * get player from xml.
     * @return
     */
    private static Element getPlayer() {
        return XMLHelper.getRoot(XMLSavestateReader.FILEPATH).getChild("players");
    }
/**
 * get player count from xml.
 * @return 
 */
    public static int getPlayerCount() {
        int maxPlayers = 4;
        int playerCount = 0;
        for (int i = 0; i <= maxPlayers; i++) {
            if (getPlayer().getChild("player" + i) != null) {
                playerCount = playerCount + 1;
            }
        }
        return playerCount;
    }
/**
 * get counters from xml.
 * @return
 */
    public static Element getCounters() {
        return XMLHelper.getRoot(XMLSavestateReader.FILEPATH).getChild("counters");
    }
/**
 * get player position from xml.
 * @param playerID
 * @return
 */
    //TODO playerID.ordinal da inder XML falsch gespeichert wird von Player Klasse
    public static Position getPlayerPosition(PlayerID playerID) {
        Position playerPosition;

        //get the current player
        Element player = XMLSavestateReader.getPlayer().getChild("player" + playerID.getValue());

        playerPosition = new Position(XMLHelper.parseStrToInt(player.getChildText("position_x")),
                XMLHelper.parseStrToInt(player.getChildText("position_y")));
        return playerPosition;
    }

    /**
     * Returns player image path.
     * @param playerID the player which image should be returned
     * @return the player image path
     */
    public static String getPlayerImage(PlayerID playerID) {
        //get the current player
        Element player = XMLMapReader.getPlayer().getChild("player" + playerID.getValue());

        return player.getChildText("image");
    }

    /**
     * A Getter for the playerName of the wanted ID.
     *
     * @param playerID the ID of the player
     * @return return the name of the player of the wanted playerID
     */
    public static String getPlayerName(PlayerID playerID) {
        //get current player name
        Element player = XMLMapReader.getPlayer().getChild("player" + playerID.getValue());

        return player.getChildText("player_name");
    }

    /**
     * Returns the mice image paths.
     *
     * @return The image paths
     */
    public static String getMiceImage() {
        return XMLMapReader.getMice().getChildText("image");
    }

    /**
     * Returns the mice count.
     *
     * @return The mice count
     */
    public static int getMiceCount() {
        return XMLSavestateReader.getMice().getChildren("mouse").size();
    }

    /**
     * Returns the Mice Positions.
     *
     * @return The Mice positions
     */
    public static ArrayList<PositionWithDirection> getMicePositions() {
        List<Element> mice = getMice().getChildren("mouse");
        ArrayList<PositionWithDirection> mousePositions = new ArrayList<PositionWithDirection>();

        //add the positions to a list
        for (Element mouse : mice) {
            mousePositions.add(new PositionWithDirection(XMLHelper.parseStrToInt(mouse.getChildText("position_x")),
                    XMLHelper.parseStrToInt(mouse.getChildText("position_y")),
                    Direction.valueOf(mouse.getChildText("position_direction"))));
        }

        return mousePositions;
    }

    /**
     * Returns the Hound Image Path.
     *
     * @return a String with the Hound Image Path
     */
    public static String getHoundImage() {
        return XMLSavestateReader.getHounds().getChildText("image");
    }

    /**
     * Returns the quantity of the Hound objects.
     *
     * @return a int with the qantity of Hount objects
     */
    public static int getHoundCount() {
        return XMLSavestateReader.getHounds().getChildren("hound").size();
    }

    /**
     * Returns a PositionArrayList with Position x and Position y.
     *
     * @return ArrayList<Position> with Position x and Position y
     */
    public static ArrayList<Position> getHoundPositions() {
        List<Element> hounds = getHounds().getChildren("hound");
        ArrayList<Position> houndPositions = new ArrayList<Position>();

        //add the positions to a list
        for (Element hound : hounds) {
            houndPositions.add(new Position(XMLHelper.parseStrToInt(hound.getChildText("position_x")),
                    XMLHelper.parseStrToInt(hound.getChildText("position_y"))
            ));
        }
        return houndPositions;
    }

    /**
     * Get the image for the counter.
     *
     * @return counter image
     */
    public static String getCounterImage() {
        return XMLMapReader.getCounter().getChildText("image");
    }

    /**
     * Returns a PositionArrayList with Position x and Position y.
     *
     * @return ArrayList<Position> with Position x and Position y
     */
    public static Position getCounterPosition(PlayerID playerID) {
        Position counterPosition;

        //get the current player
        Element counter = XMLMapReader.getCounter().getChild("counter" + playerID.getValue());

        counterPosition = new Position(XMLHelper.parseStrToInt(counter.getChildText("position_x")),
                XMLHelper.parseStrToInt(counter.getChildText("position_y")));
        return counterPosition;
    }

//TODO SavestateReader fertigstellen, sobald speicher Variablen bekannt
}
