package main.homeTasks.lab3;

import main.homeTasks.lab3.animal.Animal;
import main.homeTasks.lab3.animal.vertebrata.mammalia.primates.Primates;
import main.homeTasks.lab3.animal.vertebrata.mammalia.primates.homo.Homo;

public class Main {
    public static void main(String[] args) {
        Animal homo1 = new Homo();
        Animal homo2 = new Primates();

        Queue<Animal> queue = new Queue();
        queue.add(homo1);
        queue.add(homo2);

    }
}
