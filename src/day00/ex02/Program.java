package day00.ex02;

import java.util.Scanner;

public class Program {

    public static int sum (int number){
        int result = 0;
        while (number > 10){
            result += number % 10;
            number  = number / 10;
        }
        result += number;
        return result;
    }

    public static boolean isPrime (int number){
        if (number <= 1)
            return false;
        if (number == 2)
            return true;

        int i ;
        for(i = 3; i <= Math.sqrt(number); i+=2){
            if (number % i == 0)
                return false;
        }
       return true;
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int requestCount = 0;
        System.out.print("->");
        int number = scan.nextInt();
        while (number != 42){

            int sum = sum(number);
            if (isPrime(sum))
                requestCount++;
            System.out.print("->");
            number = scan.nextInt();
        }
        System.out.print("Count of coffee-request: ");
        System.out.println(requestCount);

    }
}
