
package day01.ex05;

import java.util.Scanner;
import java.util.UUID;

public class Menu {

    private TransactionsService transactionsService;
    private int requestNumber;
    private String profile;


    public Menu(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    public Menu(String profile){
        this.profile = profile;
        this.transactionsService = new TransactionsService(new UsersArrayList());
    }
    public void showMenu() {
        System.out.println("1. Add a user");
        System.out.println("2. View user balances");
        System.out.println("3. Perform a transfer");
        System.out.println("4. View all transactions for a specific user");
        if (profile.equals("dev"))
            System.out.println("5. DEV - remove a transfer by ID");
        if (profile.equals("dev"))
            System.out.println("6. DEV - check transfer validity");
        System.out.println("7. Finish Execution");
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
    public String getProfile() {
        return profile;
    }
    public int getRequestNumber() {
        return requestNumber;
    }

    public void addUser(User user) {
        transactionsService.addUser(user);
        System.out.printf("User %s with id = %d and balance = %f added\n", user.getName(), user.getId(), user.getBalance());
    }

    public void addUserService(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a user name and a balance");
        System.out.print("-> ");
        String userInfo = scanner.nextLine();
        if (userInfo.split(" ").length != 2) {
            System.out.println("Invalid input format. Please enter a name and a balance.");
            return;
        }
        String username = userInfo.split(" ")[0];
        double balance = Double.parseDouble(userInfo.split(" ")[1]);
        User user = new User(username, balance);
        addUser(user);
    }

    public User getUserById(int id) throws UserNotFoundException {
        return transactionsService.getUsers().getUserById(id);
    }

    public void getUserService () throws UserNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a user ID");
        System.out.print("-> ");
        int id = scanner.nextInt();
        User user = getUserById(id);
        System.out.printf("%s - %s\n", user.getName(), user.getBalance());
    }

    public void performTransferService() throws UserNotFoundException, IllegalTransactionException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
        System.out.print("-> ");
        String transferInfo = scanner.nextLine();
        if (transferInfo.split(" ").length != 3) {
            System.out.println("Invalid input format. Please enter a sender ID, a recipient ID, and a transfer amount.");
            return;
        }
        int fromUserId = Integer.parseInt(transferInfo.split(" ")[0]);
        int toUserId = Integer.parseInt(transferInfo.split(" ")[1]);
        double amount = Double.parseDouble(transferInfo.split(" ")[2]);
        transactionsService.preformTransfer(fromUserId, toUserId, amount);
        System.out.println("The transfer is completed");
    }

    public void getUserTransactionsService() throws UserNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a user ID");
        System.out.print("-> ");
        int id = scanner.nextInt();
        Transaction[] transactions = transactionsService.getUserTransactions(id);
        for (Transaction transaction : transactions) {
            char category = transaction.getCategory() == Transaction.Category.CREDIT ? '+' : '-';
            System.out.printf("To %s(id = %d) %c%f with id = %s\n", transaction.getSender().getName(), transaction.getSender().getId(),category, transaction.getAmount(), transaction.getTransactionId());
        }
    }

    public void checkTransactionsService() {
        Transaction[] unpairedTransactions = transactionsService.checkTransactions();
        if (unpairedTransactions.length == 0) {
            System.out.println("All transactions are paired");
            return;
        }
        for (Transaction transaction : unpairedTransactions) {
            System.out.printf("Unpaired transaction: %s\n", transaction.getTransactionId());
        }
    }

    public void removeTransactionService() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a user ID and a transfer ID");
        System.out.print("-> ");
        String transactionId = scanner.nextLine();
        if (transactionId.split(" ").length != 2) {
            System.out.println("Invalid input format. Please enter a user ID and a transfer ID.");
            return;
        }
        String userId = transactionId.split(" ")[0];
        String transferId = transactionId.split(" ")[1];
        User user = transactionsService.getUsers().getUserById(Integer.parseInt(userId));
        user.getTransactionsList().removeTransactionById(UUID.fromString(transferId));
        System.out.printf("Transfer To %s(id = %d) %f removed\n", user.getName(), user.getId(), user.getBalance());
    }

    public void startMenu () {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            System.out.print("-> ");
            int requestNumber = scanner.nextInt();
            if (requestNumber > 7) {
                break;
            }
            setRequestNumber(requestNumber);
            switch (requestNumber) {
                case 1:
                    addUserService();
                    break;
                case 2:
                    try {
                        getUserService();
                    } catch (UserNotFoundException e) {
                        System.out.println("User not found");
                    }
                    break;
                case 3:
                    try {
                        performTransferService();
                    } catch (UserNotFoundException | IllegalTransactionException e) {
                        System.out.println("Illegal transaction");
                    }
                    break;
                case 4:
                    try {
                        getUserTransactionsService();
                    } catch (UserNotFoundException e) {
                        System.out.println("User not found");
                    }
                    break;
                case 5:
                    if (profile.equals("dev")) {
                        removeTransactionService();
                    } else {
                        System.out.println("You are not authorized to use this feature.");
                    }
                    break;
                case 6:
                    if (profile.equals("dev")) {
                        checkTransactionsService();
                    } else {
                        System.out.println("You are not authorized to use this feature.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println("---------------------------------");
        }
    }


}
