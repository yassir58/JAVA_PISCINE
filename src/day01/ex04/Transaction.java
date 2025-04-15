package day01.ex04;


import java.util.UUID;

public class Transaction {

    static int transactionCount = 0;
    private UUID transactionId;
    private User Recipient;
    private User Sender;
    private Category Category;

    public boolean isPaired() {
        if (Recipient.getTransactionsList().transactionsToArray().length == 0) {
            return false;
        }
        for (Transaction transaction : Recipient.getTransactionsList().transactionsToArray()) {
            if (transaction.getTransactionId().equals(this.transactionId)) {
                return true;
            }
        }
        return false;
    }

    enum Category {
       DEBIT,
         CREDIT,
    };
    private double amount;
    private double sum;

    Transaction (User Recipient, User Sender, Category category, double amount){
        transactionCount++;

        setCategory(category);
        setTransactionId();
        setRecipient(Recipient);
        setSender(Sender);
        setAmount(amount);
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId() {
        this.transactionId = UUID.randomUUID();
    }

    public User getRecipient() {
        return Recipient;
    }

    public void setRecipient(User recipient) {
        Recipient = recipient;
    }

    public User getSender() {
        return Sender;
    }
    public void setSender(User sender) {
        Sender = sender;
    }

    public Category getCategory() {
        return Category;
    }
    public void setCategory(Category category) {
        Category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = this.Sender.getBalance() - amount;
    }

    public void printTransaction(){

        System.out.println("Transaction ID: " + getTransactionId());
        System.out.println("Sender: " + getSender().getName());
        System.out.println("Recipient: " + getRecipient().getName());
        System.out.println("Category: " + getCategory());
        System.out.println("Amount: " + getAmount());
        System.out.println("Sender's balance: " + getSender().getBalance());
        System.out.println("Recipient's balance: " + getRecipient().getBalance());
    }

    public void processTransaction(){
        if (getCategory() == Category.CREDIT){
            if (getSender().getBalance() < getAmount()){
                System.out.println("Transaction failed: Insufficient funds");
                return;
            }
            getRecipient().setBalance(getRecipient().getBalance() + getAmount());
            getSender().setBalance(getSender().getBalance() - getAmount());
        } else if (getCategory() == Category.DEBIT){
            if (getRecipient().getBalance() < getAmount()){
                System.out.println("Transaction failed: Insufficient funds");
                return;
            }
            getRecipient().setBalance(getRecipient().getBalance() - getAmount());
            getSender().setBalance(getSender().getBalance() + getAmount());
        }
    }

}

