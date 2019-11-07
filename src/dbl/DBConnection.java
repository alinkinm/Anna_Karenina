package dbl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_USERNAME ="postgres";
    private static final String DB_PASSWORD ="h";
    private static final String DB_URL ="jdbc:postgresql://localhost:5432/anna_karenina";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
