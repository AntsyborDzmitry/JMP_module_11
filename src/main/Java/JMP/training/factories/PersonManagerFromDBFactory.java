package JMP.training.factories;

import JMP.training.managers.PersonManager;
import JMP.training.managers.PersonManagerFromDB;

public class PersonManagerFromDBFactory extends AbstractManagerFactory{
    public PersonManagerFromDBFactory() {
    }

    public PersonManager createPersonManager() {
        return new PersonManagerFromDB();
    }
}
