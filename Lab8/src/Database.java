import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "STUDENT";
    private static final String PASSWORD = "STUDENT";
    private static Connection connection = null;

    private Database() {
    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        }

        return connection;
    }

    public static void createTables() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS countries " +
                    "(id NUMBER(10) NOT NULL" +
                    " name VARCHAR(255), " +
                    " code VARCHAR(255), " +
                    " continent VARCHAR(255), ";

            String sql2 = "CREATE TABLE IF NOT EXISTS continents " +
                    "(id INT NOT NULL IDENTITY(1,1) PRIMARY KEY" +
                    " name VARCHAR(255), ";

            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            System.out.println("Created tables in given database...");
        } catch (SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        }
    }


    private static void createConnection() {
        try {
            connection = connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) connection.close();
    }
}
