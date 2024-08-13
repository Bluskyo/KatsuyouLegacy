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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class JMDictParser{
    public static void ParseFile(String readFile){

        System.out.println("Running Parse!");

        // Read
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Reads File
            File inputFile = new File(readFile);

            // Parses document
            Document doc = builder.parse(inputFile);

            // Builds xPath
            XPath xPath =  XPathFactory.newInstance().newXPath();

            // Loads entire entry of kanji. 
            NodeList nodeList = (NodeList) xPath.compile("//entry").evaluate(doc, XPathConstants.NODESET);

            // List for getting info for Entry: SequenceID, Kanji, Reading, Grammar Class, Frequency, Field, Antonym, Translation. 
            String[] fields = {"ent_seq","keb","reb","pos", "ke_pri", "field", "ant", "gloss",};

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    
                    // Going through each node in entry. 
                    for (String field : fields) {
                        NodeList info = eElement.getElementsByTagName(field);
                        for (int k = 0; k < info.getLength(); k++) {
                            String allList = eElement.getElementsByTagName(field).item(k).getTextContent();
                            System.out.println(allList);
                        }
                    }

                    // Directly send queries to sql server? 
                }
                    
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