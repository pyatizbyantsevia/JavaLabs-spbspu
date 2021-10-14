package main.homeTasks.lab1;

import main.homeTasks.lab1.strategies.*;

class Main {

    private static StrategyFly flying = new StrategyFly();
    private static StrategyRideAHorse riding = new StrategyRideAHorse();
    private static StrategyWalk walking = new StrategyWalk();

    public static void main(String[] args) {
        Hero hero = new Hero(walking);
        hero.move();
        hero.changeMovingStrategy(riding);
        hero.move();
        hero.changeMovingStrategy(flying);
        hero.move();
    }
}
