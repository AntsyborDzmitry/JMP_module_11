package JMP.training.factories;


import JMP.training.managers.PersonManager;

public abstract class AbstractManagerFactory {

    public AbstractManagerFactory() {
    }

    public abstract PersonManager createPersonManager ();
}
