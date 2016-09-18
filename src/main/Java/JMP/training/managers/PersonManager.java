package JMP.training.managers;

import JMP.training.beans.Person;

import java.util.List;

public interface PersonManager {
    void writePerson (Person person);
    void updatePerson (Person person);
    List<Person> readAllPerson();
    Person readPerson (String name);

}
