package main.homeTasks.lab1;

import main.homeTasks.lab1.strategies.*;

public class Hero {

    private MoveStrategy moveStrategy;
    private int currentLocation;

    Hero() {
        moveStrategy = new StrategyWalk();
        System.out.println("Hero constructed \n" + moveStrategy.heroCondition() + '\n');
    }
    void changeMovingStrategy(MoveStrategy strategy) {
        moveStrategy = strategy;
        System.out.println(strategy.heroCondition() + '\n');
    }
    void move()
    {
        currentLocation += moveStrategy.move();
        System.out.println("Hero in " + currentLocation + '\n');
    }

}
