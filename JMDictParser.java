import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    public static void ParseFile(Connection dbConnection, String readFile){

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
            //                 SequenceID, Kanji, Reading, Grammar Class, Similar Meaning, Frequency, Field, Antonym, Translation. 
            String[] fields = {"ent_seq","keb","reb","pos", "xref", "ke_pri", "field", "ant", "gloss",};

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    
                    List<String> allInfo = new ArrayList<>();
                    
                    String alternativeKanji = "";

                    // Going through each node in entry. 
                    for (String field : fields) {

                        NodeList info = eElement.getElementsByTagName(field);

                        String data = "";
                        Set<String> uniquTags = new HashSet<>(); // stop duplicate tags from getting added.

                        // To retain index places in list.
                        if (info.getLength() == 0){
                                data += null;
                            }

                        for (int j = 0; j < info.getLength(); j++) {

                            String entryContent = eElement.getElementsByTagName(field).item(j).getTextContent();

                            // Stores other forms of kanji/reading. 
                            if ("keb".equals(field) && j >= 1){
                                alternativeKanji += entryContent + " ";
                                continue;
                            }
                            // Avoids getting the 👻 on primary kanji.
                            if ("keb".equals(field) && j == 0){
                                data += entryContent;
                                continue;
                            }
                            // Avoids 👻 on end of entries.
                            if (j == info.getLength() -1 ){
                                data += entryContent;
                                continue; 
                            }

                            if ("pos".equals(field) ){
                                uniquTags.add(entryContent);
                                continue;
                            }

                            data += entryContent + "👻";
                            
                        }

                        if ("pos".equals(field) && !uniquTags.isEmpty()){
                            String result = uniquTags.toString().replaceAll("[\\[\\]]", "");
                            allInfo.add(result);
                        }
                        else {
                            allInfo.add(data.trim());
                        }

                    }
                    // Adds the other forms of kanji form.
                    allInfo.add(alternativeKanji.trim());

                    int index = 0;
                    for (Object elem : allInfo) {
                        System.out.println(index);
                        System.out.println(elem);
                        index++;
                    }
                   //  [0] SequenceID, [1] Kanji, [2] Reading, [3] Grammar Class, [4] Similar Meaning, [5] Frequency, [6] Field, [7] Antonym, [8] Translation, [9] Similar kanji.
                 //Directly send queries to sql server

                    String sequenceID = allInfo.get(0);
                    String kanji = allInfo.get(1);
                    String reading = allInfo.get(2);
                    String grammarClass = allInfo.get(3);
                    String similarMeaning = allInfo.get(4);
                    String frequency = allInfo.get(5);
                    String field = allInfo.get(6);
                    String antonym = allInfo.get(7);
                    String translation = allInfo.get(8);
                    String similarKanji = allInfo.get(9);

                    //System.out.println("Sequence ID: " + sequenceID);
                    //System.out.println("Kanji: " + kanji);
                    //System.out.println("Reading: " + reading);
                    //System.out.println("Grammar Class: " + grammarClass);
                    //System.out.println("Similar Meaning: " + similarMeaning);
                    //System.out.println("Frequency: " + frequency);
                    //System.out.println("Field: " + field);
                    //System.out.println("Antonym: " + antonym);
                    //System.out.println("Translation: " + translation);
                    //System.out.println("Similar Kanji: " + similarKanji);



                    try {

                        dbConnection.setAutoCommit(false);

                        String tranlationSQL = "INSERT INTO Translations (Gloss) VALUES(?);";
                        String metadataSQL = "INSERT INTO Metadata(Pos, Similar_Meaning, Frequency, Field, Antonym, Similar_Kanji) VALUES (?, ?, ?, ?, ?, ?);";
                        String kanjiSQL = "INSERT INTO Kanji (Kanji_Seq, Kanji, Reading, Metadata_ID, Translations_ID) VALUES (?, ?, ?, ?, ?);";
                        
                        try {

                            PreparedStatement pstmt1 = dbConnection.prepareStatement(tranlationSQL);
                            PreparedStatement pstmt2 = dbConnection.prepareStatement(metadataSQL);
                            PreparedStatement pstmt3 = dbConnection.prepareStatement(kanjiSQL);

                            // Translation insert
                            pstmt1.setString(1, translation);
                            pstmt1.executeUpdate();

                            // Metadata insert
                            pstmt2.setString(1, grammarClass);
                            pstmt2.setString(2, similarMeaning);
                            pstmt2.setString(3, frequency);
                            pstmt2.setString(4, field);
                            pstmt2.setString(5, antonym);
                            pstmt2.setString(6, similarKanji);
                            pstmt2.executeUpdate();

                            // kanji insert
                            pstmt3.setString(1, sequenceID);
                            pstmt3.setString(2, kanji);
                            pstmt3.setString(3, reading);

                            // findout how to get lst insert.
                            pstmt3.setString(4, "LAST_INSERT_ID()");
                            pstmt3.setString(5, "LAST_INSERT_ID()");
                            pstmt3.executeUpdate();

                            // Pushes inserts
                            dbConnection.commit();
                            System.out.println("Data inserted into all tables successfully.");
                            
                        } catch (SQLException e) {
                            System.out.println(e);
                        }

                        System.out.println();
                        
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                    

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