package JMP.training.beans;

public class Person  {
    private String name ;
    private int balance ;

    public Person() {
    }

    public Person(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }


    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
