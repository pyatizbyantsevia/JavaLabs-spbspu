package main.homeTasks.lab1;

import main.homeTasks.lab1.strategies.*;

public class Hero {

    private static MoveStrategy moveStrategy;
    private int currentLocation;
    {
        currentLocation = 0;
        moveStrategy = new StrategyWalk();
        System.out.println(moveStrategy.heroCondition());
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
