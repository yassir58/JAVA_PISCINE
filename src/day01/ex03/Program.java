package day01.ex03;
import java.util.UUID;

public class Program {

    public static void main(String[] args) {


        User    nassim = new User("Nassim", 1000);
        User    yassine = new User("Yassine", 2000);
        User    ahmed = new User("Ahmed", 3000);
        User    ahmed2 = new User("Ahmed", 3000);

        // testing initialization
        nassim.addTransaction(new Transaction(nassim, yassine, Transaction.Category.DEBIT, 2000));
        nassim.addTransaction(new Transaction(yassine, nassim, Transaction.Category.CREDIT, 2000));
        nassim.addTransaction(new Transaction(ahmed, nassim, Transaction.Category.DEBIT, 2000));
        nassim.addTransaction(new Transaction(nassim, yassine, Transaction.Category.CREDIT, 2000));
        Transaction[] transactions = nassim.getTransactionsList().transactionsToArray();
        System.out.println("Transactions:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getAmount() + " " + transaction.getCategory() + " " + transaction.getRecipient().getName() + " " + transaction.getSender().getName() + " " + transaction.getTransactionId());
        }

        // testing transaction deletion
        UUID transactionId = transactions[0].getTransactionId();
        nassim.getTransactionsList().removeTransactionById(transactionId);
        transactions = nassim.getTransactionsList().transactionsToArray();
        System.out.println("Transactions after deletion:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getAmount() + " " + transaction.getCategory() + " " + transaction.getRecipient().getName() + " " + transaction.getSender().getName() + " " + transaction.getTransactionId());
        }

    }
}
