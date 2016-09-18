package JMP.training.services.DAOImpl;


import JMP.training.services.DAO.DBConnectionDAO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionDAOSQLImpl implements DBConnectionDAO{

    private  final String DRIVER_CLASS = "org.apache.derby.jdbc.EmbeddedDriver";
    private  static String CONECT_URL = "jdbc:derby:spring_MVC\\resources\\personDB;create=false;user=admin;password=admin";
    private  final String USER = "admin";
    private  final String PASSW = "admin";
    private  Connection baseConnection;

    private DataSource ds;
    private Context ctx ;

    public DBConnectionDAOSQLImpl() {
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException, NamingException {
        Class.forName(DRIVER_CLASS);
        ctx = new InitialContext();

        ds = (DataSource)ctx.lookup("java:comp/env/jdbc/derbyDB");
        baseConnection = ds.getConnection();

        //baseConnection = DriverManager.getConnection(CONECT_URL  , USER , PASSW);

        return baseConnection;

    }
}
