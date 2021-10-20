package main.homeTasks.lab1;

import main.homeTasks.lab1.strategies.*;

class Main {

    public static void main(String[] args) {

        Hero hero = new Hero();
        hero.move();

        hero.changeMovingStrategy(new StrategyRideAHorse());
        hero.move();

        hero.changeMovingStrategy(new StrategyFly());
        hero.move();

    }
}
