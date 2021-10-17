// Это второй вариант решения задачи
// При выборе этого варианта классы StrategyFly, StrategyRideAHorse, StrategyWalk можно удалить

package main.homeTasks.lab1;

import main.homeTasks.lab1.strategies.MoveStrategy;

public class TestAnonimClasses {
    public static void main(String[] args) {
        
        // Если сделать это через анонимные классы, будет ли это паттерном проектирования? (на первый взгляд - да)

        MoveStrategy walk = new MoveStrategy() {
            @Override
            public int move() {
                return 1;
            }
            @Override
            public String heroCondition() {
                return "Hero with legs";
            }
        };
        MoveStrategy ride = new MoveStrategy() {
            @Override
            public int move() {
                return 2;
            }
            @Override
            public String heroCondition() {
                return "Hero with horse";
            }
        };
        MoveStrategy fly = new MoveStrategy() {
            @Override
            public int move() {
                return 3;
            }
            @Override
            public String heroCondition() {
                return "Hero with baloon";
            }
        };

        Hero hero = new Hero();
        hero.changeMovingStrategy(walk);
        hero.move();

        hero.changeMovingStrategy(ride);
        hero.move();

        hero.changeMovingStrategy(fly);
        hero.move();
    }
}

//    Стратегия — поведенческий шаблон проектирования,
//    предназначенный для определения семейства алгоритмов,
//    инкапсуляции каждого из них и обеспечения их взаимозаменяемости.
//    Это позволяет выбирать алгоритм путём определения соответствующего класса.
