package thisbankapprocks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public final static String DB_DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public final static String DB_URL = "jdbc:sqlserver://;databaseName=";
    public final static String DB_USERNAME = "";
    public final static String DB_PASSWORD = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conn = null;

        Class.forName(DB_DRIVER_CLASS);

        conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        return conn;
    }
}
