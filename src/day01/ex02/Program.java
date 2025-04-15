package day01.ex02;

public class Program {

    public static void main(String[] args) {


        // testing UsersArrayList initialization
        UsersArrayList users = new UsersArrayList();

        System.out.println("UsersArrayList initialized with size: " + users.getUserCount());
        // testing adding users
        users.addUser(new User("Nassim", 1000));
        users.addUser(new User("Yassine", 2000));
        System.out.println("Users added: " + users.getUserCount());
        // testing getting user by id
        try {
            User user = users.getUserById(1);
            System.out.println("User found: " + user.getName());
        } catch (UserNotFoundException e) {
            System.out.println("User not found");
        }
        try {
            User user = users.getUserById(10);
            System.out.println("User found: " + user.getName());
        } catch (UserNotFoundException e) {
            System.out.println(e);
        }

        // testing getting user by index
        try {
            User user = users.getUserByIndex(0);
            System.out.println("User found: " + user.getName());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        try {
            User user = users.getUserByIndex(12);
            System.out.println("User found: " + user.getName());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        // testing user count
        System.out.println("User count: " + users.getUserCount());
    }
}
