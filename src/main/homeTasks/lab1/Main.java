package main.homeTasks.lab1;

import main.homeTasks.lab1.strategies.*;

class Main {

    private static StrategyFly flying = new StrategyFly();
    private static StrategyRideAHorse riding = new StrategyRideAHorse();
    private static StrategyWalk walking = new StrategyWalk();

    public static void main(String[] args) {
        StrategyFly sf = new StrategyFly();

        Hero hero = new Hero(flying);
        hero.move();
        hero.changeMovingStrategy(riding);
        hero.move();
        hero.changeMovingStrategy(walking);
        hero.move();
    }
}
