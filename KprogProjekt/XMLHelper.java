
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * Provides some methods used by our other XML_Classes.
 *
 * @author simonhoinkis
 * @version 1.0
 */
public final class XMLHelper {
/**
 * constructor for XMLHelper.
 */
private XMLHelper() {
}

    /**
     * Returns the root of a XML File.
     *
     * @param filepath The XML File
     * @return The Root Element
     */
    public static Element getRoot(String filepath) {
        Element root = null;
        try {
            //read the Map information from the XML file into a JDOM Document
            Document xml = new SAXBuilder().build(filepath);

            root = xml.getRootElement();
        } catch (JDOMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return root;
    }

    /**
     * parses a string into an integer.
     *
     * @param str The string to be converted
     * @return The integer that is converted
     */
    public static int parseStrToInt(String str) {
        int parseNumber = 0;

        try {
            parseNumber = Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return parseNumber;
    }
}
