package day00.ex04;

import java.util.Scanner;

public class Program {


    public static void printColumn (char c, int count){
        System.out.printf("%c ", c);
        int i = 0;
        while (i < count){
            System.out.printf ("# ");
            i++;
        }
        System.out.printf ("%d%n", count);
    }
    public static  char printMax(String str, int count[], String maxString){

        int len =  str.length();
        char arr[] = str.toCharArray();
        char maxIndex = 0;
        int max = 0;
        for (int i =0; i < len;i++){
            if (maxString.indexOf(arr[i]) == -1){
                int charCount = count[(int)arr[i]];
                if (charCount > max)
                {
                    max = charCount;
                    maxIndex = arr[i];
                }
            }
        }

        return maxIndex;
    }
    public static void main(String argv[]){
        Scanner scanner = new Scanner (System.in);
        System.out.print("->");
        String  text   = scanner.nextLine();
        int     countArray[] = new int[65535];
        char c = 0;
        char charArr[] = text.toCharArray();
        int len = text.length();

        for (int i = 0; i < len; i++){
            char ch = charArr[i];
            int ascii = (int) ch;
            countArray[ascii] += 1;
        }

        String tempstring = "";
        int count = 0;

        for (int i = 0; i < 65535; i++){
            if (countArray[i]>0){
                char ch = (char) i;
                count++;
                tempstring += ch;
            }
        }


        String maxString =  "";

        while (count != 0){
            // print max
            char temp = printMax(tempstring, countArray, maxString);
            printColumn(temp, countArray[(int)temp]);
            maxString += temp;
            count--;
        }
    }
}
