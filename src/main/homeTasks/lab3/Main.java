package main.homeTasks.lab3;

import main.homeTasks.lab3.animal.Animal;
import main.homeTasks.lab3.animal.vertebrata.Vertebrata;
import main.homeTasks.lab3.animal.vertebrata.mammalia.Mammalia;
import main.homeTasks.lab3.animal.vertebrata.mammalia.cat.Cat;
import main.homeTasks.lab3.animal.vertebrata.mammalia.cat.assasin.Assasin;
import main.homeTasks.lab3.animal.vertebrata.mammalia.cat.assasin.UltraAssasin.UltraAssasin;
import main.homeTasks.lab3.animal.vertebrata.mammalia.primates.Primates;
import main.homeTasks.lab3.animal.vertebrata.mammalia.primates.homo.Homo;
import main.homeTasks.lab3.animal.vertebrata.mammalia.primates.homo.sapiens.Sapiens;

public class Main {
    public static void main(String[] args) {
        try {
            Queue<? extends Vertebrata> queue = Queue.produce(7);
            System.out.println("Produce method:");
            queue.print();

            System.out.println("Consume method:");
            Queue.consume(queue);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
