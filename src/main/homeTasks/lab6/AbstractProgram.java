package main.homeTasks.lab6;

import java.util.Random;

class AbstractProgram implements Runnable {

    public static Object mutex = new Object();
    public static Conditions abstractProgCondition = Conditions.UNKNOWN;

    public enum Conditions {
        UNKNOWN,
        STOPPING,
        RUNNING,
        FATAL_ERROR
    }

    private static Conditions randomCondition() {
        int pick = new Random().nextInt(Conditions.values().length);
        return Conditions.values()[pick];
    }

    @Override
    public void run() {
        System.out.println("I am AbstractProgram and I'm working");
        while (true) {
            Thread daemon = new Thread() {
              @Override
              public void run()
              {
                  System.out.println("I am daemon thread and I'm working");

                  synchronized (mutex) {
                      abstractProgCondition = randomCondition();
                  }
              }
            };
            daemon.setDaemon(true);
            Utils.sleep(3000);
        }
    }
}
