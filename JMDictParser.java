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
    public static void ParseFile(String[] Kanji, String readFile, String writeFile ){

        //List<String> kanjiInfo = new ArrayList<>();

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


            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                //System.out.println(nNode.getNodeName());
                //System.out.println(nNode.getTextContent());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String JMdictID = eElement.getElementsByTagName("ent_seq").item(0).getTextContent();
                    
                    // do: Iterate through list and print out everything. 
                    String kanji = eElement.getElementsByTagName("keb").item(0).getTextContent();
                    String reading = eElement.getElementsByTagName("reb").item(0).getTextContent();
                    String frequency = eElement.getElementsByTagName("ke_pri").item(0).getTextContent();
                    String pos = eElement.getElementsByTagName("pos").item(1).getTextContent();
                    String gloss = eElement.getElementsByTagName("gloss").item(0).getTextContent();

                    String result = String.format("JMdictID: %s\nKanji: %s\nReading: %s\nFrequency: %s\nPart of Speech: %s\nMeaning: %s", JMdictID, kanji, reading, frequency, pos, gloss);

                    System.out.println(result + "\n");


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