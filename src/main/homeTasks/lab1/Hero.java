package main.homeTasks.lab1;

import main.homeTasks.lab1.strategies.MoveStrategy;

class Hero {
    private MoveStrategy moveStrategy;

    Hero(MoveStrategy strategy) {
        changeMovingStrategy(strategy);
    }
    void changeMovingStrategy(MoveStrategy strategy) {
        moveStrategy = strategy;
    }
    void move()
    {
        moveStrategy.move();
    }
}
