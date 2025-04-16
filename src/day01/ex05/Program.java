package day01.ex05;

public class Program {

    public static void main(String[] args) throws Exception {

        if (args.length == 0){
            throw new Exception("Invalid number of arguments");
        }
        String[] profileString = args[0].split("=");
        if (profileString.length != 2){
            throw new Exception("Invalid format");
        }
        System.out.println(profileString[0]);
        System.out.println(profileString[1]);
        if (!profileString[0].equals("--profile")){
            throw new Exception("Invalid format");
        }
        if (!profileString[1].equals("dev") && !profileString[1].equals("prod")){
            throw new Exception("Invalid profile");
        }
        Menu menu = new Menu(profileString[1]);
        menu.startMenu();

    }
}
