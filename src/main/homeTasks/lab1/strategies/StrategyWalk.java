package main.homeTasks.lab1.strategies;

public class StrategyWalk extends MoveStrategy {

    @Override
    public int move() {
        return 1;
    }
    @Override
    public String heroCondition(){
        return "Hero with legs";
    }
}
