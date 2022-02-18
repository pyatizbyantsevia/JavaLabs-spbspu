package main.homeTasks.lab7;

import java.util.concurrent.ThreadFactory;

public class ConsumerNameThreadFactory implements ThreadFactory {
    private int num;

    @Override
    public Thread newThread(Runnable r) {
        num++;
        return new Thread(r, "Consumer-" + num);
    }
}