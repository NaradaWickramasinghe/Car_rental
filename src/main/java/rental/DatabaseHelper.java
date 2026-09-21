package rental;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Centralized database connection helper.
 * Loads credentials from db.properties file instead of hardcoding them.
 * 
 * @author Narada Prabath
 */
public class DatabaseHelper {

    private static String url;
    private static String username;
    private static String password;
    private static String driver;

    static {
        loadProperties();
    }

    /**
     * Loads database configuration from db.properties file on the classpath.
     */
    private static void loadProperties() {
        Properties props = new Properties();
        try (InputStream input = DatabaseHelper.class.getClassLoader()
                .getResourceAsStream("db.properties")) {
            if (input != null) {
                props.load(input);
                url = props.getProperty("db.url");
                username = props.getProperty("db.username");
                password = props.getProperty("db.password");
                driver = props.getProperty("db.driver");
            } else {
                // Fallback defaults if properties file is not found
                System.err.println("db.properties not found on classpath, using defaults.");
                url = "jdbc:mysql://localhost:3306/vehiclerentdata";
                username = "root";
                password = "Narada123";
                driver = "com.mysql.cj.jdbc.Driver";
            }
        } catch (IOException e) {
            System.err.println("Error loading db.properties: " + e.getMessage());
            url = "jdbc:mysql://localhost:3306/vehiclerentdata";
            username = "root";
            password = "Narada123";
            driver = "com.mysql.cj.jdbc.Driver";
        }
    }

    /**
     * Returns a new database connection.
     * Loads the JDBC driver and establishes a connection using properties from db.properties.
     *
     * @return a new Connection object
     * @throws ClassNotFoundException if the JDBC driver class is not found
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * Returns the database URL (for use in Jasper reports or other tools that need it).
     */
    public static String getUrl() {
        return url;
    }
}
