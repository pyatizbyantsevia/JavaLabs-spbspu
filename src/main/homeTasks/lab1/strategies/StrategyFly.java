package main.homeTasks.lab1.strategies;

public class StrategyFly extends MoveStrategy {

    @Override
    public int move() {
        return 3;
    }
    @Override
    public String heroCondition(){
        return "Hero with balloon";
    }
}
