package day01.ex04;

public class User {
    static int userCount = 0;
    private int id;
    private String name;
    private double balance;
    private TransactionsLinkedList transactionsList;

    User (String name, double balance){
        userCount++;
        setBalance(balance);
        this.id = UserIdsGenerator.getInstance().generateId();
        setName(name);
        transactionsList = new TransactionsLinkedList();
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

    public TransactionsLinkedList getTransactionsList() {
        return transactionsList;
    }
    public void addTransaction(Transaction transaction) {
        transactionsList.addTransaction(transaction);
    }
}
