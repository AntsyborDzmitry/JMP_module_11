package JMP.training.services;

import JMP.training.services.DAO.DBConnectionDAO;
import JMP.training.services.DAOImpl.DBConnectionDAOSQLImpl;


public class DBDAOFactory {
    public DBDAOFactory() {
    }
    public DBConnectionDAO getDAO () {
        return new DBConnectionDAOSQLImpl();
    }
}
