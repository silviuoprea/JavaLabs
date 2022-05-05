import java.sql.*;

public class CountryDAO implements GenericDAO {
    @Override
    public void create(Entities entities) throws SQLException {
        Country country = (Country) entities;

        Connection con = Database.getConnection();

        try (PreparedStatement pstmt = con.prepareStatement("insert into countries (name, code, continent) values (?, ?, ?)")) {
            pstmt.setString(1, country.getName());
            pstmt.setString(2, country.getCode());
            pstmt.setString(3, country.getContinent());
            pstmt.executeUpdate();
        }
    }

    @Override
    public Country findByName(String name) throws SQLException {
        Connection con = Database.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id, code, continent from countries where name='" + name + "'")) {
            return rs.next() ? new Country(rs.getInt("id"), name, rs.getString("code"), rs.getString("continent")) : null;
        }
    }

    @Override
    public Country findById(int id) throws SQLException {
        Connection con = Database.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name, europeId, continent from countries where id=" + id)) {
            return rs.next() ? new Country(id, rs.getString("name"), rs.getString("code"), rs.getString("continent")) : null;
        }
    }

    @Override
    public void findAll() throws SQLException {
        Connection con = Database.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id, name, europeId, continent from countries")) {
            while (rs.next()) {
                Country country = new Country(rs.getInt("id"), rs.getString("name"), rs.getString("code"), rs.getString("continent"));

                System.out.println(country);
            }
        }
    }
}
