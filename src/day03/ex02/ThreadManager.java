package day03.ex02;

import java.io.FileWriter;
import java.io.IOException;

// Method 1: Create a class that implements Runnable
class Counter implements Runnable {

        private int startIndex;
        private int endIndex;
        private int[] array;
        private int sum;
        private int threadIndex;
        private int[] threadSums;

        public Counter(int startIndex, int endIndex, int[] array, int threadIndex, int[] threadSums) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.array = array;
            this.sum = 0;
            this.threadIndex = threadIndex;
            this.threadSums = threadSums;
        }
        @Override
        public void run() {
            synchronized (array) {
                for (int i = startIndex; i < this.endIndex; i++) {
                    sum += array[i];
                }
                System.out.printf("Thread %d: from %d to %d sum is %d\n", threadIndex, startIndex, endIndex, sum);
            }
            threadSums[threadIndex] = sum;
        }
    }

public class ThreadManager {

        private  Thread Thread;
        private  int n;
        private  int array[];
        private  int threadCount;
        private  Thread[] threads;
        private  int[] threadSums;

        public ThreadManager(int n, int threadCount) {
            this.n = n;
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = (int) (Math.random() * 100);
            }
            this.threadCount = threadCount;
            threads = new Thread[threadCount];
            threadSums = new int[threadCount];
        }

        public void startThreads () {
            for (int i = 0; i < threadCount; i++) {
                Thread eggThread = new Thread (new Counter( i * (n / threadCount), (i + 1) * (n / threadCount), array, i, threadSums));
                threads[i] = eggThread;
                eggThread.start();
            }
        }

        public void printArray () {
            for (int i = 0; i < n; i++) {
                System.out.print(array[i] + " ");
            }
        }
        public void printArraySum () {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += array[i];
            }
            System.out.println("Sum of array is: " + sum);
        }

        public void printThreadSums () {
            int sum = 0;
            for (int i = 0; i < threadCount; i++) {
                sum += threadSums[i];
            }
            System.out.println("Sum of thread result is: " + sum);
        }
        public void waitForThreads () {
            for (int i = 0; i < threadCount; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


}
