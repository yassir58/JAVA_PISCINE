package day01.ex0;

import java.util.UUID;

public class User {

    static int userCount = 0;
    private UUID id;
    private String name;
    private double balance;

    User (String name, double balance){
        userCount++;
        setId();
        setBalance(balance);
        setName(name);
    }

    public UUID getId() {
        return id;
    }
    public void setId() {
        this.id = UUID.randomUUID();
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
