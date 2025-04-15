package day00.ex01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("->");
        int number = scanner.nextInt();
        if (number <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        if (number == 2) {
            System.out.print("true ");
            System.out.println(1);
            System.exit(0);
        }

        int i;
        for (i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                System.out.print("false ");
                System.out.println(i - 1);
                System.exit(0);
            }
        }
        System.out.print("true ");
        System.out.println(i - 1);

    }
}
