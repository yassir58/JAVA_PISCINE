package day01.ex01;

public class User {
    static int userCount = 0;
    private int id;
    private String name;
    private double balance;

    User (String name, double balance){
        userCount++;
        setBalance(balance);
        this.id = UserIdsGenerator.getInstance().generateId();
        setName(name);
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
