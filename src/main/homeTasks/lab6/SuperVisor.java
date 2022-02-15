package main.homeTasks.lab6;

public class SuperVisor implements Runnable{

    private static Thread abstractProgram = new Thread(new AbstractProgram());

    @Override
    public void run() {
        System.out.println("SuperVisor started");
        abstractProgram.start();
        while (!abstractProgram.isInterrupted()) {
            if (AbstractProgram.abstractProgCondition == AbstractProgram.Conditions.UNKNOWN) {

            } else if (AbstractProgram.abstractProgCondition == AbstractProgram.Conditions.STOPPING) {

            }
        }
    }

    public static void main(String[] args) {
        new Thread(new SuperVisor()).start();
    }
}
