

public class EX00 {

    static int number = 479598 ;
    static int result = 0;
    public static void main(String[] args){

       while (number > 10){
           result += number % 10;
           number  = number / 10;
       }
       result += number;
       System.out.println("the result : ");
       System.out.println(result);

   }
}


