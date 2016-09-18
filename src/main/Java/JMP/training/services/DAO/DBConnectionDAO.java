package JMP.training.services.DAO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnectionDAO {
    Connection  getConnection() throws SQLException, ClassNotFoundException, NamingException;
}
