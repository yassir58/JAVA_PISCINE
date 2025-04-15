package day01.ex00;
public class Program {

   public static void main(String[] args){

       User nassim = new User("Nassim", 1000);
       User yassine = new User("Yassine", 2000);
       User ahmed = new User("Ahmed", 3000);
       Transaction t1 = new Transaction(nassim, yassine, Transaction.Category.CREDIT, 100);
       Transaction t2 = new Transaction(yassine, ahmed, Transaction.Category.CREDIT, 3500);
       Transaction t3 = new Transaction(ahmed, nassim, Transaction.Category.DEBIT, 500);

       t1.processTransaction();
       t1.printTransaction();
       t2.processTransaction();
       t2.printTransaction();
       t3.processTransaction();
       t3.printTransaction();
    }
}
