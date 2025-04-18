package day03.ex03;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

// Method 1: Create a class that implements Runnable
class Downloader implements Runnable {
    BufferedReader reader;
    private int i;
    private CountDownLatch latch;

    public Downloader(BufferedReader reader, int i, CountDownLatch latch) {
        this.reader = reader;
        this.i = i;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            if (reader == null) {
                System.err.println("Reader is null");
                return;
            }
            synchronized (reader) {
                String line;
                try {
                    line = reader.readLine();
                    if (line == null) {
                        System.out.println("thread: " + i + " finished downloading files.");
                    }
                    if (line != null) {
                        System.out.println("thread: " + i + " start downloading file number " + line + ".......");
                        try {
                            URI uri = new URI(line);
                            URL url = uri.toURL();
                            URLConnection connection = url.openConnection();

                            try (InputStream in = connection.getInputStream();
                                 FileOutputStream out = new FileOutputStream(line.substring(line.lastIndexOf("/") + 1))) {

                                byte[] buffer = new byte[4096];
                                int bytesRead;

                                while ((bytesRead = in.read(buffer)) != -1) {
                                    out.write(buffer, 0, bytesRead);
                                }
                            }

                            System.out.println("File saved as: " + line.substring(line.lastIndexOf("/") + 1));
                        } catch (Exception e) {
                            System.err.println("Invalid URI: " + line);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            latch.countDown(); // Notify that this thread has finished
        }
    }
}

public class ThreadManager {

        private  Thread Thread;
        private  int n;
        private  int array[];
        private  int threadCount;
        private  Thread[] threads;
        private  int[] threadSums;
        BufferedReader reader;
        private CountDownLatch latch;

        public ThreadManager(int threadCount)  {

            this.threadCount = threadCount;
            this.latch = new CountDownLatch(threadCount); // Initialize latch with the number of threads
            try {
                reader = new BufferedReader(new FileReader("/Users/yassir/Desktop/CURSUS/JAVA_PISCINE_OBJECT/src/day03/ex03/data.txt"));
            } catch (IOException e) {
                System.err.println("File not found: " + e.getMessage());
            }
            threads = new Thread[threadCount];
            threadSums = new int[threadCount];
        }

    public void startThreads() {
        for (int i = 0; i < threadCount; i++) {
            Thread eggThread = new Thread(new Downloader(reader, i, latch)); // Pass latch to Downloader
            threads[i] = eggThread;
            eggThread.start();
        }
    }


    public void waitForThreads() {
        try {
            latch.await(); // Wait for all threads to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}


