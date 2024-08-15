import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

            // List for getting info for Entry: 
            //                 SequenceID, Kanji, Reading, Similar Meaning, Grammar Class, Frequency, Field, Antonym, Translation. 
            String[] fields = {"ent_seq","keb","reb","pos", "xref", "ke_pri", "field", "ant", "gloss",};

            for (int j = 0; j < nodeList.getLength(); j++) {
                Node nNode = nodeList.item(j);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    
                    List<String> data = new ArrayList<>();

                    List<String> alternativeKanji = new ArrayList<>();
                    List<String> alternativeReading = new ArrayList<>();

                    // Going through each node in entry. 
                    for (String field : fields) {

                        NodeList info = eElement.getElementsByTagName(field);

                        for (int k = 0; k < info.getLength(); k++) {
                            String entryContent = eElement.getElementsByTagName(field).item(k).getTextContent();

                            //System.out.println(entryContent);

                            // Stores other forms of kanji/reading. 
                            if ("keb".equals(field) && k >= 1){
                                alternativeKanji.add(entryContent);
                            }
                            else if ("reb".equals(field) && k >= 1) {
                                alternativeReading.add(entryContent);
                            }

                            


                        }
                    }
                    String test = alternativeKanji.toString();
                    System.out.println(test);

                    String test2 = alternativeReading.toString();
                    System.out.println(test2);
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