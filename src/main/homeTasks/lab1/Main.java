package main.homeTasks.lab1;

import main.homeTasks.lab1.strategies.*;

class Main {

    private static StrategyFly balloon = new StrategyFly();
    private static StrategyRideAHorse horse = new StrategyRideAHorse();
    private static StrategyWalk legs = new StrategyWalk();

    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.move();

        hero.changeMovingStrategy(horse);
        hero.move();

        hero.changeMovingStrategy(balloon);
        hero.move();

    }
}
