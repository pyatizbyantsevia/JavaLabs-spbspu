package main.homeTasks.lab6;

import java.util.Random;

class AbstractProgram implements Runnable {

    public static Condition abstractProgCondition = Condition.UNKNOWN;

    public enum Condition {
        UNKNOWN,
        STOPPING,
        RUNNING,
        FATAL_ERROR
    }

    @Override
    public void run() {
        while (true) {
            Thread daemon = new Thread() {
              @Override
              public void run()
              {
                  Random random = new Random();
                  abstractProgCondition.
              }
            };
            daemon.setDaemon(true);
            Utils.sleep(3000);
            System.out.println("I am AbstractProgram and I'm working");
        }
    }
}
