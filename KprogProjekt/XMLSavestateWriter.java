import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * 
 * @author simonhoinkis
 *
 */
public class XMLSavestateWriter {
	private XMLSavestateWriter() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param gw
	 */
	public static void save(GameWorld gw) {
		Element savestate = new Element("savestate");
		Document doc = new Document(savestate);
		
		List<Object> playerList =gw.getObjects(Player.class);
		List<Object> mouseList = gw.getObjects(Mouse.class);
		List<Object> houndList = gw.getObjects(Hound.class);
		
		Element players = new Element("players");
		
		for(Object player : playerList) {
			Player playerCasted = (Player) player;
			players.addContent(playerCasted.save());
		}
		
		doc.getRootElement().addContent(players);
		
		Element mice = new Element("mice");

		for(Object mouse : mouseList) {
			Mouse mouseCasted = (Mouse) mouse;
			mice.addContent(mouseCasted.save());
		}
		
		doc.getRootElement().addContent(mice);
		
		
		Element hounds = new Element("hounds");
		
		for(Object hound : houndList) {
			Hound houndCasted = (Hound) hound;
			hounds.addContent(houndCasted.save());
		}
		
		doc.getRootElement().addContent(hounds);
		
		// new XMLOutputter().output(doc, System.out);
		XMLOutputter xmlOutput = new XMLOutputter();
 try {
		// display nice nice
		xmlOutput.setFormat(Format.getPrettyFormat());
		xmlOutput.output(doc, new FileWriter("./XML/Savestate.xml"));
 } catch(Exception e) {
	 e.printStackTrace();
 }
	}
}
