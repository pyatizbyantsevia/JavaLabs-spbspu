package main.homeTasks.lab2.Exceptions;

public class DivideNullException extends Exception {

    public void errorDetail(){
        System.err.println("Произошло деление на 0");
    }
}
