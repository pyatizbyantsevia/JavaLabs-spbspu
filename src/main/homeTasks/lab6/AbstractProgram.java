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
        System.out.println("AbstractProgram is working");
        while (true) {
            Thread daemon = new Thread() {
              @Override
              public void run()
              {
                  System.out.println("Daemon thread is working");
                  abstractProgCondition = randomCondition();
                  System.out.println(abstractProgCondition);
              }
            };
            daemon.setDaemon(true);
            daemon.start();
            Utils.sleep(3000);
        }
    }
}
