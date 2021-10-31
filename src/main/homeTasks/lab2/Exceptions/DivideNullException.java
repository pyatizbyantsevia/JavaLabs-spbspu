package main.homeTasks.lab2.Exceptions;

public class DivideNullException extends Exception {
    @Override
    public String getMessage(){
        return "Делить на 0 низя";
    }
}
