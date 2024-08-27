import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnection {
    public static Connection getConnection(String url, String user, String password) {

        try {            
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database at: " + url);
            return connection;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

}