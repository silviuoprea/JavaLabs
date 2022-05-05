import java.sql.SQLException;

public interface GenericDAO {
    void create(Entities entities) throws SQLException;

    Entities findByName(String name) throws SQLException;

    Entities findById(int id) throws SQLException;

    void findAll() throws SQLException;
}
