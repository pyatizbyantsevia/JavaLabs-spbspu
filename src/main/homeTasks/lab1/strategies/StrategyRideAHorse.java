package main.homeTasks.lab1.strategies;

public class StrategyRideAHorse extends MoveStrategy {

    @Override
    public int move() {
        return 2;
    }
    @Override
    public String heroCondition(){
        return "Hero with horse";
    }
}
