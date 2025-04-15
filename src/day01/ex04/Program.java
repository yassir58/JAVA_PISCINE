package day01.ex04;
import java.util.UUID;

public class Program {

    public static void main(String[] args) {


        User    nassim = new User("Nassim", 1000);
        User    yassine = new User("Yassine", 2000);
        User    ahmed = new User("Ahmed", 3000);
        User    nordine = new User("Nordine", 4000);
        UsersArrayList usersList = new UsersArrayList();
        usersList.addUser(nassim);
        usersList.addUser (yassine);
        usersList.addUser(ahmed);

        TransactionsService transactionsService = new TransactionsService(usersList);

        // testing add new user
        transactionsService.addUser(nordine);

        UsersArrayList users = transactionsService.getUsers();
        System.out.println("Users count: " + users.getUserCount());
        // testing retreive user's balance
        try {
            System.out.println("User " + yassine.getName() + " has balance: " + transactionsService.getUserBalance(yassine.getId()));
        } catch (UserNotFoundException e) {
            System.out.println("User not found");
        }

        // testing preform transfer
        try {
            transactionsService.preformTransfer(nassim.getId(), yassine.getId(), 5000);
            System.out.println("Transfer completed");
        } catch (UserNotFoundException e) {
            System.out.println("User not found");
        } catch (IllegalTransactionException e) {
            System.out.println("Illegal transaction");
        }

        try {
            transactionsService.preformTransfer(nordine.getId(), yassine.getId(), 500);
            System.out.println("Transfer completed");
        } catch (UserNotFoundException e) {
            System.out.println("User not found");
        } catch (IllegalTransactionException e) {
            System.out.println("Illegal transaction");
        }

        // testing get user transactions

        try {
            Transaction[] transactions = transactionsService.getUserTransactions(nordine.getId());
            System.out.println("User " + nordine.getName() + " transactions:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction.getTransactionId() + " " + transaction.getRecipient().getName() + " -> " + transaction.getSender().getName() + " " + transaction.getAmount());
            }
        } catch (UserNotFoundException e) {
            System.out.println("User not found");
        }
    }
}
