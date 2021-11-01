package main.homeTasks.lab2.Exceptions;

public class MatrixSizeOverflow extends Exception {
    @Override
    public String getMessage(){
        return "N is too big";
    }
}
