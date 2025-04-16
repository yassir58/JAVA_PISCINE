package day01.ex05;


public class TransactionsService {

    private UsersArrayList usersList;

    public TransactionsService(UsersArrayList usersList) {
        this.usersList = usersList;
    }

    public void addUser(User user){
        usersList.addUser(user);
    }

    public double getUserBalance(int id) throws UserNotFoundException {
        User user = usersList.getUserById(id);
        return user.getBalance();
    }

    public void preformTransfer (int fromUserId, int toUserId, double amount) throws UserNotFoundException, IllegalTransactionException {
        User fromUser = usersList.getUserById(fromUserId);
        User toUser = usersList.getUserById(toUserId);
        if (fromUser.getBalance() < amount) {
            throw new IllegalTransactionException();
        }
        fromUser.addTransaction(new Transaction(fromUser, toUser, Transaction.Category.CREDIT, amount));
        toUser.addTransaction(new Transaction(toUser, fromUser, Transaction.Category.DEBIT, amount));
        fromUser.setBalance(fromUser.getBalance() - amount);
        toUser.setBalance(toUser.getBalance() + amount);
    }

    public UsersArrayList getUsers() {
        return (UsersArrayList) usersList;
    }

    public Transaction[] getUserTransactions(int userId) throws UserNotFoundException {
        User user = usersList.getUserById(userId);
        return user.getTransactionsList().transactionsToArray();
    }

    // Check validity of transactions (returns an ARRAY of unpaired transactions)

    public Transaction[] checkTransactions() {
        Transaction[] unpairedTransactions = new Transaction[usersList.getUserCount()];
        int index = 0;
        for (int i = 0; i < usersList.getUserCount(); i++) {
            User user = usersList.getUserByIndex(i);
            Transaction[] transactions = user.getTransactionsList().transactionsToArray();
            for (Transaction transaction : transactions) {
                if (!transaction.isPaired()) {
                    unpairedTransactions[index++] = transaction;
                }
            }
        }
        return unpairedTransactions;
    }
}
