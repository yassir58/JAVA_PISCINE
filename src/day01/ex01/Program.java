package day01.ex01;
public class Program {

   public static void main(String[] args){

       User nassim = new User("Nassim", 1000);
       User yassine = new User("Yassine", 2000);
       User ahmed = new User("Ahmed", 3000);

       System.out.printf("User %s has id %d and balance %f\n", nassim.getName(), nassim.getId(), nassim.getBalance());
       System.out.printf("User %s has id %d and balance %f\n", yassine.getName(), yassine.getId(), yassine.getBalance());
       System.out.printf("User %s has id %d and balance %f\n", ahmed.getName(), ahmed.getId(), ahmed.getBalance());
         System.out.printf("User %s has id %d and balance %f\n", User.userCount, ahmed.getId(), ahmed.getBalance());
    }
}
