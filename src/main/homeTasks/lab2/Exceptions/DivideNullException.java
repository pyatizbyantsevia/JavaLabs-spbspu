package main.homeTasks.lab2.Exceptions;

public class DivideNullException extends Exception {
    @Override
    public String getMessage(){
        return "Division by zero occurred";
    }
}
