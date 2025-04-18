package day03.ex00;



public class Program {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Invalid arguments. Usage: java Program --count=<iteration_count> ");
            return;
        }
        if (!args[0].split("=")[0].equals("--count")) {
            System.out.println("Invalid argument. Usage: java Program --count=<iteration_count> ");
            return;
        }
        int iterationCount = Integer.parseInt(args[0].split("=")[1]);
        ThreadManager mainThread = new ThreadManager(iterationCount);
        mainThread.startThreads();
        mainThread.waitForThreads();
        for (int i = 0; i < iterationCount; i++) {
            System.out.println("Human");
        }
    }
}
