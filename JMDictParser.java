import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class JMDictParser{
    public static void ParseFile(String[] Kanji, String readFile, String writeFile ){

        //List<String> kanjiInfo = new ArrayList<>();


        // Read
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Reads File
            File inputFile = new File(readFile);

            // Parses document
            Document doc = builder.parse(inputFile);

            //Builds xPath
            XPath xPath =  XPathFactory.newInstance().newXPath();

            String expression = "/entry/keb";	    

            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                System.out.println("Text Content: " + nNode.getTextContent());
            }

        }   
        catch (FileNotFoundException | ParserConfigurationException | SAXException | XPathException e) {
            System.out.println("An error occurred:" + e);
        }
        catch (IOException ioErr){
            System.out.println("An error occurred:" + ioErr);
        }

        
    }

}