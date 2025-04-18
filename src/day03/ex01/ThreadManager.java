package day03.ex01;

import java.io.FileWriter;
import java.io.IOException;

// Method 1: Create a class that implements Runnable
class Egg implements Runnable {

        private String value;
        private int count;

        public Egg(String value, int count) {
            this.value = value;
            this.count = count;
        }
        @Override
        public void run() {
            synchronized (System.out) {
                for (int i = 0; i < this.count; i++) {
                    System.out.println("Egg");
                }
            }
        }
    }
// Method 2: Create a class that extends Thread
 class Hen extends Thread {

    private String value;
    private int count;

    public Hen(String value, int count) {
        this.value = value;
        this.count = count;
    }
     public void run() {
            synchronized (System.out) {
                for (int i = 0; i < this.count; i++) {
                    System.out.println("Henny");
                }
            }
     }
 }
public class ThreadManager {

        private  Egg eggRunnable;
        private  Thread eggThread;
        private  Hen hennyRunnable;
        private  int n;

        public ThreadManager(int n) {
            eggRunnable = new Egg("Egg", n);
            hennyRunnable = new Hen("Henn", n);
            eggThread = new Thread(eggRunnable);
            this.n = n;
        }

        public void startThreads () {
            eggThread.start();
            hennyRunnable.start();
        }

        public void waitForThreads () {
            try {
                eggThread.join();
                hennyRunnable.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


}
