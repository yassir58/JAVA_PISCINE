package day03.ex02;



public class Program {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Invalid arguments. Usage: java Program --arraySize=<iteration_count> --threadCount=<thread_count>");
            return;
        }
        if (!args[0].split("=")[0].equals("--arraySize") || !args[1].split("=")[0].equals("--threadCount")) {
            System.out.println("Invalid argument. Usage: java Program --count=<iteration_count>  --threadCount=<thread_count>");
            return;
        }
        int iterationCount = Integer.parseInt(args[0].split("=")[1]);
        int threadCount = Integer.parseInt(args[1].split("=")[1]);
        if (threadCount < 1) {
            System.out.println("Invalid argument. Usage: java Program --count=<iteration_count>  --threadCount=<thread_count>");
            return;
        }
        // generate random numbers in array

        ThreadManager mainThread = new ThreadManager(iterationCount, threadCount);
        mainThread.printArray();
        mainThread.printArraySum();
        mainThread.startThreads();
        mainThread.waitForThreads();

    }
}
