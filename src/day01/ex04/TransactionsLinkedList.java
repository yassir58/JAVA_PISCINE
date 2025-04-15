package day01.ex04;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    private LinkedList<Transaction> transactions;
    private int transactionCount;

    public TransactionsLinkedList() {
        transactions = new LinkedList<Transaction>();
        };

    @Override
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transactionCount++;
    }
    @Override
    public void removeTransactionById(UUID id) throws TransactionNotFoundException {
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionId().equals(id)) {
                transactions.remove(transaction);
                transactionCount--;
                break;
            }
            throw  new TransactionNotFoundException();
        }
    }

    @Override
    public Transaction[] transactionsToArray() {
        return transactions.toArray(new Transaction[0]);
    }
}
