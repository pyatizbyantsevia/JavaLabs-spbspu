package main.homeTasks.lab6;

import java.util.Random;

import static main.homeTasks.lab6.ColorsPull.*;

class AbstractProgram implements Runnable {

    public static Object mutex = new Object();
    public static Conditions abstractProgCondition = Conditions.UNKNOWN;
    public static Boolean interruptFlag = false;

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
        System.out.println(ANSI_GREEN + "AbstractProgram: started" + ANSI_RESET);
        Thread daemon = new Thread() {
            @Override
            public void run()
            {
                while (true) {
                    if (interruptFlag) {
                        break;
                    }
                    Utils.sleep(10000);
                    synchronized (mutex) {
                        System.out.println(ANSI_GREEN + "Current abstractProgCondition = " + abstractProgCondition + ANSI_RESET);
                        abstractProgCondition = randomCondition();
                        System.out.println(ANSI_GREEN + "New abstractProgCondition = " + abstractProgCondition + ANSI_RESET);
                        mutex.notify();
                    }
                }
            }
        };
        daemon.setDaemon(true);
        daemon.start();
    }
}
