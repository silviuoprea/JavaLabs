import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Database.createTables();
            var continents = new ContinentDAO();
            continents.create("Europe");
            if (!Database.getConnection().getAutoCommit()) {
                Database.getConnection().commit();
            }
            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
            if (!Database.getConnection().getAutoCommit()) {
                Database.getConnection().commit();
            }
            try (Statement stmt = Database.getConnection().createStatement();
                 ResultSet rs = stmt.executeQuery("select * from countries")) {

                while (rs.next()) {
                    String name = rs.getString(3);
                    System.out.println("name: " + name);
                }
            }
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
