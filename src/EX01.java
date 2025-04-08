import java.util.Scanner;
import java.util.SortedMap;

public class EX01 {

    public static void main(String[] args){

        Scanner scann = new Scanner(System.in);
        System.out.print("->");
        int number = scann.nextInt();
        if (number <= 1)
        {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        if (number == 2){
            System.out.print("true ");
            System.out.println(1);
            System.exit(0);
        }

        int i ;
        for(i = 3; i <= Math.sqrt(number); i+=2){
            if (number % i == 0){
                System.out.print("false ");
                System.out.println(i-1);
                System.exit(0);
            }
        }
        System.out.print("true ");
        System.out.println(i-1);

    }
}
