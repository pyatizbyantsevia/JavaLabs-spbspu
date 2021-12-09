package main.homeTasks.lab3;

import main.homeTasks.lab3.animal.Animal;
import main.homeTasks.lab3.animal.vertebrata.Vertebrata;
import main.homeTasks.lab3.animal.vertebrata.mammalia.Mammalia;
import main.homeTasks.lab3.animal.vertebrata.mammalia.cat.Cat;
import main.homeTasks.lab3.animal.vertebrata.mammalia.primates.Primates;
import main.homeTasks.lab3.animal.vertebrata.mammalia.primates.homo.Homo;

public class Main {
    public static void main(String[] args) {

        Queue<Animal> queue = new Queue();
        queue.add(new Cat());
        queue.add(new Primates());
        queue.add(new Animal());
        queue.add(new Mammalia());
        queue.print();
        System.out.println("---------");
        Queue<Animal> zalupa = queue.produce(queue);
        zalupa.print();

    }
}
