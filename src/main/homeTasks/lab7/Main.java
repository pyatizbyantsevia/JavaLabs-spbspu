package main.homeTasks.lab7;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

class Main {
    public static void main(String[] args) {

        Random random = new Random();
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        ExecutorService writeService = Executors.newFixedThreadPool(Integer.parseInt(args[0]), new ProducerNameThreadFactory());
        ExecutorService readService = Executors.newFixedThreadPool(Integer.parseInt(args[0]), new ConsumerNameThreadFactory());

        for (int i = 0; i < 10; i++) {
            writeService.execute(() -> {
                String message = "Message= " + random.nextInt(500) + " from " + Thread.currentThread().getName();
                try {
                    queue.put(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            readService.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " has read: " + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        writeService.shutdown();
        readService.shutdown();
    }
}
