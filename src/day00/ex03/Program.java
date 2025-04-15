package day00.ex03;

import java.util.Scanner;


public class Program {


    static int getNextIntMin (String input){
        Scanner scanner = new Scanner(input);
        int minimun = Integer.MAX_VALUE;

        // Read integers one by one
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number < minimun)
                    minimun = number;
        }
        return minimun;
    }

    static void printGraphColumn (int min, int week){

        System.out.print("Week " + week + " ");
        for (int i = 0; i < min; i++){
            System.out.print ('=');
        }
        System.out.println (">");

    }
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);
        String input = "";
        int count = 0;
        int week = count + 1;
        String identif = "Week "  + week;
        String grades = "";
        int minArray[] = new int[18];

        System.out.print("-> ") ;
        input = scn.nextLine();
        while (!input.equals("42") && count < 18){
            if (!input.equals(identif)){
                System.err.println("IllegalArgument");
                System.out.println(input);
                System.exit(-1);
            }
            System.out.print("-> ") ;
            grades = scn.nextLine();
            int min = getNextIntMin (grades);
            minArray[week - 1] = min;
            count++;
            week = count+1;
            identif = "Week "+ week;
            System.out.print("-> ") ;
            input = scn.nextLine();
        }

        for (int i = 0; i < count; i++){
            printGraphColumn(minArray[i], i+1);
        }



    }

}
