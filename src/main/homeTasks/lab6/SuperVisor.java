package main.homeTasks.lab6;

import static main.homeTasks.lab6.ColorsPull.*;

public class SuperVisor implements Runnable{

    private static Thread abstractProgram = new Thread(new AbstractProgram());

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "SuperVisor: started" + ANSI_RESET);
        abstractProgram.start();
        while (!AbstractProgram.interruptFlag) {
            synchronized (AbstractProgram.mutex) {
                try {
                    System.out.println(ANSI_BLUE + "SuperVisor: wait" + ANSI_RESET);
                    AbstractProgram.mutex.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(ANSI_BLUE + "SuperVisor: notified" + ANSI_RESET);
            }
            if (AbstractProgram.abstractProgCondition == AbstractProgram.Conditions.UNKNOWN) {
                restartProgram();
            } else if (AbstractProgram.abstractProgCondition == AbstractProgram.Conditions.STOPPING) {
                restartProgram();
            } else if (AbstractProgram.abstractProgCondition == AbstractProgram.Conditions.FATAL_ERROR) {
                stopProgram();
            } else {
                System.out.println(ANSI_BLUE + "SuperVisor: abstractProgram is OK" + ANSI_RESET);
            }
        }
    }

    private void restartProgram() {
        AbstractProgram.abstractProgCondition = AbstractProgram.Conditions.RUNNING;
        System.out.println(ANSI_BLUE + "SuperVisor: restart program" + ANSI_RESET);
    }

    private void stopProgram() {
        AbstractProgram.interruptFlag = true;
        System.out.println(ANSI_BLUE + "SuperVisor: stop program" + ANSI_RESET);
    }


    public static void main(String[] args) {
        new Thread(new SuperVisor()).start();
    }
}
