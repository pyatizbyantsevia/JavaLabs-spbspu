package main.homeTasks.lab4;

public class MyClass {
    @MyAnnotation(1)
    private void firstMethod() {
        System.out.println("Первый вызван");
    }

    @MyAnnotation(2)
    private void secondMethod() {
        System.out.println("Второй вызван");
    }
    private void thirdMethod() {
    }
}
