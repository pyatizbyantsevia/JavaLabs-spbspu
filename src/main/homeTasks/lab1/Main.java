package main.homeTasks.lab1;

import main.homeTasks.lab1.strategies.*;

class Main {

    public static void main(String[] args) {
        //Если сделать это через анонимные классы, будет ли это паттерном проектирования?
        Hero hero = new Hero();
        hero.move();

        hero.changeMovingStrategy(new StrategyRideAHorse());
        hero.move();

        hero.changeMovingStrategy(new StrategyFly());
        hero.move();

    }
}
