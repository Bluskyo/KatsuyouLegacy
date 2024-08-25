import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQLConnection {
    public static void getConnection() throws ClassNotFoundException{

        String url = "jdbc:mysql://localhost:3307/JMDict";
        String user = "root";
        String password = ""; 
        
        try {            
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statment = connection.createStatement();
            ResultSet resultSet = statment.executeQuery("SELECT * FROM JMDict.Kanji;");

            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}