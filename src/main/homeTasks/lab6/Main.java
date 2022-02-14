package main.homeTasks.lab6;


public class Main {

    static class AbstractProg implements Runnable {

        @Override
        public void run() {

        }

        Condition currentCondition = Condition.UNKNOWN;
        enum Condition {
            UNKNOWN,
            STOPPING,
            RUNNING,
            FATAL_ERROR
        }
    }

    public static void main(String[] args) {
        new Thread(new AbstractProg()).start();
        while(true) {

        }
    }
}
