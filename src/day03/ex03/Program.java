package day03.ex03;


import java.io.FileNotFoundException;

public class Program {

    public static void main(String[] args) throws FileNotFoundException {

        if (args.length != 1) {
            System.out.println("Invalid arguments. Usage: java Program  --threadCount=<thread_count>");
            return;
        }
        if (!args[0].split("=")[0].equals("--threadCount") ) {
            System.out.println("Invalid argument. Usage: java Program -  --threadCount=<thread_count>");
            return;
        }
        int threadCount = Integer.parseInt(args[0].split("=")[1]);
        if (threadCount < 1) {
            System.out.println("Invalid argument. Usage: java Program  --threadCount=<thread_count>");
            return;
        }
        // generate random numbers in array

        ThreadManager mainThread = new ThreadManager(threadCount);
        mainThread.startThreads();
        mainThread.waitForThreads();

    }
}
