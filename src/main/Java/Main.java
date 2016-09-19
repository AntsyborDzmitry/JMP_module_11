import JMP.training.beans.Person;
import JMP.training.factories.AbstractManagerFactory;
import JMP.training.factories.PersonManagerFromDBFactory;
import JMP.training.managers.PersonManager;

public class Main {
    public static void main(String[] args) {
        /*
         * Work with Derby DB
         */

        AbstractManagerFactory dbManager = new PersonManagerFromDBFactory();
        PersonManager pmDB = dbManager.createPersonManager();
        Person p = pmDB.readPerson("Vitalya");

        System.out.println("read last from DB ->    "+p.getName()+" , " + p.getBalance());

        p = pmDB.readPerson("Vitalya");
        System.out.println("read by name from DB ->   "+p.getName()+" , " + p.getBalance());

        pmDB.writePerson(new Person("Toma",30));

        String name = "Toma";
        p = pmDB.readPerson(name);
        if (p!= null) {
            System.out.println("Write and read written by name from DB ->   "+p.getName()+" , " + p.getBalance());
        }else {
            System.out.println("Entries with name " + name + " not found in file storage.");
        }

    }
}
