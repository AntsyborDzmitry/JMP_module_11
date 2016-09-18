package JMP.training.managers;

import JMP.training.beans.Person;
import JMP.training.services.DAO.DBConnectionDAO;
import JMP.training.services.DBDAOFactory;
import JMP.training.services.QueryFactory;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonManagerFromDB implements PersonManager {
    private static final String GET_ALL_PERSON = "GET_ALL_PERSON";
    private static final String SAVE_PERSON = "SAVE_PERSON";
    private static final String GET_PERSON_BY_NAME = "GET_PERSON_BY_NAME";
    private static final String UPDATE_PERSON_BY_NAME = "UPDATE_PERSON_BY_NAME";

    private DBConnectionDAO connectionDAO = new DBDAOFactory().getDAO();;
    private QueryFactory qf = new QueryFactory();

    public PersonManagerFromDB() {
    }

    public void writePerson(Person person) {

        Object lock = new Object();
        String query = qf.getQuery(SAVE_PERSON);

        try ( Connection connection = connectionDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
                synchronized (lock) {
                    preparedStatement.setString(1, person.getName());
                    preparedStatement.setInt(2, person.getAge());
                    preparedStatement.executeUpdate();
                }
        } catch (SQLException | IllegalArgumentException | ClassNotFoundException | NamingException e) {
           throw new RuntimeException(e);
        }
    }

    public void updatePerson(Person person) {

        Object lock = new Object();
        String query = qf.getQuery(UPDATE_PERSON_BY_NAME);

        try ( Connection connection = connectionDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
                synchronized (lock) {
                    preparedStatement.setInt(1, person.getAge());
                    preparedStatement.setString(2, person.getName());
                    preparedStatement.executeUpdate();
                }
        } catch (SQLException | IllegalArgumentException | ClassNotFoundException | NamingException e) {
           throw new RuntimeException(e);
        }
    }

    public List <Person> readAllPerson() {
        String query = qf.getQuery(GET_ALL_PERSON);
        List <Person> persons = new ArrayList<Person>();
        Person person = null;

        try ( Connection connection = connectionDAO.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    person = createPerson(resultSet);
                    persons.add(person);
                }
            }
        } catch (SQLException | IllegalArgumentException | ClassNotFoundException | NamingException e) {
            throw new RuntimeException(e);
        }

        return persons;
    }

    public Person readPerson(String name) {
        String query = qf.getQuery(GET_PERSON_BY_NAME);

        Person person = null;

        try ( Connection connection = connectionDAO.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(query);) {
                preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    person = createPerson(resultSet);
                }
            }
        } catch (SQLException | IllegalArgumentException | ClassNotFoundException | NamingException e) {
            throw new RuntimeException(e);
        }

        return person;
    }

    private Person createPerson (ResultSet rs) throws SQLException {
        Person person = new Person();

        person.setName(rs.getString("NAME"));
        person.setAge(rs.getInt("AGE"));

        return person;
    }
}
