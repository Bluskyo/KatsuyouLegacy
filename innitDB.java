import java.sql.Connection;

// Innit database

// To bypass entityexpansionlimit use: 
// java -Djdk.xml.entityExpansionLimit=0 main 

public class innitDB{
    public static void start(String readFile, String url, String user, String password){

        // Get connection to DB.
        Connection connection = MySQLConnection.getConnection(url, user, password);

        double start1 = System.nanoTime();
        System.out.println("Parse started!");

        // run parse of XML 
        JMDictParser.ParseFile(connection, readFile); 
        double end1 = System.nanoTime();
        double elapsedTimeNs = end1 - start1; 

        double elapsedTimeMinutes = elapsedTimeNs / (60.0 * 1000000000.0);

        System.out.println("\nElapsed Time:\nMin: "+ elapsedTimeMinutes); 
    }
}