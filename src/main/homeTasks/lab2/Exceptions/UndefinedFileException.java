package main.homeTasks.lab2.Exceptions;

public class UndefinedFileException extends Exception {
    @Override
    public String getMessage(){
        return "Invalid file";
    }
}
