import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnection {
    public static Connection getConnection(){

        
        
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            return null;
        }
    }

    }