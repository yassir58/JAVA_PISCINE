package day00.ex05;

import java.util.Scanner;

public class Program {

    public static void main(String[] argv){

        Scanner scanner = new Scanner(System.in);
        int i = 0;
        String names[] = new String[10];
        System.out.print ("->");
        String name = scanner.nextLine();
        while (i < 10){

            if (name.equals("."))
                break;
            if (name.length() > 10){
                System.err.println("Error: name should be less than 10 characters");
                System.exit(-1);
            }
            if (name.indexOf(' ') != -1){
                System.err.println("Error: name should not have spaces");
                System.exit(-1);
            }
            names[i] = name;
            System.out.print ("->");
            name = scanner.nextLine();
            i++;
        }


    }
}
